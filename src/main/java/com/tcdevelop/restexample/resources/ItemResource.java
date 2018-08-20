package com.tcdevelop.restexample.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
