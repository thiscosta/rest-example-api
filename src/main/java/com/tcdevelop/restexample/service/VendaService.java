package com.tcdevelop.restexample.service;

import java.util.List;
import java.util.Optional;

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
	public Venda save(Venda venda) {
		return vr.save(venda);
	}
	public Optional<Venda> findById(Long id) {
		return vr.findById(id);
	}
	public void deleteById(Long id) {
		vr.deleteById(id);
	}
}
