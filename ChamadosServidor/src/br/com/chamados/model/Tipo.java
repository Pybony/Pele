package br.com.chamados.model;
// Generated 01/11/2015 20:44:12 by Hibernate Tools 4.3.1



/**
 * Tipo generated by hbm2java
 */
public class Tipo  implements java.io.Serializable {


     private Integer id;
     private String descricao;

    public Tipo() {
    }

    public Tipo(String descricao) {
       this.descricao = descricao;
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




}

