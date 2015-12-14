package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Funcionario;
import br.com.chamados.model.Nivel;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class FuncionarioDao {

    public static void salvar(Funcionario funcionario) {
        DAO<Funcionario> dao = new DAO<>();
        dao.save(funcionario);
    }

    public static Funcionario vaPara(String id) {
        Funcionario funcionario = new Funcionario();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Funcionario p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Funcionario p WHERE id = " + id;
            }
            DAO<Funcionario> dao = new DAO<>();
            List<Funcionario> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                funcionario = null;
            } else {
                funcionario = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public static void deletar(Funcionario funcionario) {
        DAO<Funcionario> dao = new DAO<>();
        dao.delete(funcionario);
    }

    public static String proximoId() {
        String retorno = "1";
        DAO<Nivel> dao = new DAO<>();
        BigInteger id = (BigInteger) dao.querySQL("SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'funcionario'");
        if (id != null) {
            retorno = String.valueOf(id);
        }
        return retorno;
    }

    public static Funcionario getFucionario(Set set) {
        Funcionario funcionario = null;
        for (Iterator iterator1 = set.iterator(); iterator1.hasNext();) {
            funcionario = (Funcionario) iterator1.next();
        }
        return funcionario;
    }

    public static List<Funcionario> getFuncionarios(Set set) {
        List<Funcionario> lista = new ArrayList<>();
        for (Iterator iterator1 = set.iterator(); iterator1.hasNext();) {
            Funcionario funcionario = (Funcionario) iterator1.next();
            lista.add(funcionario);
        }
        return lista;
    }

    public static void popularTabela(JTable tabela, String descricaoDe, String descricaoAte) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[tabela.getColumnCount()];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Setor";
        cabecalho[3] = "Empresa";

        DAO<Funcionario> dao = new DAO<>();
        String sql = "SELECT COUNT(*) FROM Funcionario f INNER JOIN f.pessoa WHERE f.pessoa.nome >= '" + descricaoDe + "' AND f.pessoa.nome <= '" + descricaoAte + "'";
        // cria matriz de acordo com nº de registros da tabela
        try {
            Integer result = Integer.parseInt(dao.count(sql).toString());
            dadosTabela = new Object[result][tabela.getColumnCount()];

            // efetua consulta de dados no banco e atribui no componente JTable
            sql = "SELECT f FROM Funcionario f INNER JOIN f.pessoa WHERE f.pessoa.nome >= '" + descricaoDe + "' AND f.pessoa.nome <= '" + descricaoAte + "'";
            List<Funcionario> lista = dao.query(sql);
            int i = 0;
            for (Funcionario funcionario : lista) {
                dadosTabela[i][0] = funcionario.getId();
                dadosTabela[i][1] = funcionario.getPessoa().getNome();
                dadosTabela[i][2] = funcionario.getSetor().getDescricao();
                dadosTabela[i][3] = funcionario.getEmpresa().getNome();
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
                if (column > 5) {
                    return Boolean.class;
                }
                return Object.class;
            }
        });
    }

}
