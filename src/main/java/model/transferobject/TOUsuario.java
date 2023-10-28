package model.transferobject;

public class TOUsuario {
	
	private String id;
	private String nome;
	private String senha;
	
	public TOUsuario() {
		super();
	}
	public TOUsuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	public TOUsuario(String id, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}