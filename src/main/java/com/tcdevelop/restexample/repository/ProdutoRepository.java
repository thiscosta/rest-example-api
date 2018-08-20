package com.tcdevelop.restexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcdevelop.restexample.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
