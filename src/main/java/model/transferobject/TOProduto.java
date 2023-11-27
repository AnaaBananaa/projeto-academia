package model.transferobject;

public class TOProduto {
	
	private String id;
	private int quantidade;
	private Double preco;
	private String nome;
	public TOProduto() {
		super();
	}
	public TOProduto(String id, int quantidade, Double preco, String nome) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
