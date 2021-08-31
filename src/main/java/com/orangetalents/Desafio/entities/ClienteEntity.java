package com.orangetalents.Desafio.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tb_cliente")
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private Date dataNasc;


    //constructors/gets...

    public ClienteEntity(String CPF, String nome, String email, Date dataNasc){
        this.cpf = CPF;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public ClienteEntity(){}//JPA Constructor

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
