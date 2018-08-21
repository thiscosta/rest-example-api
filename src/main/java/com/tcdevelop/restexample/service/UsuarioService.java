package com.tcdevelop.restexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcdevelop.restexample.model.Usuario;
import com.tcdevelop.restexample.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository ur;
	
	public List<Usuario> findAll(){
		return ur.findAll();
	}
	public Usuario save(Usuario usuario) {
		return ur.save(usuario);
	}
	public Optional<Usuario> findById(Long id) {
		return ur.findById(id);
	}
	public void deleteById(Long id) {
		ur.deleteById(id);
	}
}
