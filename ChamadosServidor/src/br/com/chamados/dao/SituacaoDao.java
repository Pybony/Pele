package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Situacao;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class SituacaoDao {

    public static void salvar(Situacao situacao) {
        DAO<Situacao> dao = new DAO<>();
        dao.save(situacao);
    }

    public static void deletar(Situacao situacao) {
        DAO<Situacao> dao = new DAO<>();
        dao.delete(situacao);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Situacao> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'situacao'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Situacao vaPara(String id) {
        Situacao situacao = new Situacao();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Situacao p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Situacao p WHERE id = " + id;
            }
            DAO<Situacao> dao = new DAO<>();
            List<Situacao> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                situacao = null;
            } else {
                situacao = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return situacao;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";

        DAO<Situacao> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Situacao WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Situacao p WHERE descricao >= '" + descricaoDe + "' AND descricao <= '" + descricaoAte + "'";
            List<Situacao> lista = dao.query(sql);
            int i = 0;
            for (Situacao situacao : lista) {
                dadosTabela[i][0] = situacao.getId();
                dadosTabela[i][1] = situacao.getDescricao();
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
