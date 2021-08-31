package com.orangetalents.Desafio.repositories;

import com.orangetalents.Desafio.entities.ClienteEntity;
import com.orangetalents.Desafio.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepo extends JpaRepository<VeiculoEntity,Long> {
    List<VeiculoEntity> findByCpf(ClienteEntity cpf);
}
