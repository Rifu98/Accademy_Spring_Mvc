package com.federicorifugiato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.federicorifugiato.model.Articolo;

@Service
public class ArticoloServiceImpl implements ArticoloService {

	@Override
	public List<Articolo> getCatalogo() {
		List<Articolo> catalogo = new ArrayList<>();
		Articolo articolo1 = new Articolo ();
		articolo1.setDescrizione("ads");
		articolo1.setId(1);
		articolo1.setPrezzo(10);
		Articolo articolo2 = new Articolo ();
		articolo2.setDescrizione("sadf");
		articolo2.setId(2);
		articolo2.setPrezzo(130);
		catalogo.add(articolo1);
		catalogo.add(articolo2);
		return catalogo;
	}

}
