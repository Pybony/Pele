package br.com.chamados.model;
// Generated 14/12/2015 00:31:21 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pais generated by hbm2java
 */
public class Pais  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private String sigla;
     private Set estados = new HashSet(0);

    public Pais() {
    }

	
    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
    public Pais(String nome, String sigla, Set estados) {
       this.nome = nome;
       this.sigla = sigla;
       this.estados = estados;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSigla() {
        return this.sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public Set getEstados() {
        return this.estados;
    }
    
    public void setEstados(Set estados) {
        this.estados = estados;
    }




}


