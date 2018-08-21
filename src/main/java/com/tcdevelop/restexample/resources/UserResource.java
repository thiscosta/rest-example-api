package com.tcdevelop.restexample.resources;

import java.security.Principal;
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

import com.tcdevelop.restexample.model.Usuario;
import com.tcdevelop.restexample.service.UsuarioService;


@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	UsuarioService us;
	
	@GetMapping
	public List<Usuario> listar() {		
		return us.findAll();
	}
	@PostMapping
	public Usuario salvar(Usuario usuario) {
		return us.save(usuario);
	}
	@GetMapping("/{id}")
	public Optional<Usuario> listarUm(@Valid @PathVariable Long id) {
		return us.findById(id);
	}
	@PutMapping("/{id}")
	public Usuario atualizar(@Valid @PathVariable Long id, 
				@RequestBody Usuario usuario) {
		if(us.findById(id) == null) {
			throw new RuntimeException("O usuário de id "+id+" não existe.");
		}else {
			usuario.setId(id);
			return us.save(usuario);
		}
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		us.deleteById(id);
	}
}
