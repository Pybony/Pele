/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Tipo;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class TipoDao {

    public static void salvar(Tipo tipo) {
        DAO<Tipo> dao = new DAO<>();
        dao.save(tipo);
    }

    public static void deletar(Tipo tipo) {
        DAO<Tipo> dao = new DAO<>();
        dao.delete(tipo);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Tipo> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'tipo'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Tipo vaPara(String id) {
        Tipo tipo = new Tipo();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Tipo p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Tipo p WHERE id = " + id;
            }
            DAO<Tipo> dao = new DAO<>();
            List<Tipo> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                tipo = null;
            } else {
                tipo = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipo;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";

        DAO<Tipo> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Tipo WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Tipo p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<Tipo> lista = dao.query(sql);
            int i = 0;
            for (Tipo tipo : lista) {
                dadosTabela[i][0] = tipo.getId();
                dadosTabela[i][1] = tipo.getDescricao();
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
