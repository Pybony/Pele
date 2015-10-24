/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Nivel;
import br.com.chamados.model.Pais;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lksbr
 */
public class PaisDao {
    
    public static Pais vaPara(String id) {
        Pais pais = new Pais();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT p FROM Pais p WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT p FROM Pais p WHERE id = " + id;
            }
            DAO<Pais> dao = new DAO<>();
            List<Pais> lista = dao.query(sql);
            if (lista.size() == 0) {
                JOptionPane.showMessageDialog(null, "Id não encontrado.");
            } else {
                pais = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pais;
    }    
}
