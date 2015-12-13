/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Chamado;
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
public class ChamadoDao {
    
    public static Chamado vaPara(String id) {
        Chamado chamado = new Chamado();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT c FROM Chamado c WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT c FROM Chamado c WHERE id = " + id;
            }
            DAO<Chamado> dao = new DAO<>();
            List<Chamado> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                chamado = null;
            } else {
                chamado = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chamado;
    }
    public static void salvar(Chamado chamado) {
        DAO<Chamado> dao = new DAO<>();
        dao.save(chamado);
    }

    public static void deletar(Chamado chamado) {
        DAO<Chamado> dao = new DAO<>();
        dao.delete(chamado);
    }
    
    public static List<Chamado> obterChamado(Chamado criterio){
        
        DAO<Chamado> dao = new DAO<>();
        
        String sql = "SELECT c FROM Chamado c";
        ArrayList<String> where = new ArrayList<>();

        if (criterio != null) {
            
            if (criterio.getId() != 0) {
                where.add(" id = " + criterio.getId());
            }
            
            if (criterio.getTitulo() != null && !criterio.getTitulo().equals("")) {
                where.add(" titulo = '" + criterio.getTitulo() + "'");
            }

            if (criterio.getFuncionarioByFuncionarioSolicitanteId() != null && !criterio.getFuncionarioByFuncionarioSolicitanteId().equals("")) {
                where.add(" funcionario_solicitante_id = '" + criterio.getFuncionarioByFuncionarioSolicitanteId() + "'");
            }
            
            if (criterio.getFuncionarioByFuncionarioAberturaId() != null && !criterio.getFuncionarioByFuncionarioAberturaId().equals("")) {
                where.add(" funcionario_abertura_id = '" + criterio.getFuncionarioByFuncionarioAberturaId() + "'");
            }
            
            if (criterio.getFuncionarioByFuncionarioAtendenteId() != null && !criterio.getFuncionarioByFuncionarioAtendenteId().equals("")) {
                where.add(" funcionario_atendente_id = '" + criterio.getFuncionarioByFuncionarioAtendenteId() + "'");
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
        List<Chamado> chamado = dao.query(sql);
        
        return chamado;
    }
    
    public static void popularTabela(JTable tabela, Chamado criterio) {

        DAO<Chamado> dao = new DAO<>();
        List<Chamado> chamado;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Id";
        cabecalho[1] = "Título";
        cabecalho[2] = "Solicitante";
        cabecalho[3] = "Atribuído para";
        cabecalho[4] = "Situção";
        cabecalho[5] = "Data de Abertura";
        cabecalho[6] = "Data prevista";

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql = "SELECT COUNT(*) FROM Chamado";
            Integer result = Integer.parseInt(dao.count(sql).toString());

            dadosTabela = new Object[result][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar qtde chamados: " + e);
        }

        chamado = obterChamado(criterio);

        // efetua consulta de dados no banco e atribui no componente JTable
        try {
            for (int i = 0; i < chamado.size(); i++) {

                dadosTabela[i][0] = chamado.get(i).getId();
                dadosTabela[i][1] = chamado.get(i).getTitulo();
                dadosTabela[i][2] = chamado.get(i).getFuncionarioByFuncionarioSolicitanteId().getPessoa().getNome();
                dadosTabela[i][3] = chamado.get(i).getFuncionarioByFuncionarioAtendenteId().getPessoa().getNome();
                dadosTabela[i][4] = chamado.get(i).getSituacao().getDescricao();
                dadosTabela[i][5] = chamado.get(i).getDataAbertura();
                dadosTabela[i][6] = chamado.get(i).getDataPrevista();
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
