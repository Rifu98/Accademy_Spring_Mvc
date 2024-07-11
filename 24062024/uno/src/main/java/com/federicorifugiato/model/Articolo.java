package com.federicorifugiato.model;

public class Articolo {
	private String descrizione;
	private int id;
	private double prezzo;
	
	public String getDescrizione () {
		return this.descrizione;
	}
	public int getId () {
		return this.id;
	}
	public double getPrezzo () {
		return this.prezzo;
	}
	public void setDescrizione (String desc) {
		this.descrizione=desc;
	}
	public void setId (int id) {
		this.id=id;
	}
	public void setPrezzo (double prezzo) {
		this.prezzo = prezzo;
	}
}
