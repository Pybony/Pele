/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas C. Rosa
 */
public class Messages {
    
    private static ArrayList<String> messages;

    public static void addMessage(String message){
        if(!message.isEmpty()){
            getMessages().add(message);
        }
    }
    
    public static ArrayList<String> getMessages(){
        if(messages == null){
            return messages = new ArrayList<>();
        }
        return messages;
    }
    
    public static void removeMessages(){
        getMessages().clear();
    }
    
    public static boolean showMessages(){
        String message = "";
        if( getMessages().size() > 0){
            for (int i = 0; i < getMessages().size(); i++) {
                message = message + getMessages().get(i) + "\n";
            }
            if(!message.equals("")){
                JOptionPane.showMessageDialog(null, message);
                removeMessages();
                return true;
            }
        }
        return false;
    }
}
