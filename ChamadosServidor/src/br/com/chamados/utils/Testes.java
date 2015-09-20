/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.utils;

/**
 *
 * @author jonasrosa
 */
public class Testes {
    
    public static void main(String args[]){
        ValidaCPF c = new ValidaCPF("013.769.780-59");
        Messages.addMessage("Jonas");
        Messages.addMessage("Aline");
        Messages.addMessage("Patrick");
        
//        Messages.showMessages();
        System.out.println("É válido? " + c.isCPF());
        System.out.println("É formatado? " + c.isFormated());
        System.out.println("Imprimindo " + c.imprimeCPF());
        System.out.println("Imprimindo sem for " + c.removeFormat());
        
    }
    
}
