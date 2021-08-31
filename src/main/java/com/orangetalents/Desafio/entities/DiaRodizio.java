package com.orangetalents.Desafio.entities;

public enum DiaRodizio {
    MONDAY(0,1), TUESDAY(2,3), WEDNESDAY(4,5), THURSDAY(6,7), FRIDAY(8,9);

    private int primeiroDigito;
    private int segundoDigito;

    DiaRodizio(int primeiro, int segundo){
        this.primeiroDigito = primeiro;
        this.segundoDigito = segundo;
    }

    public Boolean verificaDia(int digito){
        return  primeiroDigito == digito || segundoDigito == digito;

    }
}
