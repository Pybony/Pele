package br.com.chamados.model;
// Generated 26/10/2015 20:18:40 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Nivel generated by hbm2java
 */
public class Nivel implements java.io.Serializable {

    private Integer id;
    private String descricao;
    private Set funcaos = new HashSet(0);

    public Nivel() {
    }

    public Nivel(String descricao, Set funcaos) {
        this.descricao = descricao;
        this.funcaos = funcaos;
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

    public Set getFuncaos() {
        return this.funcaos;
    }

    public void setFuncaos(Set funcaos) {
        this.funcaos = funcaos;
    }

}
