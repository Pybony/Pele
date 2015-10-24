/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Funcao;
import br.com.chamados.model.Nivel;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Tela;
import br.com.chamados.utils.ItemCombo;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lksbr
 */
public class FuncaoDao {
    
    public static String proximoId() {
        String retorno = "1";
        DAO<Funcao> dao = new DAO<>();
        Funcao funcao = dao.query("SELECT MAX(p) FROM Funcao p").get(0);
        if (funcao != null) {
            retorno = String.valueOf(funcao.getId() + 1);
        }
        return retorno;
    }

    public static void popularCombo(JComboBox combo) {
        ItemCombo item = new ItemCombo(0, "Selecione");
        combo.addItem(item);
        String sql = "SELECT p FROM Nivel p";
        DAO<Nivel> dao = new DAO<Nivel>();
        List<Nivel> lista = dao.query(sql);
        if (!lista.isEmpty()) {
            for (Nivel nivel : lista) {
                item = new ItemCombo();
                item.setCodigo(nivel.getId());
                item.setDescricao(nivel.getDescricao());
                combo.addItem(item);
            }
        }
    }

    public static Funcao vaPara(String id) {
        Funcao funcao = new Funcao();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Funcao p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Funcao p WHERE id = " + id;
            }
            DAO<Funcao> dao = new DAO<>();
            List<Funcao> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                funcao = null;
            } else {
                funcao = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return funcao;
    }
}
