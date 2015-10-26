/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Cidade;
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
public class CidadeDao {

    public static void salvar(Cidade cidade) {
        DAO<Cidade> dao = new DAO<>();
        dao.save(cidade);
    }

    public static void deletar(Cidade cidade) {
        DAO<Cidade> dao = new DAO<>();
        dao.delete(cidade);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Cidade> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'cidade'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Cidade vaPara(String id) {
        Cidade cidade = new Cidade();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Cidade p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Cidade p WHERE id = " + id;
            }
            DAO<Cidade> dao = new DAO<>();
            List<Cidade> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                cidade = null;
            } else {
                cidade = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidade;
    }

    public static Cidade getEstadoId(int cidadeId) {
        DAO<Cidade> dao = new DAO<>();
        String sql = "SELECT c FROM Cidade c WHERE id = " + cidadeId;
        System.out.println("UUUUUUUUU " + sql);
        List<Cidade> cidade = dao.query(sql);
        return cidade.get(0);
    }

    public static void preencherCombo(JComboBox combo, int idEstado) {
        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        String sql = "SELECT c FROM Cidade c WHERE estado_id = " + idEstado;

        DAO<Cidade> dao = new DAO<>();
        List<Cidade> lCidade = dao.query(sql);

        if (!lCidade.isEmpty()) {

            for (int i = 0; i < lCidade.size(); i++) {
                item = new ItemCombo();
                item.setCodigo(lCidade.get(i).getId());
                item.setDescricao(lCidade.get(i).getNome());
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
        cabecalho[2] = "Cep";
        cabecalho[3] = "Estado";

        DAO<Cidade> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Cidade c INNER JOIN c.estado WHERE c.nome BETWEEN '" + nomeDe + "' AND '" + nomeAte + "'"
                + "AND c.estado.nome BETWEEN '" + paisDe + "' AND '" + paisAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT c FROM Cidade c INNER JOIN c.estado WHERE c.nome BETWEEN '" + nomeDe + "' AND '" + nomeAte + "'"
                    + "AND c.estado.nome BETWEEN '" + paisDe + "' AND '" + paisAte + "'";
            List<Cidade> lista = dao.query(sql);
            int i = 0;
            for (Cidade cidade : lista) {
                dadosTabela[i][0] = cidade.getId();
                dadosTabela[i][1] = cidade.getNome();
                dadosTabela[i][2] = cidade.getCep();
                dadosTabela[i][3] = cidade.getEstado().getNome();
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
