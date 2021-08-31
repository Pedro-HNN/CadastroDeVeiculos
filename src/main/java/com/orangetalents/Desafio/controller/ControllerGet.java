package com.orangetalents.Desafio.controller;

import com.orangetalents.Desafio.entities.ClienteEntity;
import com.orangetalents.Desafio.entities.VeiculoEntity;
import com.orangetalents.Desafio.repositories.ClienteRepo;
import com.orangetalents.Desafio.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ControllerGet {

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    ClienteRepo clienteRepository;

    //endpoint 3 - Listagem veículos cadastrados no cpf de um cliente
    @GetMapping(value= "/veiculo/{cpf}")
    public ResponseEntity<List<VeiculoEntity>> GetVeiculo(@PathVariable(value="cpf") String cpf){

        Optional<ClienteEntity> checkCPF = clienteRepository.findById(cpf);

        if(checkCPF.isPresent()){
            ClienteEntity cliente = checkCPF.get();

            List<VeiculoEntity> veiculos = veiculoService.acharVeiculos(cliente);

            if(veiculos.isEmpty()){
                return new ResponseEntity("Não há nenhum veículo cadastrado nesse CPF!",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(veiculos, HttpStatus.OK);

        }
        return new ResponseEntity("CPF não cadastrado!", HttpStatus.NOT_FOUND);

    }
}
