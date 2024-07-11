package com.federicorifugiato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.federicorifugiato.dao.OrdineDao;
import com.federicorifugiato.model.Ordine;
import com.federicorifugiato.model.Utente;
import com.federicorifugiato.exceptions.UserNotFoundException;

@Service
public class OrdineServiceImpl implements OrdineService{

	@Autowired
	private OrdineDao ordineDao;
	@Autowired
	private UtenteService utenteService;
	
	@Override
	public void registraOrdine(Ordine ordine) throws UserNotFoundException {
		
		Utente utente = utenteService.getUtenteById(ordine.getUtente().getId());
		if (utente != null) {
			ordine.setUtente(utente);
			ordineDao.save(ordine);
		} else {
			throw new UserNotFoundException("Utente non trovato");
		}
		
	}

	@Override
	public Ordine getOrdineById(int id) {
		
		Optional<Ordine> optionalOrdine = ordineDao.findById(id);
		if(optionalOrdine.isPresent()) {
			 return optionalOrdine.get();
		}
		return null;
	}

	@Override
	public List<Ordine> getOrdini() {
		return (List<Ordine>) ordineDao.findAll();
	}

	@Override
	public void cancellaOrdine(int id) {
		
		Optional<Ordine> optionalOrdine= ordineDao.findById(id);
		if(optionalOrdine.isPresent()) {
			Ordine ordine = optionalOrdine.get();
			ordineDao.delete(ordine);
		}
		
	}

}
