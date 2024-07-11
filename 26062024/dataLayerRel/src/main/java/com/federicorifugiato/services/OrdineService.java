package com.federicorifugiato.services;

import java.util.List;

import com.federicorifugiato.model.Ordine;

public interface OrdineService {

	void registraOrdine(Ordine ordine);
	Ordine getOrdineById(int id);
	List<Ordine> getOrdini();
	void cancellaOrdine(int id);
}
