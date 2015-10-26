/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.config.LogChamados;
import br.com.chamados.control.DAO;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Empresa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class EmpresaDao {

    static Logger logger = Logger.getLogger(LogChamados.class);

    public static boolean save(Empresa empresa) {
        boolean retorno = true;
        DAO<Empresa> dao = new DAO<>();
        retorno = dao.save(empresa);
        return retorno;
    }
    
    public static List<Empresa> obterEmpresa(Empresa criterio){
        
        DAO<Empresa> dao = new DAO<>();
        
        String sql = "SELECT c FROM Empresa c";
        ArrayList<String> where = new ArrayList<>();

        if (criterio != null) {
            
            if (criterio.getId() != 0) {
                where.add(" id = " + criterio.getId());
            }
            
            if (criterio.getNome() != null) {
                where.add(" nome = '" + criterio.getNome() + "'");
            }

            if (criterio.getCgc() != null) {
                where.add(" cgc = '" + criterio.getCgc() + "'");
            }

            if (criterio.getCidade() instanceof Cidade && criterio.getCidade().getId() != null) {
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
        List<Empresa> empresa = dao.query(sql);
        
        return empresa;
    }

    public static void popularTabela(JTable tabela, Empresa criterio) {

        DAO<Empresa> dao = new DAO<>();
        List<Empresa> empresa;

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
        cabecalho[2] = "CGC";
        cabecalho[3] = "Email";
        cabecalho[4] = "Telefone";

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql = "SELECT COUNT(*) FROM Empresa";
            Integer result = Integer.parseInt(dao.count(sql).toString());

            System.out.println(result);

            dadosTabela = new Object[result][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar qtde empresas: " + e);
        }

        empresa = obterEmpresa(criterio);

        // efetua consulta de dados no banco e atribui no componente JTable
        try {
            for (int i = 0; i < empresa.size(); i++) {

                System.out.println(empresa.get(i).getId());
                dadosTabela[i][0] = empresa.get(i).getId();
                dadosTabela[i][1] = empresa.get(i).getNome();
                dadosTabela[i][2] = empresa.get(i).getCgc();
                dadosTabela[i][3] = empresa.get(i).getEmail();
                dadosTabela[i][4] = empresa.get(i).getTelefone();
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
