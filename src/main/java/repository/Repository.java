package repository;

import java.util.ArrayList;
import java.util.List;

import model.entity.Aluno;
import model.entity.Atividade;
import model.entity.Compra;
import model.entity.MarcacaoHorario;
import model.entity.Produto;
import model.entity.Professor;
import model.entity.Usuario;

public class Repository {
	
	private static Repository instance;
	
	private List<Aluno> alunos = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();
	private List<Atividade> atividades = new ArrayList<>();
	private List<MarcacaoHorario> marcacaoHorarios = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>();
	private List<Compra> compras = new ArrayList<>();
	private boolean entrou;
	
	public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void addAlunos(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void addUsuarios(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void addProfessores(Professor professor) {
		this.professores.add(professor);
	}
	
	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void addAtividades(Atividade atividade) {
		this.atividades.add(atividade);
	}

	public List<MarcacaoHorario> getMarcacaoHorarios() {
		return marcacaoHorarios;
	}

	public void addMarcacaoHorarios(MarcacaoHorario marcacaoHorarios) {
		this.marcacaoHorarios.add(marcacaoHorarios);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}

	public List<Compra> getCompras() {
		return compras;
	}
	
	public void addCompra(Compra compra) {
		this.compras.add(compra);
	}

	public boolean isEntrou() {
		return entrou;
	}

	public void setEntrou(boolean entrou) {
		this.entrou = entrou;
	}
	
}
