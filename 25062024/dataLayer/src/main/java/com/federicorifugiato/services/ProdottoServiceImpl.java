package com.federicorifugiato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.federicorifugiato.dao.ProdottoDao;
import com.federicorifugiato.model.Prodotto;

@Service
public class ProdottoServiceImpl implements ProdottoService{

	@Autowired
	private ProdottoDao prodottoDao;
	
	@Override
	public void registraProdotto(Prodotto prodotto) {
		
		prodottoDao.save(prodotto);
		
	}

	@Override
	public Prodotto getProdottoById(int id) {
		
		Optional<Prodotto> optionalProdotto = prodottoDao.findById(id);
		if(optionalProdotto.isPresent()) {
			 return optionalProdotto.get();
		}
		return null;
	}

	@Override
	public List<Prodotto> getProdotti() {
		return (List<Prodotto>) prodottoDao.findAll();
	}

	@Override
	public void cancellaProdotto(int id) {
		
		Optional<Prodotto> optionalProdotto = prodottoDao.findById(id);
		if(optionalProdotto.isPresent()) {
			Prodotto prodotto = optionalProdotto.get();
			prodottoDao.delete(prodotto);
		}
		
	}

}
