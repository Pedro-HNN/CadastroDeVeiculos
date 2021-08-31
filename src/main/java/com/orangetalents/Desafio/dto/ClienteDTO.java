package com.orangetalents.Desafio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orangetalents.Desafio.entities.ClienteEntity;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


public class ClienteDTO implements Serializable {
    private static final long serialVersionUID =1L;

    @NotBlank(message = "Digite um CPF!")
    @CPF(message="Digite um CPF válido!")
    private String cpf;

    @NotBlank(message="Digite seu nome!")
    private String nome;

    @NotBlank(message = "Digite um Email!")
    @Email(message="Digite um email válido!!")
    private String email;

    @JsonFormat(pattern ="yyyy-MM-dd", timezone = "UTC-3")
    private Date dataNasc;

    //constructors/gets...

    //constructor
    public ClienteDTO(ClienteEntity cliente){
        this.cpf = cliente.getCPF();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.dataNasc = cliente.getDataNasc();
    }

    public ClienteDTO(){}//JPA Constructor

    //getters
    public String getCPF() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }
}
