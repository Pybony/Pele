/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Origem;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class OrigemDao {

    public static void salvar(Origem origem) {
        DAO<Origem> dao = new DAO<>();
        dao.save(origem);
    }

    public static void deletar(Origem origem) {
        DAO<Origem> dao = new DAO<>();
        dao.delete(origem);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Origem> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'origem'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Origem vaPara(String id) {
        Origem nivel = new Origem();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Origem p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Origem p WHERE id = " + id;
            }
            DAO<Origem> dao = new DAO<>();
            List<Origem> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                nivel = null;
            } else {
                nivel = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nivel;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";

        DAO<Origem> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Origem WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Origem p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<Origem> lista = dao.query(sql);
            int i = 0;
            for (Origem nivel : lista) {
                dadosTabela[i][0] = nivel.getId();
                dadosTabela[i][1] = nivel.getDescricao();
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
