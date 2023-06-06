package br.com.crud.crud_info.view.controller.handlers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.crud.crud_info.services.ProdutoService;
import br.com.crud.crud_info.shared.ProdutoDTO;
import br.com.crud.crud_info.view.model.ProdutoRequest;
import br.com.crud.crud_info.view.model.ProdutoResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @GetMapping
  public ResponseEntity<List<ProdutoResponse>> obterTodos() {
    List<ProdutoDTO> produtos = produtoService.obterTodos();
    ModelMapper mapper = new ModelMapper();

    List<ProdutoResponse> resposta = produtos.stream()
        .map(produtoDto -> mapper.map(produtoDto, ProdutoResponse.class))
        .collect(Collectors.toList());

    return new ResponseEntity<>(resposta, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProdutoResponse> obterPorId(@PathVariable Integer id) {
    Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
    if (dto.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    ProdutoResponse produto = new ModelMapper().map(dto.get(), ProdutoResponse.class);
    return new ResponseEntity<>(produto, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoReq) {
    ModelMapper mapper = new ModelMapper();
    ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);
    produtoDto = produtoService.adicionar(produtoDto);
    return new ResponseEntity<>(mapper.map(produtoDto, ProdutoResponse.class), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletar(@PathVariable Integer id) {
    produtoService.deletar(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest produtoReq) {
    ModelMapper mapper = new ModelMapper();
    ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);
    produtoDto = produtoService.atualizar(id, produtoDto);
    return new ResponseEntity<>(mapper.map(produtoDto, ProdutoResponse.class), HttpStatus.OK);
  }
}
