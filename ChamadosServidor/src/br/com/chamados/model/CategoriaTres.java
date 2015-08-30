package br.com.chamados.model;
// Generated 24/08/2015 20:26:41 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CategoriaTres generated by hbm2java
 */
@Entity
@Table(name="categoria_tres"
    ,catalog="chamados"
)
public class CategoriaTres  implements java.io.Serializable {


     private Integer id;
     private CategoriaDois categoriaDois;
     private String descricao;

    public CategoriaTres() {
    }

	
    public CategoriaTres(CategoriaDois categoriaDois) {
        this.categoriaDois = categoriaDois;
    }
    public CategoriaTres(CategoriaDois categoriaDois, String descricao) {
       this.categoriaDois = categoriaDois;
       this.descricao = descricao;
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
    @JoinColumn(name="categoria_dois_id", nullable=false)
    public CategoriaDois getCategoriaDois() {
        return this.categoriaDois;
    }
    
    public void setCategoriaDois(CategoriaDois categoriaDois) {
        this.categoriaDois = categoriaDois;
    }

    
    @Column(name="descricao", length=45)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}

