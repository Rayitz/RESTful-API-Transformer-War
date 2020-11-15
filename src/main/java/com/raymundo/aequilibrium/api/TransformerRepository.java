package com.raymundo.aequilibrium.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raymundo.aequilibrium.model.Transformer;

public interface TransformerRepository extends JpaRepository<Transformer, Long> {

	public Transformer getTransformerByName(String name);
	

}