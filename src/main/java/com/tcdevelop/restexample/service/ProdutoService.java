package com.tcdevelop.restexample.service;

import java.util.List;

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
}
