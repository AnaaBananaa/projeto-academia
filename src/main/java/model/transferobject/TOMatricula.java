package model.transferobject;

public class TOMatricula {
	
	private String id;
	private TOAtividade atividade;
	private TOAluno aluno;
	private TOProfessor professor;
	
	public TOMatricula() {
		super();
	}
	public TOMatricula(String id, TOAtividade atividade, TOAluno aluno, TOProfessor professor) {
		super();
		this.id = id;
		this.atividade = atividade;
		this.aluno = aluno;
		this.professor = professor;
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
	public TOProfessor getProfessor() {
		return professor;
	}
	public void setProfessor(TOProfessor professor) {
		this.professor = professor;
	}
	
	

}
