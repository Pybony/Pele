/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas C. Rosa
 */
public class Main {

    public static void main(String args[]) {
            new Mail().start();
        new JfLogin().setVisible(true);
    }
}
