package sessionbean;

import java.util.ArrayList;
import java.util.List;

import model.entity.Aluno;
import model.entity.Compra;
import model.transferobject.TOAluno;
import model.transferobject.TOCompra;
import repository.Repository;

public class ManterCompraSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	public void cadastrarCompra(TOCompra to) {
		Compra compra = new Compra(getId(), to.getProduto(), to.getAluno(), to.getQuantidade(), to.getDataCompra(), to.isPago());
		repository.addCompra(compra);
		
	}
	
	public List<TOCompra> listarCompras() {
		List<TOCompra> tos = new ArrayList<>();
		List<Compra> compras =repository.getCompras();
		for(Compra user: compras) {
			tos.add(new TOCompra(user.getId(), user.getProduto(), user.getAluno(), user.getQuantidade(), user.getDataCompra(), user.isPago()));
		}
		return tos;
	}
	
	public List<TOCompra> listarComprasPorAluno(String idAluno) {
		List<TOCompra> tos = new ArrayList<>();
		List<Compra> compras =repository.getCompras();
		for(Compra user: compras) {
			if(user.getAluno().getId().equals(idAluno) && !user.isPago()) {
				tos.add(new TOCompra(user.getId(), user.getProduto(), user.getAluno(), user.getQuantidade(), user.getDataCompra(), user.isPago()));
			}
		}
		return tos;
	}
	
	public void atualizarStatus(TOCompra compra) {
		List<Compra> compras = repository.getCompras();
		for(Compra u : compras) {
			if(u.getId().equals(compra.getId())) {
				u.setPago(true);
			}
		}
	}
	
	private String getId() {
		id = id+1;
		return "C"+id;
	}
	
}
