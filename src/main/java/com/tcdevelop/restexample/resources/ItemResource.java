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

import com.tcdevelop.restexample.model.Item;
import com.tcdevelop.restexample.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemResource {

	@Autowired
	ItemService is;
	
	@GetMapping
	public List<Item> listar(){
		return is.findAll();
	}
	@PostMapping
	public Item salvar(Item item) {
		return is.save(item);
	}
	@GetMapping("/{id}")
	public Optional<Item> listarUm(@Valid @PathVariable Long id) {
		return is.findById(id);
	}
	@PutMapping("/{id}")
	public Item atualizar(@Valid @PathVariable Long id, 
				@RequestBody Item item) {
		if(is.findById(id) == null) {
			throw new RuntimeException("O item de id "+id+" não existe.");
		}else {
			item.setId(id);
			return is.save(item);
		}
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		is.deleteById(id);
	}
	
}
