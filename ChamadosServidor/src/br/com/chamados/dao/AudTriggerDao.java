package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.AudTrigger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class AudTriggerDao {

    public static void salvar(AudTrigger trigger) {
        DAO<AudTrigger> dao = new DAO<>();
        dao.save(trigger);
    }

    public static void deletar(AudTrigger trigger) {
        DAO<AudTrigger> dao = new DAO<>();
        dao.delete(trigger);
    }

    public static AudTrigger vaPara(String id) {
        AudTrigger trigger = new AudTrigger();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM AudTrigger p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM AudTrigger p WHERE id = " + id;
            }
            DAO<AudTrigger> dao = new DAO<>();
            List<AudTrigger> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                trigger = null;
            } else {
                trigger = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trigger;
    }

    public static void popularTabela(JTable tabela, String nomeDe, String nomeAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Ativo";

        DAO<AudTrigger> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM AudTrigger WHERE nome >= '" + nomeDe + "' AND nome <= '" + nomeAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM AudTrigger p WHERE nome >= '" + nomeDe + "' AND nome <= '" + nomeAte + "'";
            List<AudTrigger> lista = dao.query(sql);
            int i = 0;
            for (AudTrigger trigger : lista) {
                dadosTabela[i][0] = trigger.getId();
                dadosTabela[i][1] = trigger.getNome();
                dadosTabela[i][2] = trigger.getSituacao();
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
