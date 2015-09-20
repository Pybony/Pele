/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Cidade;
import java.util.List;

/**
 *
 * @author Jonas C. Rosa
 */
public class TestesHibernate {

    public static void main(String args[]) {
        DAO<Cidade> cidade = new DAO<>();
        List<Cidade> lista = cidade.query("SELECT c FROM Estado c WHERE id = 5");
        Cidade c = lista.get(0);
        System.out.println(c.getNome());
        
        
    }
}
