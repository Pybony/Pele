/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.genericos;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;

/**
 *
 * @author lksbr
 */
public class Util {
    
    public static void centralizar(JInternalFrame frame){
        Dimension d = frame.getDesktopPane().getSize();
        frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    }
    
    public static String converteDataBanco(GregorianCalendar calendar){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YY");
        return formatter.format(calendar.getTime());
    }
    
}
