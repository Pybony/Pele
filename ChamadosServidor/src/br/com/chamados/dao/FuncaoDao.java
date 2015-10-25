/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Funcao;
import br.com.chamados.model.Nivel;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Tela;
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
public class FuncaoDao {

    public static void salvar(Funcao funcao) {
        DAO<Nivel> dao = new DAO<>();
        dao.save(funcao);
    }

    public static void deletar(Funcao funcao) {
        DAO<Funcao> dao = new DAO<>();
        dao.delete(funcao);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Funcao> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'funcao'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static void popularCombo(JComboBox combo) {
        String sql = "SELECT p FROM Nivel p";
        DAO<Nivel> dao = new DAO<Nivel>();
        List<Nivel> lista = dao.query(sql);
        if (!lista.isEmpty()) {
            for (Nivel nivel : lista) {
                ItemCombo item = new ItemCombo();
                item.setCodigo(nivel.getId());
                item.setDescricao(nivel.getDescricao());
                combo.addItem(item);
            }
        }
    }

    public static Funcao vaPara(String id) {
        Funcao funcao = new Funcao();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Funcao p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Funcao p WHERE id = " + id;
            }
            DAO<Funcao> dao = new DAO<>();
            List<Funcao> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                funcao = null;
            } else {
                funcao = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return funcao;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte, String nivelDe, String nivelAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Nivel";

        DAO<Funcao> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Funcao f INNER JOIN f.nivel WHERE f.descricao BETWEEN '" + descricaoDe
                + "' AND '" + descricaoAte + "' AND f.nivel.descricao BETWEEN '" + nivelDe
                + "' AND '" + nivelAte + "' ORDER BY f.id";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT f FROM Funcao f INNER JOIN f.nivel WHERE f.descricao BETWEEN '" + descricaoDe
                    + "' AND '" + descricaoAte + "' AND f.nivel.descricao BETWEEN '" + nivelDe
                    + "' AND '" + nivelAte + "' ORDER BY f.id";
            List<Funcao> lista = dao.query(sql);
            int i = 0;
            for (Funcao funcao : lista) {
                dadosTabela[i][0] = funcao.getId();
                dadosTabela[i][1] = funcao.getDescricao();
                dadosTabela[i][2] = funcao.getNivel().getDescricao();
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
                return Object.class;
            }
        });
    }
}
