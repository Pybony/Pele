/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.control;

import br.com.chamados.model.Empresa;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Hibernate;

/**
 *
 * @author Jonas C. Rosa
 */
public class GridEmpresa {

    Hibernate session;

    public void popularTabelaEmpresa(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

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
            Long resultL = (Long) DAO.getSession().createQuery(sql).uniqueResult();
            
            Integer result = 0;
            
            try {
                result = Integer.valueOf(resultL.toString());
            } catch (Exception e) {
                System.out.println("Capacidade do Integer estourou.");
            }
            
            System.out.println(result);
            dadosTabela = new Object[result][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar qtde empresas: " + e);
        }

//        int lin = 0;

        // efetua consulta de dados no banco e atribui no componente JTable
        try {

            String sql = "SELECT c.id, c.nome, c.cgc, c.email, c.telefone"
                    + " FROM Empresa c";
            
            DAO<Empresa> empresaDao = new DAO<>();
            List<Empresa> empresa = empresaDao.query(sql);

            for (int i = 0; i < empresa.size(); i++) {
                
                Empresa objeto = empresa.get(i);
                
                int id = objeto.getId();
                String nome = objeto.getNome();
                String cgc = objeto.getCgc();
                String email = objeto.getEmail();
                String telefone = objeto.getTelefone();
                dadosTabela[i][0] = id;
                dadosTabela[i][1] = nome;
                dadosTabela[i][2] = cgc;
                dadosTabela[i][3] = email;
                dadosTabela[i][4] = telefone;

            }

            // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
//            lin++;
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
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
