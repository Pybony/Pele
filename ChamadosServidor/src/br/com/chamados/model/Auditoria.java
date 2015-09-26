package br.com.chamados.model;
// Generated 26/09/2015 15:38:57 by Hibernate Tools 4.3.1



/**
 * Auditoria generated by hbm2java
 */
public class Auditoria  implements java.io.Serializable {


     private Integer id;
     private Usuario usuario;
     private String tabela;
     private String funcao;
     private String campo;
     private String valorAntigo;
     private String valorNovo;

    public Auditoria() {
    }

	
    public Auditoria(Usuario usuario, String tabela, String funcao, String campo) {
        this.usuario = usuario;
        this.tabela = tabela;
        this.funcao = funcao;
        this.campo = campo;
    }
    public Auditoria(Usuario usuario, String tabela, String funcao, String campo, String valorAntigo, String valorNovo) {
       this.usuario = usuario;
       this.tabela = tabela;
       this.funcao = funcao;
       this.campo = campo;
       this.valorAntigo = valorAntigo;
       this.valorNovo = valorNovo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTabela() {
        return this.tabela;
    }
    
    public void setTabela(String tabela) {
        this.tabela = tabela;
    }
    public String getFuncao() {
        return this.funcao;
    }
    
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public String getCampo() {
        return this.campo;
    }
    
    public void setCampo(String campo) {
        this.campo = campo;
    }
    public String getValorAntigo() {
        return this.valorAntigo;
    }
    
    public void setValorAntigo(String valorAntigo) {
        this.valorAntigo = valorAntigo;
    }
    public String getValorNovo() {
        return this.valorNovo;
    }
    
    public void setValorNovo(String valorNovo) {
        this.valorNovo = valorNovo;
    }




}


