package br.com.chamados.model;
// Generated 10/12/2015 21:08:11 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * CategoriaUm generated by hbm2java
 */
public class CategoriaUm  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private Set categoriaDoises = new HashSet(0);
     private Set chamados = new HashSet(0);

    public CategoriaUm() {
    }

    public CategoriaUm(String descricao, Set categoriaDoises, Set chamados) {
       this.descricao = descricao;
       this.categoriaDoises = categoriaDoises;
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
    public Set getCategoriaDoises() {
        return this.categoriaDoises;
    }
    
    public void setCategoriaDoises(Set categoriaDoises) {
        this.categoriaDoises = categoriaDoises;
    }
    public Set getChamados() {
        return this.chamados;
    }
    
    public void setChamados(Set chamados) {
        this.chamados = chamados;
    }




}


