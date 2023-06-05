package br.com.crud.crud_info.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.crud_info.model.Produto;
import br.com.crud.crud_info.repository.ProdutoRepository;

@Service
public class ProdutoService {
  @Autowired
  private ProdutoRepository produtoRepository;

  public List<Produto> obterTodoss() {
    return produtoRepository.obterTodos();
  }

  public Optional<Produto> obterPorId(Integer id) {
    return produtoRepository.obterPorId(id);
  }

  public Produto adicionar(Produto produto) {
    return produtoRepository.adicionar(produto);
  }

  public void deletar(Integer id) {
    produtoRepository.deletar(id);
  }

  public Produto atualizar(Integer id, Produto produto) {
    // ter alguma validação
    produto.setId(id);
    return produtoRepository.atualizar(produto);
  }

}
