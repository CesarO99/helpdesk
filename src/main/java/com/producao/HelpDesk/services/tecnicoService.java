package com.producao.HelpDesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producao.HelpDesk.crud.entities.Pessoa;
import com.producao.HelpDesk.crud.entities.Tecnico;
import com.producao.HelpDesk.dtos.TecnicoDto;
import com.producao.HelpDesk.repositories.PessoaRepository;
import com.producao.HelpDesk.repositories.TecnicoRepository;

@Service
public class tecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElse(null);
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

	public Tecnico create(TecnicoDto dto) {
		dto.setId(null);
		validaPorCpfEEmail(dto);
		Tecnico newObj = new Tecnico(dto);
		return tecnicoRepository.save(newObj);
	}
	
	public Tecnico update(TecnicoDto dto) {
		dto.setId(dto.getId());
		Tecnico oldObj = findById(dto.getId());
		validaPorCpfEEmail(dto);
		oldObj = new Tecnico(dto);
		return tecnicoRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if(obj.getChamados().size() > 0) {
			System.out.println("Técnico possui chamados cadastrados");
		} else {
			tecnicoRepository.delete(obj);
		}
	}

	private void validaPorCpfEEmail(TecnicoDto dto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(dto.getCpf());
		if(obj.isPresent() && obj.get().getId() != dto.getId()) {
			System.out.println("Técnico já cadastrado no sistema");
		}
		
		obj = pessoaRepository.findByEmail(dto.getEmail());
		if(obj.isPresent() && obj.get().getId() != dto.getId()) {
			System.out.println("Técnico já cadastrado no sistema");
		}
			
		
	}

}
