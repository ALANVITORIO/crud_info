package br.com.crud.crud_info.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.crud_info.model.Produto;
import br.com.crud.crud_info.model.exception.ResourceNotFoundException;
import br.com.crud.crud_info.repository.ProdutoRepository_old;
import br.com.crud.crud_info.shared.ProdutoDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository_old produtoRepository;

  private ModelMapper modelMapper = new ModelMapper();

  public List<ProdutoDTO> obterTodos() {
    List<Produto> produtos = produtoRepository.obterTodos();

    return produtos.stream()
        .map(produto -> modelMapper.map(produto, ProdutoDTO.class))
        .collect(Collectors.toList());
  }

  public Optional<ProdutoDTO> obterPorId(Integer id) {
    Optional<Produto> produto = produtoRepository.obterPorId(id);
    if (produto.isEmpty()) {
      throw new ResourceNotFoundException("Produto com id : " + id + " Não encontrado");
    }

    ProdutoDTO dto = modelMapper.map(produto.get(), ProdutoDTO.class);
    return Optional.of(dto);
  }

  public ProdutoDTO adicionar(ProdutoDTO produtoDto) {
    produtoDto.setId(null);

    Produto produto = modelMapper.map(produtoDto, Produto.class);
    produto = produtoRepository.adicionar(produto);
    produtoDto.setId(produto.getId());

    return produtoDto;
  }

  public void deletar(Integer id) {
    Optional<Produto> produto = produtoRepository.obterPorId(id);
    if (produto.isEmpty()) {
      throw new ResourceNotFoundException("Não foi possível deletar o produto com o id:" + id);
    }

    produtoRepository.deletar(id);
  }

  public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {
    produtoDto.setId(id);

    Produto produto = modelMapper.map(produtoDto, Produto.class);
    produto = produtoRepository.atualizar(produto);

    return produtoDto;
  }
}
