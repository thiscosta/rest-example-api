package com.tcdevelop.restexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcdevelop.restexample.model.Item;
import com.tcdevelop.restexample.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository ir;
	
	public List<Item> findAll(){
		return ir.findAll();
	}
	
}
