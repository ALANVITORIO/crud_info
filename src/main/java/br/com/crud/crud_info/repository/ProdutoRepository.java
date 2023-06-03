package br.com.crud.crud_info.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.crud.crud_info.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

  private List<Produto> produtos = new ArrayList<Produto>();
  private Integer ultimoId = 0;

  public List<Produto> obterTodos() {
    return produtos;
  }
}
