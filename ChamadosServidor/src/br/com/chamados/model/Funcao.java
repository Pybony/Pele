package br.com.chamados.model;
// Generated 24/08/2015 20:26:41 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Funcao generated by hbm2java
 */
@Entity
@Table(name="funcao"
    ,catalog="chamados"
)
public class Funcao  implements java.io.Serializable {


     private Integer id;
     private Nivel nivel;
     private String descricao;
     private Set funcionarios = new HashSet(0);

    public Funcao() {
    }

	
    public Funcao(Nivel nivel) {
        this.nivel = nivel;
    }
    public Funcao(Nivel nivel, String descricao, Set funcionarios) {
       this.nivel = nivel;
       this.descricao = descricao;
       this.funcionarios = funcionarios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nivel_id", nullable=false)
    public Nivel getNivel() {
        return this.nivel;
    }
    
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    
    @Column(name="descricao", length=45)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="funcao")
    public Set getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }




}

