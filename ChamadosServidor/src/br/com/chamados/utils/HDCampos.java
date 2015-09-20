/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jonas C. Rosa
 */
public abstract class HDCampos {

    protected static boolean habilita;

    protected static void setHabilita(boolean habilita){
        HDCampos.habilita = habilita;
    }
    
    protected static boolean getHabilita(){
        return HDCampos.habilita;
    }
    
    public static void run(Container container) {
        Component c[] = container.getComponents();
        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) c[i];
                try {
                    field.setEnabled(getHabilita());
                } catch (Exception e) {
                    field.setEnabled(getHabilita());
                }
            } else if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setEnabled(getHabilita());;
            } else if (c[i] instanceof JScrollPane) {
                ((JTextArea) ((JScrollPane) c[i]).getViewport().getComponent(0)).setEnabled(getHabilita());
            } else if (c[i] instanceof JComboBox) {
                JComboBox cb = (JComboBox) c[i];
                cb.setEnabled(getHabilita());
            } else if (c[i] instanceof JCheckBox) {
                JCheckBox ckb = (JCheckBox) c[i];
                ckb.setEnabled(getHabilita());
            }
        }
    }
}
