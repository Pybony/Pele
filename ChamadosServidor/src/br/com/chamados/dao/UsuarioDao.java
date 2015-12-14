package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class UsuarioDao {

    public static Usuario vaPara(String id) {
        Usuario usuario = new Usuario();
        try {
            String sql = "";
            if (id.equals("0") || id.equals("")) {
                id = "0";
                sql = "SELECT p FROM Usuario p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Usuario p WHERE id = " + id;
            }
            DAO<Usuario> dao = new DAO<>();
            List<Usuario> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                usuario = null;
            } else {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static Usuario getUsuario(String login, String senha) {
        DAO<Usuario> daoUsuario = new DAO<>();
        Usuario retorno = daoUsuario.query("SELECT u FROM Usuario u WHERE login = '" + login + "' AND senha = '" + senha + "'").get(0);
        return retorno;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Login";

        DAO<Usuario> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Usuario WHERE login >= '" + descricaoDe + "' AND login <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT p FROM Usuario p WHERE login >= '" + descricaoDe + "' AND login <= '" + descricaoAte + "'";
            List<Usuario> lista = dao.query(sql);
            int i = 0;
            for (Usuario usuario : lista) {
                dadosTabela[i][0] = usuario.getId();
                dadosTabela[i][1] = usuario.getLogin();
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
