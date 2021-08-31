package com.orangetalents.Desafio.repositories;

import com.orangetalents.Desafio.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<ClienteEntity,String> {
}
