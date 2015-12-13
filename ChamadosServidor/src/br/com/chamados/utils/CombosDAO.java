/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

import br.com.chamados.control.DAO;
import br.com.chamados.model.CategoriaUm;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Estado;
import br.com.chamados.model.Funcionario;
import br.com.chamados.model.Origem;
import br.com.chamados.model.Pessoa;
import br.com.chamados.model.Prioridade;
import br.com.chamados.model.Situacao;
import br.com.chamados.model.Tipo;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    public void popularCategoria(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT c FROM CategoriaUm c WHERE CategoriaUm.id = " + num;
            } else {
                sql = "SELECT c FROM CategoriaUm c";
            }

            DAO<CategoriaUm> categoriaDao = new DAO<>();
            List<CategoriaUm> lCategoria = categoriaDao.query(sql);

            if (!lCategoria.isEmpty()) {

                for (int i = 0; i < lCategoria.size(); i++) {
                    item = new ItemCombo();
                    item.setCodigo(lCategoria.get(i).getId());
                    item.setDescricao(lCategoria.get(i).getDescricao());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
    
    public void popularOrigem(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT o FROM Origem o WHERE Origem.id = " + num;
            } else {
                sql = "SELECT o FROM Origem o";
            }

            DAO<Origem> origemDao = new DAO<>();
            List<Origem> lOrigem = origemDao.query(sql);

            if (!lOrigem.isEmpty()) {

                for (int i = 0; i < lOrigem.size(); i++) {
                    item = new ItemCombo();
                    item.setCodigo(lOrigem.get(i).getId());
                    item.setDescricao(lOrigem.get(i).getDescricao());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
    
    
    public void popularAtribuidoPara(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT p FROM Pessoa p "
                        + "INNER JOIN Funcionario f WHERE = " + num;
            } else {
                sql = "SELECT f FROM Funcionario f "
                        + "INNER JOIN f.pessoa p";
            }

            DAO<Funcionario> funcionarioDao = new DAO<>();
            List<Funcionario> lFuncionario = funcionarioDao.query(sql);

            if (!lFuncionario.isEmpty()) {

                for (int i = 0; i < lFuncionario.size(); i++) {
                    item = new ItemCombo();
                    item.setCodigo(lFuncionario.get(i).getId());
                    item.setDescricao(lFuncionario.get(i).getPessoa().getNome());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.getMessage());
        }
    }
    
    public void popularPrioridade(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT p FROM Prioridade p WHERE Prioridade.id = " + num;
            } else {
                sql = "SELECT p FROM Prioridade p";
            }

            DAO<Prioridade> prioridadeDao = new DAO<>();
            List<Prioridade> lPrioridade = prioridadeDao.query(sql);

            if (!lPrioridade.isEmpty()) {

                for (int i = 0; i < lPrioridade.size(); i++) {
                    item = new ItemCombo();
                    item.setCodigo(lPrioridade.get(i).getId());
                    item.setDescricao(lPrioridade.get(i).getDescricao());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
    
    
    public void popularSituacao(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT s FROM Situacao s WHERE Situacao.id = " + num;
            } else {
                sql = "SELECT s FROM Situacao s";
            }

            DAO<Situacao> situacaoDao = new DAO<>();
            List<Situacao> lSituacao = situacaoDao.query(sql);

            if (!lSituacao.isEmpty()) {

                for (int i = 0; i < lSituacao.size(); i++) {
                    item = new ItemCombo();
                    System.out.println(lSituacao.get(i).getId());
                    item.setCodigo(lSituacao.get(i).getId());
                    item.setDescricao(lSituacao.get(i).getDescricao());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
    
    public void popularTipo(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT t FROM Tipo t WHERE Tipo.id = " + num;
            } else {
                sql = "SELECT t FROM Tipo t";
            }

            DAO<Tipo> tipoDao = new DAO<>();
            List<Tipo> lTipo = tipoDao.query(sql);

            if (!lTipo.isEmpty()) {

                for (int i = 0; i < lTipo.size(); i++) {
                    item = new ItemCombo();
                    item.setCodigo(lTipo.get(i).getId());
                    item.setDescricao(lTipo.get(i).getDescricao());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
    
    
    public void popularEstado(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT e FROM Estado e WHERE estado_id = " + num;
            } else {
                sql = "SELECT e FROM Estado e";
            }

            DAO<Estado> estadoDao = new DAO<>();
            List<Estado> lEstado = estadoDao.query(sql);

            if (!lEstado.isEmpty()) {

                for (int i = 0; i < lEstado.size(); i++) {
                    item = new ItemCombo();
                    item.setCodigo(lEstado.get(i).getId());
                    item.setDescricao(lEstado.get(i).getNome());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void popularCidade(JComboBox combo, int num) {

        ItemCombo item = new ItemCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                sql = "SELECT c FROM Cidade c WHERE estado_id = " + num;
            } else {
                sql = "SELECT c FROM Cidade c";
            }

            DAO<Cidade> cidadeDao = new DAO<>();
            List<Cidade> lCidade = cidadeDao.query(sql);

            if (!lCidade.isEmpty()) {

                for (int i = 0; i < lCidade.size(); i++) {
                    item = new ItemCombo();
                    item.setCodigo(lCidade.get(i).getId());
                    item.setDescricao(lCidade.get(i).getNome());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void definirItemCombo(JComboBox combo, ItemCombo item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ItemCombo) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    public int getEstadoId(int cidade_id) {
        String sql = "";
        DAO<Cidade> cidadeDao = new DAO<>();
        List<Cidade> lCidade;
        try {
            if (cidade_id > 0) {
                sql = "SELECT c FROM Cidade WHERE id = " + cidade_id;
                lCidade = cidadeDao.query(sql);
                if (lCidade.size() > 0) {
                    int id = lCidade.get(0).getEstado().getId();
                    return id;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro na busca pelo estado = " + e.toString());
            return 0;
        }
        return 0;
    }
}
