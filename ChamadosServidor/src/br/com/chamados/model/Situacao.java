package br.com.chamados.model;
// Generated 26/09/2015 15:38:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Situacao generated by hbm2java
 */
public class Situacao  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private Set chamados = new HashSet(0);

    public Situacao() {
    }

    public Situacao(String descricao, Set chamados) {
       this.descricao = descricao;
       this.chamados = chamados;
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
    public Set getChamados() {
        return this.chamados;
    }
    
    public void setChamados(Set chamados) {
        this.chamados = chamados;
    }




}


