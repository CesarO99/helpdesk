package com.producao.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.producao.HelpDesk.crud.entities.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
