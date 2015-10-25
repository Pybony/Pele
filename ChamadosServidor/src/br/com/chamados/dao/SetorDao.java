/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Setor;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class SetorDao {

    public static void salvar(Setor setor) {
        DAO<Setor> dao = new DAO<>();
        dao.save(setor);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Setor> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'setor'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static void deletar(Setor setor) {
        DAO<Setor> dao = new DAO<>();
        dao.delete(setor);
    }

    public static Setor vaPara(String id) {
        Setor setor = new Setor();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Setor p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Setor p WHERE id = " + id;
            }
            DAO<Setor> dao = new DAO<>();
            List<Setor> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                setor = null;
            } else {
                setor = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setor;
    }
    
    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";

        DAO<Setor> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Setor WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Setor p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<Setor> lista = dao.query(sql);
            int i = 0;
            for (Setor setor : lista) {
                dadosTabela[i][0] = setor.getId();
                dadosTabela[i][1] = setor.getDescricao();
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
