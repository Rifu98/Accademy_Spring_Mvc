package com.federicorifugiato.dao;

import org.springframework.data.repository.CrudRepository;

import com.federicorifugiato.model.Prodotto;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer>{}
