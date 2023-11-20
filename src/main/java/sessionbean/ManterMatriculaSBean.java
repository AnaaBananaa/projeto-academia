package sessionbean;

import java.util.ArrayList;
import java.util.List;

import model.entity.Matricula;
import model.transferobject.TOMatricula;
import repository.Repository;

public class ManterMatriculaSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	public void cadastrarMatricula(TOMatricula to) {
		Matricula matricula = new Matricula(getId(), to.getAtividade(), to.getAluno(), to.getProfessor());
		repository.addMatriculas(matricula);
		
	}
	
	public List<TOMatricula> listarMatriculas() {
		List<TOMatricula> tos = new ArrayList<>();
		List<Matricula> matriculas =repository.getMatriculas();
		for(Matricula user: matriculas) {
			tos.add(new TOMatricula(user.getId(), user.getAtividade(), user.getAluno(), user.getProfessor()));
		}
		return tos;
	}
	
	public void atualizarMatricula(TOMatricula matricula) {
		List<Matricula> matriculas =repository.getMatriculas();
		for(Matricula u : matriculas) {
			if(u.getId().equals(matricula.getId())) {
				u.setAluno(matricula.getAluno());
				u.setAtividade(matricula.getAtividade());
				u.setProfessor(matricula.getProfessor());
			}
		}
	}
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}
	
}
