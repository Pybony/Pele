package br.com.chamados.model;
// Generated 14/12/2015 00:31:21 by Hibernate Tools 4.3.1



/**
 * Permissoes generated by hbm2java
 */
public class Permissoes  implements java.io.Serializable {


     private Integer id;
     private Tela tela;
     private Usuario usuario;
     private Boolean alterar;
     private Boolean inserir;
     private Boolean deletar;
     private Boolean consultar;

    public Permissoes() {
    }

	
    public Permissoes(Tela tela, Usuario usuario) {
        this.tela = tela;
        this.usuario = usuario;
    }
    public Permissoes(Tela tela, Usuario usuario, Boolean alterar, Boolean inserir, Boolean deletar, Boolean consultar) {
       this.tela = tela;
       this.usuario = usuario;
       this.alterar = alterar;
       this.inserir = inserir;
       this.deletar = deletar;
       this.consultar = consultar;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Tela getTela() {
        return this.tela;
    }
    
    public void setTela(Tela tela) {
        this.tela = tela;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Boolean getAlterar() {
        return this.alterar;
    }
    
    public void setAlterar(Boolean alterar) {
        this.alterar = alterar;
    }
    public Boolean getInserir() {
        return this.inserir;
    }
    
    public void setInserir(Boolean inserir) {
        this.inserir = inserir;
    }
    public Boolean getDeletar() {
        return this.deletar;
    }
    
    public void setDeletar(Boolean deletar) {
        this.deletar = deletar;
    }
    public Boolean getConsultar() {
        return this.consultar;
    }
    
    public void setConsultar(Boolean consultar) {
        this.consultar = consultar;
    }




}


