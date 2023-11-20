package sessionbean;

import java.util.ArrayList;
import java.util.List;

import model.entity.Atividade;
import model.transferobject.TOAtividade;
import repository.Repository;

public class ManterAtividadeSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	
	public void cadastrarAtividade(TOAtividade to) {
		Atividade atividade = new Atividade(getId(), to.getNome(), to.getDiaSemana(),  to.getHorarioInicio(), to.getHorarioFim());
		repository.addAtividades(atividade);
		
	}
	
	public List<TOAtividade> listarAtividades() {
		List<TOAtividade> tos = new ArrayList<>();
		List<Atividade> atividades =repository.getAtividades();
		for(Atividade user: atividades) {
			tos.add(new TOAtividade(user.getId(), user.getNome(), user.getDiaSemana(),user.getHorarioInicio(), user.getHorarioFim()));
		}
		return tos;
	}
	
	public void atualizarAtividade(TOAtividade usuario) {
		List<Atividade> atividade =repository.getAtividades();
		for(Atividade u : atividade) {
			if(u.getId().equals(usuario.getId())) {
				u.setNome(usuario.getNome());
			}
		}
	}
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}
	
}