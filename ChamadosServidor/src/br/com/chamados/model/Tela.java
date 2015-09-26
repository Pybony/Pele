package br.com.chamados.model;
// Generated 26/09/2015 15:38:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tela generated by hbm2java
 */
public class Tela  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private Set permissoeses = new HashSet(0);

    public Tela() {
    }

    public Tela(String descricao, Set permissoeses) {
       this.descricao = descricao;
       this.permissoeses = permissoeses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
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


