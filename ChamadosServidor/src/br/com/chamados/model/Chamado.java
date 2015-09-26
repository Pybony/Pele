package br.com.chamados.model;
// Generated 26/09/2015 15:38:57 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Chamado generated by hbm2java
 */
public class Chamado  implements java.io.Serializable {


     private Integer id;
     private CategoriaUm categoriaUm;
     private Chamado chamado;
     private Empresa empresa;
     private Funcionario funcionarioByFuncionarioAberturaId;
     private Funcionario funcionarioByFuncionarioAtendenteId;
     private Funcionario funcionarioByFuncionarioSolicitanteId;
     private Origem origem;
     private Prioridade prioridade;
     private Situacao situacao;
     private int tipoId;
     private String titulo;
     private String descricao;
     private Date dataAbertura;
     private Date dataFechamento;
     private Date dataPrevista;
     private Set interacaos = new HashSet(0);
     private Set chamados = new HashSet(0);

    public Chamado() {
    }

	
    public Chamado(CategoriaUm categoriaUm, Funcionario funcionarioByFuncionarioAberturaId, Funcionario funcionarioByFuncionarioSolicitanteId, Origem origem, Prioridade prioridade, Situacao situacao, int tipoId, String titulo) {
        this.categoriaUm = categoriaUm;
        this.funcionarioByFuncionarioAberturaId = funcionarioByFuncionarioAberturaId;
        this.funcionarioByFuncionarioSolicitanteId = funcionarioByFuncionarioSolicitanteId;
        this.origem = origem;
        this.prioridade = prioridade;
        this.situacao = situacao;
        this.tipoId = tipoId;
        this.titulo = titulo;
    }
    public Chamado(CategoriaUm categoriaUm, Chamado chamado, Empresa empresa, Funcionario funcionarioByFuncionarioAberturaId, Funcionario funcionarioByFuncionarioAtendenteId, Funcionario funcionarioByFuncionarioSolicitanteId, Origem origem, Prioridade prioridade, Situacao situacao, int tipoId, String titulo, String descricao, Date dataAbertura, Date dataFechamento, Date dataPrevista, Set interacaos, Set chamados) {
       this.categoriaUm = categoriaUm;
       this.chamado = chamado;
       this.empresa = empresa;
       this.funcionarioByFuncionarioAberturaId = funcionarioByFuncionarioAberturaId;
       this.funcionarioByFuncionarioAtendenteId = funcionarioByFuncionarioAtendenteId;
       this.funcionarioByFuncionarioSolicitanteId = funcionarioByFuncionarioSolicitanteId;
       this.origem = origem;
       this.prioridade = prioridade;
       this.situacao = situacao;
       this.tipoId = tipoId;
       this.titulo = titulo;
       this.descricao = descricao;
       this.dataAbertura = dataAbertura;
       this.dataFechamento = dataFechamento;
       this.dataPrevista = dataPrevista;
       this.interacaos = interacaos;
       this.chamados = chamados;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public CategoriaUm getCategoriaUm() {
        return this.categoriaUm;
    }
    
    public void setCategoriaUm(CategoriaUm categoriaUm) {
        this.categoriaUm = categoriaUm;
    }
    public Chamado getChamado() {
        return this.chamado;
    }
    
    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public Funcionario getFuncionarioByFuncionarioAberturaId() {
        return this.funcionarioByFuncionarioAberturaId;
    }
    
    public void setFuncionarioByFuncionarioAberturaId(Funcionario funcionarioByFuncionarioAberturaId) {
        this.funcionarioByFuncionarioAberturaId = funcionarioByFuncionarioAberturaId;
    }
    public Funcionario getFuncionarioByFuncionarioAtendenteId() {
        return this.funcionarioByFuncionarioAtendenteId;
    }
    
    public void setFuncionarioByFuncionarioAtendenteId(Funcionario funcionarioByFuncionarioAtendenteId) {
        this.funcionarioByFuncionarioAtendenteId = funcionarioByFuncionarioAtendenteId;
    }
    public Funcionario getFuncionarioByFuncionarioSolicitanteId() {
        return this.funcionarioByFuncionarioSolicitanteId;
    }
    
    public void setFuncionarioByFuncionarioSolicitanteId(Funcionario funcionarioByFuncionarioSolicitanteId) {
        this.funcionarioByFuncionarioSolicitanteId = funcionarioByFuncionarioSolicitanteId;
    }
    public Origem getOrigem() {
        return this.origem;
    }
    
    public void setOrigem(Origem origem) {
        this.origem = origem;
    }
    public Prioridade getPrioridade() {
        return this.prioridade;
    }
    
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public Situacao getSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    public int getTipoId() {
        return this.tipoId;
    }
    
    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataAbertura() {
        return this.dataAbertura;
    }
    
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public Date getDataFechamento() {
        return this.dataFechamento;
    }
    
    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    public Date getDataPrevista() {
        return this.dataPrevista;
    }
    
    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }
    public Set getInteracaos() {
        return this.interacaos;
    }
    
    public void setInteracaos(Set interacaos) {
        this.interacaos = interacaos;
    }
    public Set getChamados() {
        return this.chamados;
    }
    
    public void setChamados(Set chamados) {
        this.chamados = chamados;
    }




}


