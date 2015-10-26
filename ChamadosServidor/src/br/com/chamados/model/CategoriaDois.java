package br.com.chamados.model;
// Generated 26/10/2015 20:18:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * CategoriaDois generated by hbm2java
 */
public class CategoriaDois  implements java.io.Serializable {


     private Integer id;
     private CategoriaUm categoriaUm;
     private String descricao;
     private Set categoriaTreses = new HashSet(0);

    public CategoriaDois() {
    }

	
    public CategoriaDois(CategoriaUm categoriaUm) {
        this.categoriaUm = categoriaUm;
    }
    public CategoriaDois(CategoriaUm categoriaUm, String descricao, Set categoriaTreses) {
       this.categoriaUm = categoriaUm;
       this.descricao = descricao;
       this.categoriaTreses = categoriaTreses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public CategoriaUm getCategoriaUm() {
        return this.categoriaUm;
    }
    
    public void setCategoriaUm(CategoriaUm categoriaUm) {
        this.categoriaUm = categoriaUm;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set getCategoriaTreses() {
        return this.categoriaTreses;
    }
    
    public void setCategoriaTreses(Set categoriaTreses) {
        this.categoriaTreses = categoriaTreses;
    }




}


