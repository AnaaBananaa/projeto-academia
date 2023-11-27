package model.entity;

import java.util.Objects;

import model.transferobject.TOAluno;
import model.transferobject.TOAtividade;
import model.transferobject.TOProduto;

public class Compra {
	
	private String id;
	private TOProduto produto;
	private TOAluno aluno;
	private int quantidade;
	private String dataCompra;
	private boolean pago;

	public Compra() {
		super();
	}
	public Compra(String id, TOProduto produto, TOAluno aluno, int quantidade, String dataCompra, boolean pago) {
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(aluno, other.aluno)
				&& Objects.equals(id, other.id);
	}
	
}
