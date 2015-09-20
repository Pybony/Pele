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
import java.util.InputMismatchException;

public class ValidaCPF {

    private String cpf;

    public ValidaCPF(String cpf) {
        this.cpf = cpf;
    }

    public boolean isCPF() {

        String CPF = removeFormat();

// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (!this.valida(CPF)) {
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0         
// (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public String imprimeCPF() {

        String CPF = removeFormat();

        if (!this.valida(CPF)) {
            return null;
        }

        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    public boolean valida(String CPF) {

        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }
        return true;
    }

    public boolean isFormated() {
        try {
            return (this.cpf.substring(3, 4).equals(".")
                    && this.cpf.substring(7, 8).equals(".")
                    && this.cpf.substring(11, 12).equals("-"));
        } catch (Exception e) {
            return false;
        }

    }

    public String removeFormat() {
        String cpf = "";
        if (isFormated()) {
            for (int i = 0; i < this.cpf.length(); i++) {
                if (!Character.toString(this.cpf.charAt(i)).equals(".")
                        && !Character.toString(this.cpf.charAt(i)).equals("-")) {
                    cpf = cpf + Character.toString(this.cpf.charAt(i));
                }
            }
            return cpf;
        }
        return this.cpf;
    }
}
