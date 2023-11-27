package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import model.transferobject.TOProduto;
import sessionbean.ManterProdutoSBean;

@ViewScoped
@ManagedBean(name = "produtoMBean")
public class IU01_cad_produtoMBean {

	private TOProduto produto;
	private List<TOProduto> produtos;
	private TOProduto selectedProduto;
	private ManterProdutoSBean sbean = new ManterProdutoSBean();

	public IU01_cad_produtoMBean() {
		this.produto = new TOProduto();
		this.setProdutos(new ArrayList<>());
		listarProdutos();
	}

	public String getMessage() {
		return "Primeira Tela";
	}
	
	private void listarProdutos() {
		this.produtos = sbean.listarProdutos();
	}
	
	public void cadastrarProduto() {
		boolean hasEquals = false;
		for(TOProduto p : produtos) {
			if(p.getNome().equals(produto.getNome())) {
				hasEquals = true;
			}
		}
		if(hasEquals) {
			showError("Cadastro não efetuado", "Já existe um produto com este nome");
		}else {
			sbean.cadastrarProduto(produto);
			listarProdutos();
		}
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedProduto = (TOProduto) event.getObject();
	}
	
	public void atualizarProduto() {
		sbean.atualizarProduto(selectedProduto);
		listarProdutos();
		showInfo();
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Atualização de dados", "Dados salvos com sucesso");
    }
    
    public void showError(String title, String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, title, message);
    }

	public TOProduto getProduto() {
		return produto;
	}

	public void setProduto(TOProduto produto) {
		this.produto = produto;
	}

	public List<TOProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<TOProduto> produtos) {
		this.produtos = produtos;
	}

	public TOProduto getSelectedProduto() {
		return selectedProduto;
	}

	public void setSelectedProduto(TOProduto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}
	
}