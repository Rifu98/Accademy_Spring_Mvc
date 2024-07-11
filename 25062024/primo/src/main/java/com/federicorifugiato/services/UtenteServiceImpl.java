package com.federicorifugiato.services;

import org.springframework.stereotype.Service;

import com.federicorifugiato.model.User;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Override
	public void registrazioneUtente(User user) {
		System.out.println("Utente " + user.getNome() + " registrato!");
	}

}
