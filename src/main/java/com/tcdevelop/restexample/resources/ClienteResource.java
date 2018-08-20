package com.tcdevelop.restexample.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcdevelop.restexample.model.Cliente;
import com.tcdevelop.restexample.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	ClienteService cs;
	
	@GetMapping
	public List<Cliente> listar(){
		return cs.findAll();
	}
}
