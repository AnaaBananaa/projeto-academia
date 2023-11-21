package sessionbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.entity.Professor;
import model.entity.Usuario;
import model.transferobject.TOProfessor;
import model.transferobject.TOUsuario;
import repository.Repository;

public class ManterProfessorSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	
	public void cadastrarProfessor(TOProfessor to) {
		Professor professor = new Professor(getId(), to.getNome());
		repository.addProfessores(professor);
		
	}
	
	public List<TOProfessor> listarProfessores() {
		List<TOProfessor> tos = new ArrayList<>();
		List<Professor> professores =repository.getProfessores();
		for(Professor user: professores) {
			tos.add(new TOProfessor(user.getId(), user.getNome()));
		}
		return tos;
	}
	
	public void atualizarProfessor(TOProfessor usuario) {
		List<Professor> usuarios =repository.getProfessores();
		for(Professor u : usuarios) {
			if(u.getId().equals(usuario.getId())) {
				u.setNome(usuario.getNome());
			}
		}
	}
	
	public TOProfessor getProfessorById(String id) {
		for(TOProfessor professor : listarProfessores()) {
			if(professor.getId().equals(id)) {
				return professor;
			}
		}
		return new TOProfessor();
	}
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}
	
}
