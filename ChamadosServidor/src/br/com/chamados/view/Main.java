/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view;

import br.com.chamados.dao.PermissoesDao;
import br.com.chamados.model.Funcionario;
import br.com.chamados.model.Permissoes;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Jonas C. Rosa
 */
public class Main {

    public static void main(String args[]) {
        new JfLogin().setVisible(true);

        //mapear banco por classes e não xml
        
        Permissoes permissoes = PermissoesDao.getTela(1);
        System.out.println("Permissao = " + permissoes.getId());
        System.out.println("Iterator = " +  permissoes.getUsuario().getFuncionarios());
        for (Iterator iterator = permissoes.getUsuario().getFuncionarios().iterator(); permissoes.getUsuario().getFuncionarios().iterator().hasNext();) {
            Funcionario next = (Funcionario) iterator.next();
            System.out.println("Funcionario = " + next.getId());
        }
    }
}
