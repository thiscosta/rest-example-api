package com.tcdevelop.restexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcdevelop.restexample.model.Venda;
import com.tcdevelop.restexample.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository vr;
	
	public List<Venda> findAll(){
		return vr.findAll();
	}
	
}
