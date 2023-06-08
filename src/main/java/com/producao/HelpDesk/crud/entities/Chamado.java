package com.producao.HelpDesk.crud.entities;

import java.time.LocalDate;

import com.producaoHelpDesk.crud.enums.Prioridade;
import com.producaoHelpDesk.crud.enums.Status;

public class Chamado {
	
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacao;
	
	
}
