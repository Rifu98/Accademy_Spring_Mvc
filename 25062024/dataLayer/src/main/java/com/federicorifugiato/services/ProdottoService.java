package com.federicorifugiato.services;

import java.util.List;

import com.federicorifugiato.model.Prodotto;

public interface ProdottoService {

	void registraProdotto(Prodotto prodotto);
	Prodotto getProdottoById(int id);
	List<Prodotto> getProdotti();
	void cancellaProdotto(int id);
}
