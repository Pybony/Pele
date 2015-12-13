/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.genericos;

import br.com.chamados.config.LogChamados;
import br.com.chamados.genericos.campos.DesabilitaCampos;
import br.com.chamados.genericos.campos.HabilitaCampos;
import br.com.chamados.genericos.campos.LimparCampos;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class Campos {

    static Logger logger = Logger.getLogger(LogChamados.class);

    public static void habilitar(Container container) {
        HabilitaCampos.run(container);
    }

    public static void desabilitar(Container container) {
        //DesabilitaCampos.run(container);
        enabled(container, false);
    }

    private static void enabled(Container container, boolean enabled) {
        Component c[] = container.getComponents();
        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) c[i];
                try {
                    field.setEnabled(enabled);
                    field.setEditable(enabled);
                } catch (Exception e) {
                    field.setEnabled(enabled);
                    field.setEditable(enabled);
                }
            } else if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setEnabled(enabled);
                field.setEditable(enabled);
            }  else if (c[i] instanceof JComboBox) {
                JComboBox cb = (JComboBox) c[i];
                cb.setEnabled(enabled);
            } else if (c[i] instanceof JCheckBox) {
                JCheckBox ckb = (JCheckBox) c[i];
                ckb.setEnabled(enabled);
            } else if (c[i] instanceof JButton){
                JButton jb = (JButton) c[i];
                jb.setEnabled(enabled);
            }
        }
    }

    public static void limpar(Container container) {
        LimparCampos.run(container);
    }

    public static boolean validar(Container container) {
        boolean valido = true;
        List<String> erros = new ArrayList<>();

        Component c[] = container.getComponents();

        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) c[i];
                System.out.println(field.getValue());
                if (field.getValue() == null) {

                    erros.add("O campo " + field.getName() + " deve ser preenchido.");
                }
            } else if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                if (field.getText().trim().equals("")) {
                    erros.add("O campo " + field.getName() + " deve ser preenchido.");
                }
            } else if (c[i] instanceof JScrollPane) {
                ((JTextArea) ((JScrollPane) c[i]).getViewport().getComponent(0)).setText("");
            } else if (c[i] instanceof JComboBox) {
                JComboBox cb = (JComboBox) c[i];

                if (cb.getSelectedIndex() <= 0 || cb.getSelectedItem() == null) {
//                    System.out.println(cb.getName());
                    erros.add("O campo " + cb.getName() + " deve ser preenchido.");
                }
            } else if (c[i] instanceof JCheckBox) {
                JCheckBox ckb = (JCheckBox) c[i];
                ckb.setSelected(false);
            }

        }
        String error = "";
        if (erros.size() > 0) {
            for (int i = 0; i < erros.size(); i++) {
                error += erros.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(container, error, "Erro", JOptionPane.ERROR_MESSAGE);
            valido = false;
        }
        return valido;
    }

}
