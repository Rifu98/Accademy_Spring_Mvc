package com.federicorifugiato.dao;

import org.springframework.data.repository.CrudRepository;

import com.federicorifugiato.model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Integer>{}
