package com.orangetalents.Desafio.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

@Entity
@Table(name="tb_veiculo")
public class VeiculoEntity implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DiaRodizio diaRodizio;

    @Column(nullable = false)
    private boolean rodizioAtivo;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "fk_cliente_cpf",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClienteEntity cpf;

    //verificação do dia
    private Boolean diaAtivo(DiaRodizio dia){
        DayOfWeek hoje = LocalDate.now().getDayOfWeek();
        return hoje.name().equals(diaRodizio.name());
    }

    //definição do dia do rodízio
    private DiaRodizio defineDiaRodizio(int ano){
        int ultimoDigito = ano % 10;

        return Stream.of(DiaRodizio.values())
                .filter(t -> t.verificaDia(ultimoDigito))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    //constructors/gets...

    public VeiculoEntity(ClienteEntity CPF, String marca, String modelo, int ano){
        this.cpf = CPF;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.diaRodizio = defineDiaRodizio(this.ano);
        this.rodizioAtivo = diaAtivo(this.getDiaRodizio());
    }

    public VeiculoEntity(){}//JPA Constructor

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
