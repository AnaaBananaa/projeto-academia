package sessionbean;

import java.util.ArrayList;
import java.util.List;

import model.entity.Compra;
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
	
	private String getId() {
		id = id+1;
		return "C"+id;
	}
	
}
