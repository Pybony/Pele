/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Interacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author jonascr86
 */
public class InteracaoDao {

    public static Interacao vaPara(String id) {
        Interacao interacao = new Interacao();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT c FROM Interacao c WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT c FROM Interacao c WHERE id = " + id;
            }
            DAO<Interacao> dao = new DAO<>();
            List<Interacao> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                interacao = null;
            } else {
//                interacao = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return interacao;
    }

    public static void salvar(Interacao interacao) {
        DAO<Interacao> dao = new DAO<>();
        dao.save(interacao);
    }

    public static void deletar(Interacao interacao) {
        DAO<Interacao> dao = new DAO<>();
        dao.delete(interacao);
    }

    public static List<Interacao> obterInteracao(Interacao criterio) {

        DAO<Interacao> dao = new DAO<>();

        String sql = "SELECT c FROM Interacao c";
        ArrayList<String> where = new ArrayList<>();

        if (criterio != null) {

            if (criterio.getId() != null) {
                where.add(" id = " + criterio.getId());
            }

            if (criterio.getChamado() != null) {
                if (!criterio.getChamado().getId().equals("")) {
                    where.add(" chamado_id = '" + criterio.getChamado().getId() + "'");
                }
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
        List<Interacao> interacao = dao.query(sql);

        return interacao;
    }

    public static void popularTabela(JTable tabela, Interacao criterio) {

        DAO<Interacao> dao = new DAO<>();
        List<Interacao> interacao;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Data";
        cabecalho[2] = "Descrição";
        cabecalho[3] = "Autor";

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql = "SELECT COUNT(*) FROM Interacao "
                    + "WHERE chamado_id = " + criterio.getChamado().getId() + " "
                    + "ORDER BY data DESC";
            Integer result = Integer.parseInt(dao.count(sql).toString());

            dadosTabela = new Object[result][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar qtde interacaos: " + e);
        }

        interacao = obterInteracao(criterio);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");

        // efetua consulta de dados no banco e atribui no componente JTable
        try {
            for (int i = 0; i < interacao.size(); i++) {

                dadosTabela[i][0] = interacao.get(i).getId();
                dadosTabela[i][1] = formatter.format(interacao.get(i).getData());
                dadosTabela[i][2] = interacao.get(i).getDescricao();
                dadosTabela[i][3] = interacao.get(i).getFuncionario().getPessoa().getNome();
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
