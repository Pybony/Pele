/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

import java.awt.Container;

/**
 *
 * @author Jonas C. Rosa
 */
public class HabilitaCampos extends HDCampos{

    public static void run(Container container) {
        HDCampos.setHabilita(true);
        HDCampos.run(container);
    }
    
}
