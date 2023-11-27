package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import model.transferobject.TOAluno;
import model.transferobject.TOCompra;
import repository.Repository;
import sessionbean.ManterAlunoSBean;
import sessionbean.ManterCompraSBean;

@ViewScoped
@ManagedBean(name = "mensalidadeMBean")
public class IU01_cad_mensalidadeMBean {

	private String alunoSelected;
	private List<SelectItem> alunos = new ArrayList<>();
	private List<TOCompra> comprasDoAluno = new ArrayList<>();
	private Double somatorio; 
	private ManterCompraSBean sbean = new ManterCompraSBean();
	private ManterAlunoSBean alunoSbean = new ManterAlunoSBean();
	private boolean considerarMensalidade;

	public IU01_cad_mensalidadeMBean()  throws IOException {
		if(!Repository.getInstance().isEntrou()) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
		}
		populaAluno();
		
	}
	
	private void populaAluno() {
		List<TOAluno> lista = alunoSbean.listarAlunos();
		for(TOAluno aluno : lista) {
			alunos.add(new SelectItem(aluno.getId(), aluno.getNome()));
		}
	}
	
	public void resgatarPagamento() {
		somatorio = 0.0;
		setComprasDoAluno(sbean.listarComprasPorAluno(alunoSelected));
		for(TOCompra c : comprasDoAluno) {
			somatorio = somatorio + (c.getProduto().getPreco() * c.getQuantidade());
		}
	}
	
	public boolean alunoRetornado() {
		return alunoSelected == null || alunoSelected.isEmpty();
	}
	
	public void adicionarMensalidade() {
		TOAluno aluno = alunoSbean.getAlunoById(alunoSelected);
		if(considerarMensalidade) {
			somatorio = somatorio + aluno.getValorMensalidade();
		}else {
			somatorio = somatorio - aluno.getValorMensalidade();
		}
	}
	
	public Double soma(int qtd, Double preco) {
		return qtd * preco;
	}
	
	public void finalizarPagamento() {
		TOAluno aluno = alunoSbean.getAlunoById(alunoSelected);
		if(considerarMensalidade) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate data = LocalDate.parse(aluno.getDataVencimento(), formatter);
			data = data.plusMonths(1);
			aluno.setDataVencimento(data.format(formatter));
			alunoSbean.atualizarAluno(aluno);
		}
		for(TOCompra c : comprasDoAluno) {
			sbean.atualizarStatus(c);
		}
		showInfo("Pagamento registrado com sucesso", "O pagamento do aluno "+aluno.getNome()+" foi registrado com sucesso");
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


	public ManterAlunoSBean getAlunoSbean() {
		return alunoSbean;
	}

	public void setAlunoSbean(ManterAlunoSBean alunoSbean) {
		this.alunoSbean = alunoSbean;
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

	public List<TOCompra> getComprasDoAluno() {
		return comprasDoAluno;
	}

	public void setComprasDoAluno(List<TOCompra> comprasDoAluno) {
		this.comprasDoAluno = comprasDoAluno;
	}

	public Double getSomatorio() {
		return somatorio;
	}

	public void setSomatorio(Double somatorio) {
		this.somatorio = somatorio;
	}

	public boolean isConsiderarMensalidade() {
		return considerarMensalidade;
	}

	public void setConsiderarMensalidade(boolean considerarMensalidade) {
		this.considerarMensalidade = considerarMensalidade;
	}

}