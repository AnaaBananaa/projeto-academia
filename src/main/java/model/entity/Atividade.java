package model.entity;

public class Atividade {

	String id;
	String nome;
	String diaSemana;
	String horarioInicio;
	String horarioFim;
	
	public Atividade() {
		super();
	}

	public Atividade(String nome) {
		super();
		this.nome = nome;
	}
	
	public Atividade(String id, String nome, String diaSemana, String horarioInicio, String horarioFim) {
		super();
		this.id = id;
		this.nome = nome;
		this.diaSemana = diaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
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
	
}
