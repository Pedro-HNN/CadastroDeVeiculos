package com.orangetalents.Desafio.openfeign;

import java.io.Serializable;

public class PesquisaFipe implements Serializable {
    private static final long serialVersionUID = 1L;

    private String marca;

    private String modelo;

    private String ano;

    private String tipo;

    //gets...

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    public String getTipo() {
        return tipo;
    }
}
