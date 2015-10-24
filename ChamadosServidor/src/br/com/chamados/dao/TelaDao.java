/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Nivel;
import br.com.chamados.model.Tela;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class TelaDao {

    public static void salvar(Tela tela) {
        DAO<Tela> dao = new DAO<>();
        dao.save(tela);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Tela> dao = new DAO<>();
        Tela tela = dao.query("SELECT MAX(p) FROM Tela p").get(0);
        if (tela != null) {
            retorno = String.valueOf(tela.getId() + 1);
        }
        return retorno;
    }

    public static Tela vaPara(String id) {
        Tela tela = new Tela();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Tela p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Tela p WHERE id = " + id;
            }
            DAO<Tela> dao = new DAO<Tela>();
            List<Tela> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                tela = null;
            } else {
                tela = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tela;
    }

    public static void deletar(Tela tela) {
        DAO<Tela> dao = new DAO<>();
        dao.delete(tela);
    }

    public static Tela getTela(int id) {
        Tela tela = new Tela();
        String sql = "SELECT t FROM Tela t WHERE id = " + id;

        try {
            DAO<Tela> dao = new DAO<Tela>();
            tela = dao.query(sql).get(0);
            return tela;
        } catch (Exception e) {
            return null;
        }
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";

        DAO<Tela> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Tela WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Tela p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<Tela> lista = dao.query(sql);
            int i = 0;
            for (Tela tela:  lista) {
                dadosTabela[i][0] = tela.getId();
                dadosTabela[i][1] = tela.getDescricao();
                i++;
            }
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
}
