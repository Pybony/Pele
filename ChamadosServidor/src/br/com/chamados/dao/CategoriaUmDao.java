/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.CategoriaUm;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class CategoriaUmDao {

    public static void salvar(CategoriaUm categoriaUm) {
        DAO<CategoriaUm> dao = new DAO<>();
        dao.save(categoriaUm);
    }

    public static void deletar(CategoriaUm categoriaUm) {
        DAO<CategoriaUm> dao = new DAO<>();
        dao.delete(categoriaUm);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<CategoriaUm> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'categoriaUm'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static CategoriaUm vaPara(String id) {
        CategoriaUm categoriaUm = new CategoriaUm();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM CategoriaUm p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM CategoriaUm p WHERE id = " + id;
            }
            DAO<CategoriaUm> dao = new DAO<>();
            List<CategoriaUm> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                categoriaUm = null;
            } else {
                categoriaUm = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoriaUm;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";

        DAO<CategoriaUm> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM CategoriaUm WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM CategoriaUm p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<CategoriaUm> lista = dao.query(sql);
            int i = 0;
            for (CategoriaUm categoriaUm : lista) {
                dadosTabela[i][0] = categoriaUm.getId();
                dadosTabela[i][1] = categoriaUm.getDescricao();
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
