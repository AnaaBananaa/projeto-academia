package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import model.transferobject.TOProfessor;
import repository.Repository;
import sessionbean.ManterProfessorSBean;

@ViewScoped
@ManagedBean(name = "professorMBean")
public class IU01_cad_professorMBean {

	private TOProfessor professor;
	private List<TOProfessor> professores;
	private TOProfessor selectedProfessor;
	private ManterProfessorSBean sbean = new ManterProfessorSBean();

	public IU01_cad_professorMBean() throws IOException {
		if(!Repository.getInstance().isEntrou()) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
		}
		this.professor = new TOProfessor();
		this.setProfessores(new ArrayList<>());
		listarProfessores();
	}

	public String getMessage() {
		return "Primeira Tela";
	}
	
	private void listarProfessores() {
		this.professores = sbean.listarProfessores();
	}
	
	public void cadastrarProfessor() {
		sbean.cadastrarProfessor(professor);
		listarProfessores();
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedProfessor = (TOProfessor) event.getObject();
	}
	
	public void atualizarProfessor() {
		sbean.atualizarProfessor(selectedProfessor);
		listarProfessores();
		showInfo();
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Atualização de dados", "Dados salvos com sucesso");
    }

	public TOProfessor getProfessor() {
		return professor;
	}

	public void setProfessor(TOProfessor professor) {
		this.professor = professor;
	}

	public List<TOProfessor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<TOProfessor> professores) {
		this.professores = professores;
	}

	public TOProfessor getSelectedProfessor() {
		return selectedProfessor;
	}

	public void setSelectedProfessor(TOProfessor selectedProfessor) {
		this.selectedProfessor = selectedProfessor;
	}
	
}