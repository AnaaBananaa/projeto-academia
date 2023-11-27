package model.transferobject;

public class TOCompra {
	
	private String id;
	private TOProduto produto;
	private TOAluno aluno;
	private int quantidade;
	private String dataCompra;
	private boolean pago;

	public TOCompra() {
		super();
	}
	public TOCompra(String id, TOProduto produto, TOAluno aluno, int quantidade, String dataCompra, boolean pago) {
		super();
		this.id = id;
		this.produto = produto;
		this.aluno = aluno;
		this.quantidade = quantidade;
		this.dataCompra = dataCompra;
		this.pago = pago;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TOProduto getProduto() {
		return produto;
	}
	public void setProduto(TOProduto produto) {
		this.produto = produto;
	}
	public TOAluno getAluno() {
		return aluno;
	}
	public void setAluno(TOAluno aluno) {
		this.aluno = aluno;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
}
