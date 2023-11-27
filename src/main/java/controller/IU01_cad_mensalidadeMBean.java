package controller;

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
import sessionbean.ManterAlunoSBean;
import sessionbean.ManterCompraSBean;

@ViewScoped
@ManagedBean(name = "mensalidadeMBean")
public class IU01_cad_mensalidadeMBean {

	private String alunoSelected;
	private List<SelectItem> alunos = new ArrayList<>();
	
	private ManterCompraSBean sbean = new ManterCompraSBean();
	private ManterAlunoSBean alunoSbean = new ManterAlunoSBean();

	public IU01_cad_mensalidadeMBean() {
		populaAluno();
	}
	
	private void populaAluno() {
		List<TOAluno> lista = alunoSbean.listarAlunos();
		for(TOAluno aluno : lista) {
			alunos.add(new SelectItem(aluno.getId(), aluno.getNome()));
		}
	}
	
	public void finalizarPagamento() {
		TOAluno aluno = alunoSbean.getAlunoById(alunoSelected);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(aluno.getDataVencimento(), formatter);
		data = data.plusMonths(1);
		aluno.setDataVencimento(data.format(formatter));
		alunoSbean.atualizarAluno(aluno);
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

}