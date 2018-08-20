package com.tcdevelop.restexample.service;

import java.util.List;

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
	
}
