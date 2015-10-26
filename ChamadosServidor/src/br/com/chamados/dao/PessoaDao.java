/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.config.LogChamados;
import br.com.chamados.control.DAO;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Pessoa;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class PessoaDao {

    static Logger logger = Logger.getLogger(LogChamados.class);

    public static boolean save(Pessoa pessoa) {
        boolean retorno = true;
        DAO<Pessoa> dao = new DAO<>();
        retorno = dao.save(pessoa);
        return retorno;
    }
    
    public static String proximoId() {
        String retorno = "1";
        DAO<Pessoa> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'pessoa'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }
    
    public static void deletar(Pessoa pessoa) {
        DAO<Pessoa> dao = new DAO<>();
        dao.delete(pessoa);
    }
    
    public static Pessoa vaPara(String id) {
        Pessoa pessoa = new Pessoa();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Pessoa p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Pessoa p WHERE id = " + id;
            }
            DAO<Pessoa> dao = new DAO<>();
            List<Pessoa> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                pessoa = null;
            } else {
                pessoa = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }
    
    public static List<Pessoa> obterPessoa(Pessoa criterio){
        
        DAO<Pessoa> dao = new DAO<>();
        
        String sql = "SELECT c FROM Pessoa c";
        ArrayList<String> where = new ArrayList<>();

        if (criterio != null) {
            
            if (criterio.getId() != 0) {
                where.add(" id = " + criterio.getId());
            }
            
            if (criterio.getNome() != null && !criterio.getNome().equals("")) {
                where.add(" nome = '" + criterio.getNome() + "'");
            }

            if (criterio.getCpf() != null && !criterio.getCpf().equals("")) {
                where.add(" cgc = '" + criterio.getCpf()+ "'");
            }

            if (criterio.getCidade() instanceof Cidade && criterio.getCidade().getId() 
                    != null && criterio.getCidade().getId() > 0) {
                where.add(" cidade_id = " + criterio.getCidade().getId());
            }
        }

        int size = where.size();
        int count = 0;
        String mount = "";

        for (String instrucao : where) {
            if (count == (size - 1)) {
                mount += instrucao;
            } else {
                mount += instrucao + " AND ";
            }
            count++;
        }

        if (!mount.equals("")) {

            sql += " WHERE " + mount;
        }
        System.out.println(sql);
        List<Pessoa> pessoa = dao.query(sql);
        
        return pessoa;
    }

    public static void popularTabela(JTable tabela, Pessoa criterio) {

        DAO<Pessoa> dao = new DAO<>();
        List<Pessoa> pessoa;

        // dados da tabela
        Object[][] dadosTabela = null;
        int id;
        String nome;
        String cgc;
        String email;
        String telefone;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "CPF";
        cabecalho[3] = "Email";
        cabecalho[4] = "Telefone";

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql = "SELECT COUNT(*) FROM Pessoa";
            Integer result = Integer.parseInt(dao.count(sql).toString());

            System.out.println(result);

            dadosTabela = new Object[result][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar qtde pessoas: " + e);
        }

        pessoa = obterPessoa(criterio);

        // efetua consulta de dados no banco e atribui no componente JTable
        try {
            for (int i = 0; i < pessoa.size(); i++) {

                System.out.println(pessoa.get(i).getId());
                dadosTabela[i][0] = pessoa.get(i).getId();
                dadosTabela[i][1] = pessoa.get(i).getNome();
                dadosTabela[i][2] = pessoa.get(i).getCpf();
                dadosTabela[i][3] = pessoa.get(i).getEmail();
                dadosTabela[i][4] = pessoa.get(i).getTelefone();
            }

        } catch (Exception e) {
            System.out.println("Problemas para popular tabela...");
            e.printStackTrace();
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }
}
