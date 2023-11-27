package sessionbean;

import java.util.ArrayList;
import java.util.List;

import model.entity.Produto;
import model.transferobject.TOProduto;
import repository.Repository;

public class ManterProdutoSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	public void cadastrarProduto(TOProduto to) {
		Produto produto = new Produto(getId(), to.getQuantidade(), to.getPreco(), to.getNome());
		repository.addProduto(produto);
		
	}
	
	public List<TOProduto> listarProdutos() {
		List<TOProduto> tos = new ArrayList<>();
		List<Produto> produtos =repository.getProdutos();
		for(Produto prod: produtos) {
			tos.add(new TOProduto(prod.getId(),prod.getQuantidade(), prod.getPreco(), prod.getNome()));
		}
		return tos;
	}
	
	public void atualizarProduto(TOProduto prod) {
		List<Produto> produtos =repository.getProdutos();
		for(Produto u : produtos) {
			if(u.getId().equals(prod.getId())) {
				u.setNome(prod.getNome());
				u.setPreco(prod.getPreco());
				u.setQuantidade(prod.getQuantidade());
			}
		}
	}
	
	public TOProduto getProdutoById(String id) {
		for(TOProduto produto : listarProdutos()) {
			if(produto.getId().equals(id)) {
				return produto;
			}
		}
		return new TOProduto();
	}
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}
	
}
