package com.federicorifugiato.dto;

import java.util.List;

public class UtenteOrdineDto {
	
	private int id;
	private String indirizzo;
	
    private List<OrdineProdottoDto> prodotti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public List<OrdineProdottoDto> getProdotti() {
		return prodotti;
	}
	public void setProdotti(List<OrdineProdottoDto> prodotti) {
		this.prodotti = prodotti;
	}
	

}
