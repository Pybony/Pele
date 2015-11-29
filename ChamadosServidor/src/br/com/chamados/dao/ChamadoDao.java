/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Chamado;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jonascr86
 */
public class ChamadoDao {
    
    public static Chamado vaPara(String id) {
        Chamado chamado = new Chamado();
        try {
            String sql = "";
            if (id.equals("0")) {
                sql = "SELECT c FROM Chamado c WHERE id >= " + id + " ORDER BY id";
            } else {
                sql = "SELECT c FROM Chamado c WHERE id = " + id;
            }
            DAO<Chamado> dao = new DAO<>();
            List<Chamado> lista = dao.query(sql);
            if (lista.size() == 0) {
                if (!id.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Id não encontrado.");
                }
                chamado = null;
            } else {
                chamado = lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chamado;
    }
}
