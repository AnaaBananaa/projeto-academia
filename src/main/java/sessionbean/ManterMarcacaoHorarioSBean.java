package sessionbean;

import java.util.ArrayList;
import java.util.List;

import model.entity.MarcacaoHorario;
import model.transferobject.TOMarcacaoHorario;
import repository.Repository;

public class ManterMarcacaoHorarioSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	public void cadastrarMarcacaoHorario(TOMarcacaoHorario to) {
		MarcacaoHorario marcacaoHorario = new MarcacaoHorario(getId(), to.getAtividade(), to.getAluno());
		repository.addMarcacaoHorarios(marcacaoHorario);
		
	}
	
	public List<TOMarcacaoHorario> listarMarcacaoHorarios() {
		List<TOMarcacaoHorario> tos = new ArrayList<>();
		List<MarcacaoHorario> marcacaoHorarios =repository.getMarcacaoHorarios();
		for(MarcacaoHorario user: marcacaoHorarios) {
			tos.add(new TOMarcacaoHorario(user.getId(), user.getAtividade(), user.getAluno()));
		}
		return tos;
	}
	
	public void atualizarMarcacaoHorario(TOMarcacaoHorario marcacaoHorario) {
		List<MarcacaoHorario> marcacaoHorarios =repository.getMarcacaoHorarios();
		for(MarcacaoHorario u : marcacaoHorarios) {
			if(u.getId().equals(marcacaoHorario.getId())) {
				u.setAluno(marcacaoHorario.getAluno());
				u.setAtividade(marcacaoHorario.getAtividade());
			}
		}
	}
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}
	
}
