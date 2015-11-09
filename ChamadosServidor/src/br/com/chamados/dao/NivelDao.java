/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Nivel;
import br.com.chamados.utils.ItemCombo;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class NivelDao {

    public static void salvar(Nivel nivel) {
        DAO<Nivel> dao = new DAO<>();
        dao.save(nivel);
    }

    public static void deletar(Nivel nivel) {
        DAO<Nivel> dao = new DAO<>();
        dao.delete(nivel);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Nivel> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'nivel'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Nivel vaPara(String id) {
        Nivel nivel = new Nivel();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Nivel p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Nivel p WHERE id = " + id;
            }
            DAO<Nivel> dao = new DAO<>();
            List<Nivel> lista = dao.query(sql);
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

        DAO<Nivel> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Nivel WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Nivel p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<Nivel> lista = dao.query(sql);
            int i = 0;
            for (Nivel nivel : lista) {
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

    public static Nivel getSelectedItemCombo(JComboBox combo) {
        ItemCombo item = (ItemCombo) combo.getSelectedItem();
        String id = String.valueOf(item.getCodigo());
        Nivel nivel = vaPara(id);
        return nivel;
    }

    public static void setSelectedItemCombo(JComboBox combo, Nivel nivel) {
        ItemCombo item = new ItemCombo(nivel.getId(), nivel.getDescricao());
        combo.getModel().setSelectedItem(item);
    }

}
