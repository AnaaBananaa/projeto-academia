package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import model.transferobject.TOAluno;
import model.transferobject.TOCompra;
import model.transferobject.TOProduto;
import repository.Repository;
import sessionbean.ManterAlunoSBean;
import sessionbean.ManterCompraSBean;
import sessionbean.ManterProdutoSBean;

@ViewScoped
@ManagedBean(name = "compraMBean")
public class IU01_cad_compraMBean {

	private TOCompra compra;
	private List<TOCompra> compras;
	private TOCompra selectedCompra;
	
	private String alunoSelected;
	private String produtoSelected;
	private List<SelectItem> produtos = new ArrayList<>();
	private List<SelectItem> alunos = new ArrayList<>();
	
	private ManterCompraSBean sbean = new ManterCompraSBean();
	private ManterAlunoSBean alunoSbean = new ManterAlunoSBean();
	private ManterProdutoSBean produtoSBean = new ManterProdutoSBean();

	public IU01_cad_compraMBean()  throws IOException {
		if(!Repository.getInstance().isEntrou()) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
		}
		this.compra = new TOCompra();
		this.setCompraes(new ArrayList<>());
		listarCompras();
		populaSelect();
	}
	
	private void populaSelect() {
		populaAluno();
		populaAtividade();
	}
	
	private void populaAtividade() {
		List<TOProduto> lista = produtoSBean.listarProdutos();
		for(TOProduto att : lista) {
			produtos.add(new SelectItem(att.getId(), att.getNome() +" - R$"+ att.getPreco()));
		}
	}
	
	private void populaAluno() {
		List<TOAluno> lista = alunoSbean.listarAlunos();
		for(TOAluno aluno : lista) {
			alunos.add(new SelectItem(aluno.getId(), aluno.getNome()));
		}
	}
	
	private void listarCompras() {
		this.compras = sbean.listarCompras();
	}
	
	public void cadastrarCompra() {
		TOAluno aluno = alunoSbean.getAlunoById(alunoSelected);
		TOProduto produto = produtoSBean.getProdutoById(produtoSelected);
		if (produto.getQuantidade() < compra.getQuantidade()) {
			showError("Cadastro não realizado", "Quantidade de produto insuficiente.");
		} else {
			compra.setAluno(aluno);
			compra.setProduto(produto);
			sbean.cadastrarCompra(compra);
			produto.setQuantidade(produto.getQuantidade() - compra.getQuantidade());
			produtoSBean.atualizarProduto(produto);
			listarCompras();
			showInfo("Cadastro realizado", "Compra efetuada com sucesso");
		}
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo(String title, String message) {
        addMessage(FacesMessage.SEVERITY_INFO, title, message);
    }
    
    public void showError(String title, String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, title, message);
    }

	public TOCompra getCompra() {
		return compra;
	}

	public void setCompra(TOCompra compra) {
		this.compra = compra;
	}

	public List<TOCompra> getCompraes() {
		return compras;
	}

	public void setCompraes(List<TOCompra> compras) {
		this.compras = compras;
	}

	public TOCompra getSelectedCompra() {
		return selectedCompra;
	}

	public void setSelectedCompra(TOCompra selectedCompra) {
		this.selectedCompra = selectedCompra;
	}

	public ManterAlunoSBean getAlunoSbean() {
		return alunoSbean;
	}

	public void setAlunoSbean(ManterAlunoSBean alunoSbean) {
		this.alunoSbean = alunoSbean;
	}

	public List<TOCompra> getCompras() {
		return compras;
	}

	public void setCompras(List<TOCompra> compras) {
		this.compras = compras;
	}

	public ManterCompraSBean getSbean() {
		return sbean;
	}

	public void setSbean(ManterCompraSBean sbean) {
		this.sbean = sbean;
	}

	public String getAlunoSelected() {
		return alunoSelected;
	}

	public void setAlunoSelected(String alunoSelected) {
		this.alunoSelected = alunoSelected;
	}

	public List<SelectItem> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<SelectItem> alunos) {
		this.alunos = alunos;
	}

	public List<SelectItem> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<SelectItem> produtos) {
		this.produtos = produtos;
	}

	public String getProdutoSelected() {
		return produtoSelected;
	}

	public void setProdutoSelected(String produtoSelected) {
		this.produtoSelected = produtoSelected;
	}
	
}