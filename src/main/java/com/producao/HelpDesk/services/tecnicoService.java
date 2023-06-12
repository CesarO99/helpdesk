package com.producao.HelpDesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producao.HelpDesk.crud.entities.Tecnico;
import com.producao.HelpDesk.dtos.TecnicoDto;
import com.producao.HelpDesk.repositories.TecnicoRepository;

@Service
public class tecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElse(null);
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

	public Tecnico create(TecnicoDto dto) {
		dto.setId(null);
		Tecnico newObj = new Tecnico(dto);
		return tecnicoRepository.save(newObj);
	}

}
