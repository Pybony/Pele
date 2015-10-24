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
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author lksbr
 */
public class CidadeDao {

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
}
