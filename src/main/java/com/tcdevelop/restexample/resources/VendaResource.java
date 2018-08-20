package com.tcdevelop.restexample.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcdevelop.restexample.model.Venda;
import com.tcdevelop.restexample.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaResource {

	@Autowired
	VendaService vs;
	
	@GetMapping
	public List<Venda> listar(){
		return vs.findAll();
	}
}
