package br.com.chamados.model;
// Generated 24/08/2015 20:26:41 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="cliente"
    ,catalog="chamados"
)
public class Cliente  implements java.io.Serializable {


     private int id;
     private Bairro bairro;
     private Cidade cidade;
     private String nome;
     private String cgc;
     private String endereco;
     private String telefone;
     private String email;

    public Cliente() {
    }

    public Cliente(int id, Bairro bairro, Cidade cidade, String nome, String cgc, String endereco, String telefone, String email) {
       this.id = id;
       this.bairro = bairro;
       this.cidade = cidade;
       this.nome = nome;
       this.cgc = cgc;
       this.endereco = endereco;
       this.telefone = telefone;
       this.email = email;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bairro_id", nullable=false)
    public Bairro getBairro() {
        return this.bairro;
    }
    
    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cidade_id", nullable=false)
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
    @Column(name="nome", nullable=false, length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="cgc", nullable=false, length=45)
    public String getCgc() {
        return this.cgc;
    }
    
    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    
    @Column(name="endereco", nullable=false, length=45)
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    @Column(name="telefone", nullable=false, length=45)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}

