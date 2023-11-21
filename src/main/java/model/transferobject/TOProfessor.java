package model.transferobject;

import java.util.Objects;

public class TOProfessor {
	String id;
	String nome;
	
	public TOProfessor() {
		super();
	}

	public TOProfessor(String nome) {
		super();
		this.nome = nome;
	}
	
	public TOProfessor(String id, String nome) {
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

	@Override
	public String toString() {
		return  nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TOProfessor other = (TOProfessor) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
}
