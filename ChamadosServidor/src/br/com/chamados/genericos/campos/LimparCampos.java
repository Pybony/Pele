/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.genericos.campos;

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
public class LimparCampos {
    
    public static void run(Container container) {
        Component c[] = container.getComponents();
        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) c[i];
                try {
                    field.setValue("");
                } catch (Exception e) {
                    field.setValue(null);
                }
            } else if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setText("");
            } else if (c[i] instanceof JScrollPane) {
                ((JTextArea) ((JScrollPane) c[i]).getViewport().getComponent(0)).setText("");
            } else if (c[i] instanceof JComboBox) {
                JComboBox cb = (JComboBox) c[i];
                cb.setSelectedIndex(-1);
            } else if (c[i] instanceof JCheckBox) {
                JCheckBox ckb = (JCheckBox) c[i];
                ckb.setSelected(false);
            }
        }
    }
}
