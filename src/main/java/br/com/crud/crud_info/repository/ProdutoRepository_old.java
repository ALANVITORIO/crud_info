package br.com.crud.crud_info.repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import br.com.crud.crud_info.model.Produto;
import br.com.crud.crud_info.model.exception.ResouceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository_old {

  private List<Produto> produtos = new ArrayList<Produto>();
  private Integer ultimoId = 0;

  public List<Produto> obterTodos() {
    /** Metodo para retornar uma lista de produtos */
    return produtos;

  }

  // encontra o produto por id
  public Optional<Produto> obterPorId(Integer id) {
    return produtos
        .stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
  }

  public Produto adicionar(Produto produto) {

    ultimoId++;
    produto.setId(ultimoId);
    produtos.add(produto);

    return produto;
  }

  public void deletar(Integer id) {
    produtos.removeIf(produto -> produto.getId() == id);
  }

  public Produto atualizar(Produto produto) {
    Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
    if (produtoEncontrado.isEmpty()) {
      throw new ResouceNotFoundException("Produto não encontrado");
    }
    deletar(produto.getId());
    produtos.add(produto);
    return produto;

  }

}
