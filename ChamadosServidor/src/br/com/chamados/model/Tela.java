package br.com.chamados.model;
// Generated 29/11/2015 11:17:34 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tela generated by hbm2java
 */
public class Tela  implements java.io.Serializable {


     private int id;
     private String descricao;
     private Set permissoeses = new HashSet(0);

    public Tela() {
    }

	
    public Tela(int id) {
        this.id = id;
    }
    public Tela(int id, String descricao, Set permissoeses) {
       this.id = id;
       this.descricao = descricao;
       this.permissoeses = permissoeses;
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
    public Set getPermissoeses() {
        return this.permissoeses;
    }
    
    public void setPermissoeses(Set permissoeses) {
        this.permissoeses = permissoeses;
    }




}


