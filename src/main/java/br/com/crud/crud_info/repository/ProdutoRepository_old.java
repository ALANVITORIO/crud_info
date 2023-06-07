package br.com.crud.crud_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crud.crud_info.model.Produto;

import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository_old extends JpaRepository<Produto, Integer> {
}