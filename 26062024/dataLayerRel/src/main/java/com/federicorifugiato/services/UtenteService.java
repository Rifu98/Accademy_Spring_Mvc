package com.federicorifugiato.services;

import java.util.List;

import com.federicorifugiato.dto.UtenteDto;
import com.federicorifugiato.model.Utente;

public interface UtenteService {

	void registraUtente(Utente utente);
	Utente getUtenteById(int id);
	List<Utente> getUtenti();
	void cancellaUtente(int id);
	List<UtenteDto> getUtentiDto();
}
