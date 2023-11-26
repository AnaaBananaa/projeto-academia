package model.entity;

import java.util.Objects;

import model.transferobject.TOAluno;
import model.transferobject.TOAtividade;

public class MarcacaoHorario {
	
	private String id;
	private TOAtividade atividade;
	private TOAluno aluno;

	public MarcacaoHorario(String id, TOAtividade atividade, TOAluno aluno) {
		super();
		this.id = id;
		this.atividade = atividade;
		this.aluno = aluno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TOAtividade getAtividade() {
		return atividade;
	}
	public void setAtividade(TOAtividade atividade) {
		this.atividade = atividade;
	}
	public TOAluno getAluno() {
		return aluno;
	}
	public void setAluno(TOAluno aluno) {
		this.aluno = aluno;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarcacaoHorario other = (MarcacaoHorario) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(atividade, other.atividade)
				&& Objects.equals(id, other.id);
	}
	
}
