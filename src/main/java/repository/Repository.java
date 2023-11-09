package repository;

import java.util.ArrayList;
import java.util.List;

import model.entity.Professor;
import model.entity.Usuario;

public class Repository {
	
	private static Repository instance;
	
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();
	
	public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
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
	
	
}
