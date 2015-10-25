/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Nivel;
import br.com.chamados.model.Pais;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class PaisDao {

    public static void salvar(Pais pais) {
        DAO<Pais> dao = new DAO<>();
        dao.save(pais);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Nivel> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'pais'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static void deletar(Pais pais) {
        DAO<Pais> dao = new DAO<>();
        dao.delete(pais);
    }

    public static Pais vaPara(String id) {
        Pais pais = new Pais();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Pais p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Pais p WHERE id = " + id;
            }
            DAO<Pais> dao = new DAO<>();
            List<Pais> lista = dao.query(sql);
            if (lista.size() == 0) {
                JOptionPane.showMessageDialog(null, "Id não encontrado.");
            } else {
                pais = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pais;
    }
    
    public static void popularTabela(JTable tabela, String nomeDe, String nomeAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Sigla";

        DAO<Pais> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Pais WHERE nome >= '" + nomeDe + "' AND nome <= '" + nomeAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Pais p WHERE nome >= '" + nomeDe + "' AND nome <= '" + nomeAte + "'";
            List<Pais> lista = dao.query(sql);
            int i = 0;
            for (Pais pais : lista) {
                dadosTabela[i][0] = pais.getId();
                dadosTabela[i][1] = pais.getNome();
                dadosTabela[i][2] = pais.getSigla();
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
