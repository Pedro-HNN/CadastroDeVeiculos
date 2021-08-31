package com.orangetalents.Desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orangetalents.Desafio.entities.VeiculoEntity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class VeiculoDTO implements Serializable {
    private static final long serialVersionUID =1L;

    @NotBlank(message = "Digite um código de Marca!")
    @JsonProperty("Marca")
    private String Marca;

    @NotBlank(message = "Digite um código de Modelo!")
    @JsonProperty("Modelo")
    private String Modelo;

    @NotBlank(message = "Digite um código de Ano!")
    @JsonProperty("AnoModelo")
    private int AnoModelo;


    //constructors/gets...

    public VeiculoDTO(VeiculoEntity veiculo){
        this.Marca = veiculo.getMarca();
        this.Modelo = veiculo.getModelo();
        this.AnoModelo = veiculo.getAno();
    }

    public VeiculoDTO(VeiculoDTO dto){
        this.Marca = dto.getMarca();
        this.Modelo = dto.getModelo();
        this.AnoModelo = dto.getAno();
    }

    public VeiculoDTO(){}//JPA Constructor

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getAno() {
        return AnoModelo;
    }


}