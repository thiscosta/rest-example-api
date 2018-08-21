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
	@PostMapping
	public Cliente salvar(Cliente cliente) {
		return cs.save(cliente);
	}
	@GetMapping("/{id}")
	public Optional<Cliente> listarUm(@Valid @PathVariable Long id) {
		return cs.findById(id);
	}
	@PutMapping("/{id}")
	public Cliente atualizar(@Valid @PathVariable Long id, 
				@RequestBody Cliente cliente) {
		if(cs.findById(id) == null) {
			throw new RuntimeException("O cliente de id "+id+" não existe.");
		}else {
			cliente.setId(id);
			return cs.save(cliente);
		}
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		cs.deleteById(id);
	}
}
