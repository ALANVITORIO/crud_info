package br.com.crud.crud_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crud.crud_info.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
