package model.transferobject;

import java.util.Objects;

public class TOMarcacaoHorario {
	
	private String id;
	private TOAtividade atividade;
	private TOAluno aluno;
	
	public TOMarcacaoHorario() {
		super();
	}
	
	public TOMarcacaoHorario(String id, TOAtividade atividade, TOAluno aluno) {
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
	public int hashCode() {
		return Objects.hash(aluno, atividade, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TOMarcacaoHorario other = (TOMarcacaoHorario) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(atividade, other.atividade)
				&& Objects.equals(id, other.id);
	}
	
}
