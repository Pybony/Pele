/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Estado;
import br.com.chamados.utils.ItemCombo;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author lksbr
 */
public class EstadoDao {

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

}
