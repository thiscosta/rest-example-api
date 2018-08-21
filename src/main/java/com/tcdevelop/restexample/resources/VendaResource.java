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
	@PostMapping
	public Venda salvar(Venda venda) {
		return vs.save(venda);
	}
	@GetMapping("/{id}")
	public Optional<Venda> listarUm(@Valid @PathVariable Long id) {
		return vs.findById(id);
	}
	@PutMapping("/{id}")
	public Venda atualizar(@Valid @PathVariable Long id, 
				@RequestBody Venda venda) {
		if(vs.findById(id) == null) {
			throw new RuntimeException("A venda de id "+id+" não existe.");
		}else {
			venda.setId(id);
			return vs.save(venda);
		}
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		vs.deleteById(id);
	}
}
