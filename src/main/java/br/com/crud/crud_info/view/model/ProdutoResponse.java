package br.com.crud.crud_info.view.model;

public class ProdutoResponse {

  private Integer id;

  private String nome;

  private Integer quantidade;

  private Double valor;

  private String observacao;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ProdutoResponse id(Integer id) {
    this.id = id;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ProdutoResponse nome(String nome) {
    this.nome = nome;
    return this;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public ProdutoResponse quantidade(Integer quantidade) {
    this.quantidade = quantidade;
    return this;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public ProdutoResponse valor(Double valor) {
    this.valor = valor;
    return this;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public ProdutoResponse observacao(String observacao) {
    this.observacao = observacao;
    return this;
  }
}
