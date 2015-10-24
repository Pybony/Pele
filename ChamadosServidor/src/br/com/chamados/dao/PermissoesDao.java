/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Empresa;
import br.com.chamados.model.Pais;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Tela;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author lksbr
 */
public class PermissoesDao {

    public static Permissoes getTela(int id) {
        Permissoes permissoes = new Permissoes();
        String sql = "SELECT p FROM Permissoes p WHERE id = " + id;

        try {
            DAO<Permissoes> dao = new DAO<Permissoes>();
            permissoes = dao.query(sql).get(0);
            return permissoes;
        } catch (Exception e) {
            return null;
        }
    }

    public static void popularTabela(JTable tabela, Tela criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Inserir";
        cabecalho[3] = "Alterar";
        cabecalho[4] = "Excluir";
        cabecalho[5] = "Consultar";

        DAO<Permissoes> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Permissoes WHERE tela_id = " + criterio.getId();
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Permissoes p WHERE tela_id = " + criterio.getId();
            List<Permissoes> lista = dao.query(sql);
            int i = 0;
            for (Permissoes permissoes : lista) {
                dadosTabela[i][0] = permissoes.getUsuario().getId();
                dadosTabela[i][1] = "Teste";
                dadosTabela[i][2] = new Boolean(permissoes.getInserir());
                dadosTabela[i][3] = permissoes.getAlterar();
                dadosTabela[i][4] = permissoes.getDeletar();
                dadosTabela[i][5] = permissoes.getConsultar();
            }
            i++;
        } catch (Exception e) {
            e.printStackTrace();
        }

        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class getColumnClass(int column) {
                if (column > 1) {
                    return Boolean.class;
                }
                return Object.class;
            }
        });
    }

    public static Permissoes vaPara(String id) {
        Permissoes permissoes = new Permissoes();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Permissoes p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Permissoes p WHERE id = " + id;
            }
            DAO<Permissoes> dao = new DAO<>();
            List<Permissoes> lista = dao.query(sql);
            if (lista.size() == 0) {
                JOptionPane.showMessageDialog(null, "Id não encontrado.");
            } else {
                permissoes = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissoes;
    }
}
