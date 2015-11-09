/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Prioridade;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class PrioridadeDao {

    public static void salvar(Prioridade prioridade) {
        DAO<Prioridade> dao = new DAO<>();
        dao.save(prioridade);
    }

    public static void deletar(Prioridade prioridade) {
        DAO<Prioridade> dao = new DAO<>();
        dao.delete(prioridade);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Prioridade> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'prioridade'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Prioridade vaPara(String id) {
        Prioridade prioridade = new Prioridade();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Prioridade p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Prioridade p WHERE id = " + id;
            }
            DAO<Prioridade> dao = new DAO<>();
            List<Prioridade> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                prioridade = null;
            } else {
                prioridade = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prioridade;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";

        DAO<Prioridade> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Prioridade WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Prioridade p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<Prioridade> lista = dao.query(sql);
            int i = 0;
            for (Prioridade prioridade : lista) {
                dadosTabela[i][0] = prioridade.getId();
                dadosTabela[i][1] = prioridade.getDescricao();
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
