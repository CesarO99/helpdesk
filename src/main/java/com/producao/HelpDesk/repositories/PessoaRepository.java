package com.producao.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producao.HelpDesk.crud.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
