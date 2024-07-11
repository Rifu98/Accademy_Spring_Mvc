package com.federicorifugiato.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordini")
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String indirizzo;
	
    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "ordini_prodotti",
        joinColumns = @JoinColumn(name = "id_ordine"),
        inverseJoinColumns = @JoinColumn(name = "id_prodotto")
    )
    private List<Prodotto> prodotti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
}
