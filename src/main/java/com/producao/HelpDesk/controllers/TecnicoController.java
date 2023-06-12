package com.producao.HelpDesk.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.producao.HelpDesk.crud.entities.Tecnico;
import com.producao.HelpDesk.dtos.TecnicoDto;
import com.producao.HelpDesk.services.tecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {
	
	@Autowired
	private tecnicoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id){
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDto(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDto>> findAll(){
		List<Tecnico> list = service.findAll();
		List<TecnicoDto> lista = list.stream().map(obj -> new TecnicoDto()).collect(Collectors.toList());
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDto> create(@RequestBody TecnicoDto tecnicoDto){
		Tecnico newObj = service.create(tecnicoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		//Ao criar um novo objeto, será notificado a URI/Url de criação desse novo objeto, por exemplo: localhost:8080/tecnicos/1 , se for o primeiro a ser criado.
		return ResponseEntity.created(uri).build();
	}
}
