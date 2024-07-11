package com.federicorifugiato.dao;

import org.springframework.data.repository.CrudRepository;

import com.federicorifugiato.model.Ordine;

public interface OrdineDao extends CrudRepository<Ordine, Integer>{}
