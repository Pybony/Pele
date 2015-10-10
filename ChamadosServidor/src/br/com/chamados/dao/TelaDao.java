/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Tela;
import java.util.List;

/**
 *
 * @author lksbr
 */
public class TelaDao {

    public static Tela getTela(int id) {
        Tela tela = new Tela();
        String sql = "SELECT t FROM Tela t WHERE id = " + id;

        try {
            DAO<Tela> dao = new DAO<Tela>();
            tela = dao.query(sql).get(0);
            return tela;
        } catch (Exception e) {
            return null;
        }
    }

}
