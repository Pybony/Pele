package br.com.chamados.model;
// Generated 26/10/2015 20:54:38 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private Integer id;
     private Cidade cidade;
     private Empresa empresa;
     private Funcao funcao;
     private Pessoa pessoa;
     private Setor setor;
     private Date dataAdmicao;
     private Date dataDesligamento;
     private Set usuarios = new HashSet(0);
     private Set chamados = new HashSet(0);

    public Funcionario() {
    }

	
    public Funcionario(Cidade cidade, Empresa empresa, Funcao funcao, Pessoa pessoa, Setor setor, Date dataAdmicao) {
        this.cidade = cidade;
        this.empresa = empresa;
        this.funcao = funcao;
        this.pessoa = pessoa;
        this.setor = setor;
        this.dataAdmicao = dataAdmicao;
    }
    public Funcionario(Cidade cidade, Empresa empresa, Funcao funcao, Pessoa pessoa, Setor setor, Date dataAdmicao, Date dataDesligamento, Set usuarios, Set chamados) {
       this.cidade = cidade;
       this.empresa = empresa;
       this.funcao = funcao;
       this.pessoa = pessoa;
       this.setor = setor;
       this.dataAdmicao = dataAdmicao;
       this.dataDesligamento = dataDesligamento;
       this.usuarios = usuarios;
       this.chamados = chamados;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public Funcao getFuncao() {
        return this.funcao;
    }
    
    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Setor getSetor() {
        return this.setor;
    }
    
    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    public Date getDataAdmicao() {
        return this.dataAdmicao;
    }
    
    public void setDataAdmicao(Date dataAdmicao) {
        this.dataAdmicao = dataAdmicao;
    }
    public Date getDataDesligamento() {
        return this.dataDesligamento;
    }
    
    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getChamados() {
        return this.chamados;
    }
    
    public void setChamados(Set chamados) {
        this.chamados = chamados;
    }




}


