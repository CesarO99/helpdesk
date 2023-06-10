package com.producao.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producao.HelpDesk.crud.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
