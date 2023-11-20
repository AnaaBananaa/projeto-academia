package repository;

import java.util.ArrayList;
import java.util.List;

import model.entity.Aluno;
import model.entity.Atividade;
import model.entity.Matricula;
import model.entity.Professor;
import model.entity.Usuario;

public class Repository {
	
	private static Repository instance;
	
	private List<Aluno> alunos = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();
	private List<Atividade> atividades = new ArrayList<>();
	private List<Matricula> matriculas = new ArrayList<>();
	
	public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void addAlunos(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void addUsuarios(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void addProfessores(Professor professor) {
		this.professores.add(professor);
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void addAtividades(Atividade atividade) {
		this.atividades.add(atividade);
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void addMatriculas(Matricula matriculas) {
		this.matriculas.add(matriculas);
	}
	
	
}
