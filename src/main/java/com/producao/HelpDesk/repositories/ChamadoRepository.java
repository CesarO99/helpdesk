package com.producao.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producao.HelpDesk.crud.entities.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
