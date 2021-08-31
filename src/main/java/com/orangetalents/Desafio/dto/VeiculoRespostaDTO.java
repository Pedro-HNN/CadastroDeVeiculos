package com.orangetalents.Desafio.dto;

import com.orangetalents.Desafio.entities.DiaRodizio;
import com.orangetalents.Desafio.entities.VeiculoEntity;

import java.io.Serializable;

public class VeiculoRespostaDTO implements Serializable {
    private static final long serialVersionUID =1L;

    private String marca;

    private String modelo;

    private int ano;

    private DiaRodizio diaRodizio;

    private boolean rodizioAtivo;

    //constructors/gets...

    public VeiculoRespostaDTO(VeiculoEntity veiculo){
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.diaRodizio = veiculo.getDiaRodizio();
        this.rodizioAtivo = veiculo.isRodizioAtivo();
    }

    public VeiculoRespostaDTO(){}//JPA Constructor


    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public DiaRodizio getDiaRodizio() {
        return diaRodizio;
    }

    public boolean isRodizioAtivo() {
        return rodizioAtivo;
    }
}
