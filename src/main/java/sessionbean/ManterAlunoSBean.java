package sessionbean;

import java.util.ArrayList;
import java.util.List;

import model.entity.Aluno;
import model.transferobject.TOAluno;
import repository.Repository;

public class ManterAlunoSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	
	public void cadastrarAluno(TOAluno user) {
		Aluno aluno = new Aluno(getId(), user.getNome(), user.getDataNascimento(), user.getAtivo(), user.getCelular(), user.getEmail(), user.getCidade(), user.getCEP(), user.getRua(), user.getNumero(), user.getBairro(), user.getEstado(), user.getGenero());
		repository.addAlunos(aluno);
		
	}
	
	public List<TOAluno> listarAlunos() {
		List<TOAluno> tos = new ArrayList<>();
		List<Aluno> alunos =repository.getAlunos();
		for(Aluno user: alunos) {
			tos.add(new TOAluno(user.getId(), user.getNomeAluno(), user.getDataNascimento(), user.getAtivo(), user.getCelular(), user.getEmail(), user.getCidade(), user.getCEP(), user.getRua(), user.getNumero(), user.getBairro(), user.getEstado(), user.getGenero()));
		}
		
		return tos;
	}
	
	public void atualizarAluno(TOAluno aluno) {
		List<Aluno> alunos =repository.getAlunos();
		for(Aluno u : alunos) {
			if(u.getId().equals(aluno.getId())) {
				u.setNomeAluno(aluno.getNome());
				u.setDataNascimento(aluno.getDataNascimento());
				u.setAtivo(aluno.getAtivo());
				u.setCelular(aluno.getCelular());
				u.setEmail(aluno.getEmail());
				u.setCidade(aluno.getCidade());
				u.setCEP(aluno.getCEP());
				u.setRua(aluno.getRua());
				u.setNumero(aluno.getNumero());
				u.setBairro(aluno.getBairro());
			}
		}
	}
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}

}
