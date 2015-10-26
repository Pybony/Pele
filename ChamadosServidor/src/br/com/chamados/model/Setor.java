package br.com.chamados.model;
// Generated 26/10/2015 20:18:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Setor generated by hbm2java
 */
public class Setor  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private Set funcionarios = new HashSet(0);

    public Setor() {
    }

	
    public Setor(String descricao) {
        this.descricao = descricao;
    }
    public Setor(String descricao, Set funcionarios) {
       this.descricao = descricao;
       this.funcionarios = funcionarios;
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
    public Set getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }




}


