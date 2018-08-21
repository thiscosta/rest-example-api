package com.tcdevelop.restexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcdevelop.restexample.model.Cliente;
import com.tcdevelop.restexample.model.Usuario;
import com.tcdevelop.restexample.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository cr;
	
	public List<Cliente> findAll(){
		return cr.findAll();
	}
	public Cliente save(Cliente cliente) {
		return cr.save(cliente);
	}
	public Optional<Cliente> findById(Long id) {
		return cr.findById(id);
	}
	public void deleteById(Long id) {
		cr.deleteById(id);
	}
}
