package com.orangetalents.Desafio.services;

import com.orangetalents.Desafio.dto.ClienteDTO;
import com.orangetalents.Desafio.entities.ClienteEntity;
import com.orangetalents.Desafio.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepo clienteRepository;

    public ClienteDTO salvar(ClienteDTO dto){
        ClienteEntity cliente = new ClienteEntity(dto.getCPF(), dto.getNome(), dto.getEmail(),dto.getDataNasc());
        cliente = clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }
}
