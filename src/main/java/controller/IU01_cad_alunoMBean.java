package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import enums.EnumEstados;
import enums.EnumGenero;
import model.transferobject.TOAluno;
import sessionbean.ManterAlunoSBean;

@ViewScoped
@ManagedBean(name = "alunoMBean")
public class IU01_cad_alunoMBean {

	private TOAluno aluno;
	private List<TOAluno> alunos;
	private TOAluno selectedAluno;
	private ManterAlunoSBean sbean = new ManterAlunoSBean();
	private List<EnumGenero> generos = new ArrayList<>();
	private List<EnumEstados> ufs = new ArrayList<>();

	public IU01_cad_alunoMBean() {
		this.aluno = new TOAluno();
		this.setAlunos(new ArrayList<>());
		this.setGeneros(Arrays.asList(EnumGenero.values()));
		this.setUfs(Arrays.asList(EnumEstados.values()));
		listarAlunos();
	}

	public String getMessage() {
		return "Primeira Tela";
	}
	
	private void listarAlunos() {
		this.alunos = sbean.listarAlunos();
	}
	
	public void cadastrarAluno() throws ParseException {
		sbean.cadastrarAluno(aluno);
		listarAlunos();
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedAluno = (TOAluno) event.getObject();
	}
	
	public void atualizarAluno() {
		sbean.atualizarAluno(selectedAluno);
		listarAlunos();
		showInfo();
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Atualização de dados", "Dados salvos com sucesso");
    }
	
	public TOAluno getAluno() {
		return aluno;
	}

	public void setAluno(TOAluno aluno) {
		this.aluno = aluno;
	}

	public List<TOAluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<TOAluno> alunos) {
		this.alunos = alunos;
	}

	public TOAluno getSelectedAluno() {
		return selectedAluno;
	}

	public void setSelectedAluno(TOAluno selectedAluno) {
		this.selectedAluno = selectedAluno;
	}

	public List<EnumGenero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<EnumGenero> generos) {
		this.generos = generos;
	}

	public List<EnumEstados> getUfs() {
		return ufs;
	}

	public void setUfs(List<EnumEstados> ufs) {
		this.ufs = ufs;
	}
	
}