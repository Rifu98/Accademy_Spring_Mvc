package com.federicorifugiato.dto;

import java.util.List;

public class UtenteDto {

    private int id;
    private String nome;

    private List<UtenteOrdineDto> ordini;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<UtenteOrdineDto> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<UtenteOrdineDto> ordini) {
        this.ordini = ordini;
    }

}
