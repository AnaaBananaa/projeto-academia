package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import model.transferobject.TOAluno;
import model.transferobject.TOAtividade;
import model.transferobject.TOMatricula;
import model.transferobject.TOProfessor;
import sessionbean.ManterAlunoSBean;
import sessionbean.ManterAtividadeSBean;
import sessionbean.ManterMatriculaSBean;
import sessionbean.ManterProfessorSBean;

@ViewScoped
@ManagedBean(name = "matriculaMBean")
public class IU01_cad_matriculaMBean {

	private TOMatricula matricula;
	private List<TOMatricula> matriculas;
	private TOMatricula selectedMatricula;
	private List<TOAluno> alunos;
	private List<TOProfessor> professores;
	private List<TOAtividade> atividades;
	private ManterMatriculaSBean sbean = new ManterMatriculaSBean();
	private ManterAlunoSBean alunoSbean = new ManterAlunoSBean();
	private ManterProfessorSBean professorSbean = new ManterProfessorSBean();
	private ManterAtividadeSBean atividadeSBean = new ManterAtividadeSBean();

	public IU01_cad_matriculaMBean() {
		alunos = alunoSbean.listarAlunos();
		professores = professorSbean.listarProfessores();
		atividades = atividadeSBean.listarAtividades();
		this.matricula = new TOMatricula();
		this.setMatriculaes(new ArrayList<>());
		listarMatriculaes();
	}

	public String getMessage() {
		return "Primeira Tela";
	}
	
	private void listarMatriculaes() {
		this.matriculas = sbean.listarMatriculas();
	}
	
	public void cadastrarMatricula() {
		sbean.cadastrarMatricula(matricula);
		listarMatriculaes();
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedMatricula = (TOMatricula) event.getObject();
	}
	
	public void atualizarMatricula() {
		sbean.atualizarMatricula(selectedMatricula);
		listarMatriculaes();
		showInfo();
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Atualização de dados", "Dados salvos com sucesso");
    }

	public TOMatricula getMatricula() {
		return matricula;
	}

	public void setMatricula(TOMatricula matricula) {
		this.matricula = matricula;
	}

	public List<TOMatricula> getMatriculaes() {
		return matriculas;
	}

	public void setMatriculaes(List<TOMatricula> matriculas) {
		this.matriculas = matriculas;
	}

	public TOMatricula getSelectedMatricula() {
		return selectedMatricula;
	}

	public void setSelectedMatricula(TOMatricula selectedMatricula) {
		this.selectedMatricula = selectedMatricula;
	}

	public ManterAlunoSBean getAlunoSbean() {
		return alunoSbean;
	}

	public void setAlunoSbean(ManterAlunoSBean alunoSbean) {
		this.alunoSbean = alunoSbean;
	}

	public ManterProfessorSBean getProfessorSbean() {
		return professorSbean;
	}

	public void setProfessorSbean(ManterProfessorSBean professorSbean) {
		this.professorSbean = professorSbean;
	}

	public ManterAtividadeSBean getAtividadeSBean() {
		return atividadeSBean;
	}

	public void setAtividadeSBean(ManterAtividadeSBean atividadeSBean) {
		this.atividadeSBean = atividadeSBean;
	}

	public List<TOMatricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<TOMatricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<TOAluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<TOAluno> alunos) {
		this.alunos = alunos;
	}

	public List<TOProfessor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<TOProfessor> professores) {
		this.professores = professores;
	}

	public List<TOAtividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<TOAtividade> atividades) {
		this.atividades = atividades;
	}
	
}