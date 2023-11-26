package model.transferobject;

import java.util.Objects;

public class TOAtividade {
	private String id;
	private String nome;
	private String diaSemana;
	private String horarioInicio;
	private String horarioFim;
	private Double valorAcrescido;
	private TOProfessor professor;

	public TOAtividade() {
		super();
		this.valorAcrescido = 0.00;
	}

	public TOAtividade(String nome) {
		super();
		this.nome = nome;
	}
	
	public TOAtividade(String id, String nome, String diaSemana, String horarioInicio, String horarioFim, Double valorAcrescido, TOProfessor professor) {
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

	@Override
	public String toString() {
		return nome + ", " + horarioInicio + " - " + horarioFim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaSemana, horarioFim, horarioInicio, id, nome, valorAcrescido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TOAtividade other = (TOAtividade) obj;
		return Objects.equals(diaSemana, other.diaSemana) && Objects.equals(horarioFim, other.horarioFim)
				&& Objects.equals(horarioInicio, other.horarioInicio) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(valorAcrescido, other.valorAcrescido);
	}

	public TOProfessor getProfessor() {
		return professor;
	}

	public void setProfessor(TOProfessor professor) {
		this.professor = professor;
	}

}
