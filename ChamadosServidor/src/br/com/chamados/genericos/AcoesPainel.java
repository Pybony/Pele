/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.genericos;

import javax.swing.JButton;

/**
 *
 * @author lksbr
 */
public interface AcoesPainel {

    void vaPara();

    void pesquisar();

    void inserir();

    void alterar();

    void deletar();

    void checkEnabled(JButton jbInserir, JButton jbAlterar, JButton jbDeletar);

}
