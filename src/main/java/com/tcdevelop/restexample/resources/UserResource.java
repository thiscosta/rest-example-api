package com.tcdevelop.restexample.resources;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcdevelop.restexample.model.Usuario;
import com.tcdevelop.restexample.service.UsuarioService;


@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	UsuarioService us;
	
	@GetMapping
	public List<Usuario> listar(Principal principal) {		
		return us.findAll();
	}
}
