package com.tcdevelop.restexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcdevelop.restexample.model.Produto;
import com.tcdevelop.restexample.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository pr;
	
	public List<Produto> findAll(){
		return pr.findAll();
	}
	public Produto save(Produto produto) {
		return pr.save(produto);
	}
	public Optional<Produto> findById(Long id) {
		return pr.findById(id);
	}
	public void deleteById(Long id) {
		pr.deleteById(id);
	}
}
