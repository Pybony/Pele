package br.com.chamados.model;
// Generated 21/09/2015 21:01:59 by Hibernate Tools 4.3.1


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
     private Origim origim;
     private Pessoa pessoa;
     private Prioridade prioridade;
     private Situacao situacao;
     private Tipo tipo;
     private String titulo;
     private String descricao;
     private Date dataAbertura;
     private Date dataFechamento;
     private Date dataPrevista;
     private Integer funcionarioId;
     private int idAbertura;
     private Set interacaos = new HashSet(0);
     private Set chamados = new HashSet(0);

    public Chamado() {
    }

	
    public Chamado(CategoriaUm categoriaUm, Funcionario funcionarioByFuncionarioAberturaId, Funcionario funcionarioByFuncionarioAtendenteId, Funcionario funcionarioByFuncionarioSolicitanteId, Origem origem, Origim origim, Prioridade prioridade, Situacao situacao, Tipo tipo, String titulo, int idAbertura) {
        this.categoriaUm = categoriaUm;
        this.funcionarioByFuncionarioAberturaId = funcionarioByFuncionarioAberturaId;
        this.funcionarioByFuncionarioAtendenteId = funcionarioByFuncionarioAtendenteId;
        this.funcionarioByFuncionarioSolicitanteId = funcionarioByFuncionarioSolicitanteId;
        this.origem = origem;
        this.origim = origim;
        this.prioridade = prioridade;
        this.situacao = situacao;
        this.tipo = tipo;
        this.titulo = titulo;
        this.idAbertura = idAbertura;
    }
    public Chamado(CategoriaUm categoriaUm, Chamado chamado, Empresa empresa, Funcionario funcionarioByFuncionarioAberturaId, Funcionario funcionarioByFuncionarioAtendenteId, Funcionario funcionarioByFuncionarioSolicitanteId, Origem origem, Origim origim, Pessoa pessoa, Prioridade prioridade, Situacao situacao, Tipo tipo, String titulo, String descricao, Date dataAbertura, Date dataFechamento, Date dataPrevista, Integer funcionarioId, int idAbertura, Set interacaos, Set chamados) {
       this.categoriaUm = categoriaUm;
       this.chamado = chamado;
       this.empresa = empresa;
       this.funcionarioByFuncionarioAberturaId = funcionarioByFuncionarioAberturaId;
       this.funcionarioByFuncionarioAtendenteId = funcionarioByFuncionarioAtendenteId;
       this.funcionarioByFuncionarioSolicitanteId = funcionarioByFuncionarioSolicitanteId;
       this.origem = origem;
       this.origim = origim;
       this.pessoa = pessoa;
       this.prioridade = prioridade;
       this.situacao = situacao;
       this.tipo = tipo;
       this.titulo = titulo;
       this.descricao = descricao;
       this.dataAbertura = dataAbertura;
       this.dataFechamento = dataFechamento;
       this.dataPrevista = dataPrevista;
       this.funcionarioId = funcionarioId;
       this.idAbertura = idAbertura;
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
    public Origim getOrigim() {
        return this.origim;
    }
    
    public void setOrigim(Origim origim) {
        this.origim = origim;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
    public Integer getFuncionarioId() {
        return this.funcionarioId;
    }
    
    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
    public int getIdAbertura() {
        return this.idAbertura;
    }
    
    public void setIdAbertura(int idAbertura) {
        this.idAbertura = idAbertura;
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


