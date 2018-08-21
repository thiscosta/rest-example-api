package com.tcdevelop.restexample.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcdevelop.restexample.model.Produto;
import com.tcdevelop.restexample.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	ProdutoService ps;
	
	@GetMapping
	public List<Produto> listar(){
		return ps.findAll();
	}
	@PostMapping
	public Produto salvar(Produto produto) {
		return ps.save(produto);
	}
	@GetMapping("/{id}")
	public Optional<Produto> listarUm(@Valid @PathVariable Long id) {
		return ps.findById(id);
	}
	@PutMapping("/{id}")
	public Produto atualizar(@Valid @PathVariable Long id, 
				@RequestBody Produto produto) {
		if(ps.findById(id) == null) {
			throw new RuntimeException("O produto de id "+id+" não existe.");
		}else {
			produto.setId(id);
			return ps.save(produto);
		}
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		ps.deleteById(id);
	}
}
