package br.com.chamados.model;
// Generated 14/12/2015 00:31:21 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pessoa generated by hbm2java
 */
public class Pessoa  implements java.io.Serializable {


     private Integer id;
     private Cidade cidade;
     private String nome;
     private int idade;
     private Date dataNascimento;
     private String email;
     private String telefone;
     private String cpf;
     private String rg;
     private Set funcionarios = new HashSet(0);

    public Pessoa() {
    }

	
    public Pessoa(Cidade cidade, String nome, int idade, Date dataNascimento, String email, String telefone, String cpf, String rg) {
        this.cidade = cidade;
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
    }
    public Pessoa(Cidade cidade, String nome, int idade, Date dataNascimento, String email, String telefone, String cpf, String rg, Set funcionarios) {
       this.cidade = cidade;
       this.nome = nome;
       this.idade = idade;
       this.dataNascimento = dataNascimento;
       this.email = email;
       this.telefone = telefone;
       this.cpf = cpf;
       this.rg = rg;
       this.funcionarios = funcionarios;
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
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return this.idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return this.rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }
    public Set getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }




}


