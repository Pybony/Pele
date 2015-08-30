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
 * CategoriaDois generated by hbm2java
 */
@Entity
@Table(name="categoria_dois"
    ,catalog="chamados"
)
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
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoria_um_id", nullable=false)
    public CategoriaUm getCategoriaUm() {
        return this.categoriaUm;
    }
    
    public void setCategoriaUm(CategoriaUm categoriaUm) {
        this.categoriaUm = categoriaUm;
    }

    
    @Column(name="descricao", length=45)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categoriaDois")
    public Set getCategoriaTreses() {
        return this.categoriaTreses;
    }
    
    public void setCategoriaTreses(Set categoriaTreses) {
        this.categoriaTreses = categoriaTreses;
    }




}

