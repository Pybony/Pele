package br.com.chamados.model;
// Generated 11/10/2015 16:23:24 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Acompanhamento generated by hbm2java
 */
public class Acompanhamento  implements java.io.Serializable {


     private int id;
     private String descricao;
     private Set interacaos = new HashSet(0);

    public Acompanhamento() {
    }

	
    public Acompanhamento(int id) {
        this.id = id;
    }
    public Acompanhamento(int id, String descricao, Set interacaos) {
       this.id = id;
       this.descricao = descricao;
       this.interacaos = interacaos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set getInteracaos() {
        return this.interacaos;
    }
    
    public void setInteracaos(Set interacaos) {
        this.interacaos = interacaos;
    }




}


