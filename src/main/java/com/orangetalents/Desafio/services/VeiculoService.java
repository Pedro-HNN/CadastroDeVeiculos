package com.orangetalents.Desafio.services;

import com.orangetalents.Desafio.dto.VeiculoRespostaDTO;
import com.orangetalents.Desafio.openfeign.PesquisaFipe;
import com.orangetalents.Desafio.dto.VeiculoDTO;
import com.orangetalents.Desafio.entities.ClienteEntity;
import com.orangetalents.Desafio.entities.VeiculoEntity;
import com.orangetalents.Desafio.openfeign.FipeEndpoint;
import com.orangetalents.Desafio.repositories.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepo veiculoRepository;

    @Autowired
    FipeEndpoint fipe;


    public VeiculoRespostaDTO salvar(PesquisaFipe dto, ClienteEntity cliente){

        VeiculoDTO veiculoDTO = new VeiculoDTO(fipe.Get(dto.getTipo(),dto.getMarca(),dto.getModelo(), dto.getAno()));

        VeiculoEntity veiculo = new VeiculoEntity(cliente,veiculoDTO.getMarca(),veiculoDTO.getModelo(),veiculoDTO.getAno());

        veiculo = veiculoRepository.save(veiculo);
        return new VeiculoRespostaDTO(veiculo);
    }

    public List<VeiculoEntity> acharVeiculos(ClienteEntity cpf){
        return veiculoRepository.findByCpf(cpf);
    }

}
