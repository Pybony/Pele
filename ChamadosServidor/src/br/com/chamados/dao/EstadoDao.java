/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Estado;
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
public class EstadoDao {

    public static void salvar(Estado estado) {
        DAO<Estado> dao = new DAO<>();
        dao.save(estado);
    }

    public static void deletar(Estado estado) {
        DAO<Estado> dao = new DAO<>();
        dao.delete(estado);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Estado> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'estado'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Estado vaPara(String id) {
        Estado estado = new Estado();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Estado p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Estado p WHERE id = " + id;
            }
            DAO<Estado> dao = new DAO<>();
            List<Estado> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                estado = null;
            } else {
                estado = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    public static void preencherCombo(JComboBox combo) {
        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        String sql = "SELECT e FROM Estado e";

        DAO<Estado> dao = new DAO<>();
        List<Estado> lEstado = dao.query(sql);

        if (!lEstado.isEmpty()) {

            for (int i = 0; i < lEstado.size(); i++) {
                item = new ItemCombo();
                item.setCodigo(lEstado.get(i).getId());
                item.setDescricao(lEstado.get(i).getNome());
                combo.addItem(item);
            }
        }
    }

    public static void popularTabela(JTable tabela, String nomeDe, String nomeAte, String paisDe, String paisAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Sigla";
        cabecalho[3] = "País";

        DAO<Estado> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Estado e INNER JOIN e.pais WHERE e.nome BETWEEN '" + nomeDe + "' AND '" + nomeAte + "'"
                + "AND e.pais.nome BETWEEN '" + paisDe + "' AND '" + paisAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT e FROM Estado e INNER JOIN e.pais WHERE e.nome BETWEEN '" + nomeDe + "' AND '" + nomeAte + "'"
                    + "AND e.pais.nome BETWEEN '" + paisDe + "' AND '" + paisAte + "'";
            List<Estado> lista = dao.query(sql);
            int i = 0;
            for (Estado estado : lista) {
                dadosTabela[i][0] = estado.getId();
                dadosTabela[i][1] = estado.getNome();
                dadosTabela[i][2] = estado.getSigla();
                dadosTabela[i][3] = estado.getPais().getNome();
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
