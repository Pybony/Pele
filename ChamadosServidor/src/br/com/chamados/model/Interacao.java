package br.com.chamados.model;
// Generated 14/12/2015 00:31:21 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Interacao generated by hbm2java
 */
public class Interacao  implements java.io.Serializable {


     private Integer id;
     private Chamado chamado;
     private Funcionario funcionario;
     private String descricao;
     private Date data;
     private Integer autorId;
     private Boolean solucao;
     private Boolean privado;
     private Boolean email;

    public Interacao() {
    }

	
    public Interacao(Chamado chamado, Funcionario funcionario, String descricao, Date data) {
        this.chamado = chamado;
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.data = data;
    }
    public Interacao(Chamado chamado, Funcionario funcionario, String descricao, Date data, Integer autorId, Boolean solucao, Boolean privado, Boolean email) {
       this.chamado = chamado;
       this.funcionario = funcionario;
       this.descricao = descricao;
       this.data = data;
       this.autorId = autorId;
       this.solucao = solucao;
       this.privado = privado;
       this.email = email;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Chamado getChamado() {
        return this.chamado;
    }
    
    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public Integer getAutorId() {
        return this.autorId;
    }
    
    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
    public Boolean getSolucao() {
        return this.solucao;
    }
    
    public void setSolucao(Boolean solucao) {
        this.solucao = solucao;
    }
    public Boolean getPrivado() {
        return this.privado;
    }
    
    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }
    public Boolean getEmail() {
        return this.email;
    }
    
    public void setEmail(Boolean email) {
        this.email = email;
    }




}


