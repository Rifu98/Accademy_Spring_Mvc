package com.federicorifugiato.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.federicorifugiato.dao.UtenteDao;
import com.federicorifugiato.dto.UtenteDto;
import com.federicorifugiato.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	private UtenteDao utenteDao;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public void registraUtente(Utente utente) {
		
		utenteDao.save(utente);
		
	}

	@Override
	public Utente getUtenteById(int id) {
		
		Optional<Utente> optionalUtente = utenteDao.findById(id);
		if(optionalUtente.isPresent()) {
			 return optionalUtente.get();
		}
		return null;
	}

	@Override
	public List<Utente> getUtenti() {
		return (List<Utente>) utenteDao.findAll();
	}

	@Override
	public void cancellaUtente(int id) {
		
		Optional<Utente> optionalUtente= utenteDao.findById(id);
		if(optionalUtente.isPresent()) {
			Utente utente = optionalUtente.get();
			utenteDao.delete(utente);
		}
		
	}

	// i DTO e il Mapping mi serve solo nelle one to many e nelle many to many ney rest con jersey
	@Override
	public List<UtenteDto> getUtentiDto() {
		
		List<Utente> users = (List<Utente>) utenteDao.findAll();
		List<UtenteDto> usersDto = new ArrayList<>();
		
		users.forEach(u -> usersDto.add(modelMapper.map(u, UtenteDto.class)));
		
		return usersDto;
	}

}
