package model.entity;

import model.transferobject.TOProfessor;

public class Atividade {

	private String id;
	private String nome;
	private String diaSemana;
	private String horarioInicio;
	private String horarioFim;
	private Double valorAcrescido;
	private TOProfessor professor;
	
	public Atividade() {
		super();
		this.valorAcrescido = 0.00;
	}

	public Atividade(String nome) {
		super();
		this.nome = nome;
	}
	
	public Atividade(String id, String nome, String diaSemana, String horarioInicio, String horarioFim, Double valorAcrescido, TOProfessor professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.diaSemana = diaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.valorAcrescido = valorAcrescido;
		this.professor = professor;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}


	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Double getValorAcrescido() {
		return valorAcrescido;
	}

	public void setValorAcrescido(Double valorAcrescido) {
		this.valorAcrescido = valorAcrescido;
	}

	public TOProfessor getProfessor() {
		return professor;
	}

	public void setProfessor(TOProfessor professor) {
		this.professor = professor;
	}
	
}
