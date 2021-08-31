package com.orangetalents.Desafio.controller;

import com.orangetalents.Desafio.dto.ClienteDTO;
import com.orangetalents.Desafio.entities.ClienteEntity;
import com.orangetalents.Desafio.entities.VeiculoEntity;
import com.orangetalents.Desafio.openfeign.PesquisaFipe;
import com.orangetalents.Desafio.repositories.ClienteRepo;
import com.orangetalents.Desafio.services.ClienteService;
import com.orangetalents.Desafio.services.VeiculoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ControllerPost {

    @Autowired
    ClienteService clienteService;

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    ClienteRepo clienteRepository;

    //endpoint 1 - Cadastro cliente
    @PostMapping(value = "/cliente/registrar")
    public ResponseEntity<ClienteEntity> PostCliente(@NotNull @RequestBody @Valid ClienteDTO dto){

        Optional<ClienteEntity> checkCPF = clienteRepository.findById(dto.getCPF());

        if(checkCPF.isPresent()){
            return new ResponseEntity("CPF já está cadastrado!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(clienteService.salvar(dto), HttpStatus.CREATED);

    }

    //endpoint 2 - Cadastro veículo
    @PostMapping(value = "/veiculo/registrar/{cpf}")
    public ResponseEntity<VeiculoEntity> PostVeiculo(@PathVariable(value="cpf") String cpf, @NotNull @RequestBody @Valid PesquisaFipe dto){

        Optional<ClienteEntity> checkCPF = clienteRepository.findById(cpf);

        if(checkCPF.isPresent()){
            ClienteEntity cliente = checkCPF.get();

            return new ResponseEntity(veiculoService.salvar(dto,cliente), HttpStatus.CREATED);
        }
        return new ResponseEntity("CPF não cadastrado!",HttpStatus.BAD_REQUEST);

    }
}
