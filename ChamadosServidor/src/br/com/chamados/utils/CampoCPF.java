/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jonasrosa
 */
public class CampoCPF extends CampoInteiro {

    private ValidaCPF valida;
    private boolean validate;

    public CampoCPF() {
        addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                CpfFocusLost(evt);
            }
        });
    }

    private void CpfFocusLost(FocusEvent evt) {
        if (getText().length() >= 1) {
            valida = new ValidaCPF(getText());
            if (!valida.isCPF()) {
                JOptionPane.showMessageDialog(null, "CPF inválido!");
                grabFocus();
            }
        }
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
    
    
}
