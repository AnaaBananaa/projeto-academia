package model.entity;

public class Professor {
	String id;
	String nome;
	
	public Professor(String nome) {
		super();
		this.nome = nome;
	}
	
	public Professor(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
