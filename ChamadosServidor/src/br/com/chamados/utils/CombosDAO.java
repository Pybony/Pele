/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Estado;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    public void popularEstado(JComboBox combo, int num) {

        ItensCombo item = new ItensCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                System.out.println("2");
                sql = "SELECT e FROM Estado e WHERE estado_id = " + num;
            } else {
                sql = "SELECT e FROM Estado e";
            }

            DAO<Estado> estadoDao = new DAO<>();
            List<Estado> lEstado = estadoDao.query(sql);

            if (!lEstado.isEmpty()) {

                for (int i = 0; i < lEstado.size(); i++) {
                    item = new ItensCombo();
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

        ItensCombo item = new ItensCombo();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            String sql = "";
            if (num > 0) {
                System.out.println("2");
                sql = "SELECT c FROM Cidade c WHERE estado_id = " + num;
            } else {
                sql = "SELECT c FROM Cidade c";
            }

            DAO<Cidade> cidadeDao = new DAO<>();
            List<Cidade> lCidade = cidadeDao.query(sql);

            if (!lCidade.isEmpty()) {

                for (int i = 0; i < lCidade.size(); i++) {
                    item = new ItensCombo();
                    item.setCodigo(lCidade.get(i).getId());
                    item.setDescricao(lCidade.get(i).getNome());
                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void definirItemCombo(JComboBox combo, ItensCombo item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ItensCombo) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
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
