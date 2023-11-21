package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

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
	
	private String alunoSelectedAtt;
	private String atividadeSelectedAtt;
	private String professorSelectedAtt;
	
	private String alunoSelected;
	private String atividadeSelected;
	private String professorSelected;
	private List<SelectItem> professores = new ArrayList<>();
	private List<SelectItem> atividades = new ArrayList<>();
	private List<SelectItem> alunos = new ArrayList<>();
	
	private ManterMatriculaSBean sbean = new ManterMatriculaSBean();
	private ManterAlunoSBean alunoSbean = new ManterAlunoSBean();
	private ManterProfessorSBean professorSbean = new ManterProfessorSBean();
	private ManterAtividadeSBean atividadeSBean = new ManterAtividadeSBean();

	public IU01_cad_matriculaMBean() {
		this.matricula = new TOMatricula();
		this.setMatriculaes(new ArrayList<>());
		listarMatriculaes();
		populaSelect();
	}
	
	private void populaSelect() {
		populaProfessor();
		populaAluno();
		populaAtividade();
	}
	
	private void populaProfessor() {
		List<TOProfessor> profs = professorSbean.listarProfessores();
		for(TOProfessor prof : profs) {
			professores.add(new SelectItem(prof.getId(), prof.getNome()));
		}
	}
	
	private void populaAtividade() {
		List<TOAtividade> lista = atividadeSBean.listarAtividades();
		for(TOAtividade att : lista) {
			atividades.add(new SelectItem(att.getId(), att.getNome() +" "+ att.getHorarioInicio() +" - "+ att.getHorarioFim()));
		}
	}
	
	private void populaAluno() {
		List<TOAluno> lista = alunoSbean.listarAlunos();
		for(TOAluno aluno : lista) {
			alunos.add(new SelectItem(aluno.getId(), aluno.getNome()));
		}
	}
	
	private void listarMatriculaes() {
		this.matriculas = sbean.listarMatriculas();
	}
	
	public void cadastrarMatricula() {
		matricula.setProfessor(professorSbean.getProfessorById(professorSelected));
		matricula.setAluno(alunoSbean.getAlunoById(alunoSelected));
		matricula.setAtividade(atividadeSBean.getAtividadeById(atividadeSelected));
		sbean.cadastrarMatricula(matricula);
		listarMatriculaes();
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedMatricula = (TOMatricula) event.getObject();
	}
	
	public void atualizarMatricula() {
		selectedMatricula.getId();
		selectedMatricula.setProfessor(professorSbean.getProfessorById(professorSelectedAtt));
		selectedMatricula.setAluno(alunoSbean.getAlunoById(alunoSelectedAtt));
		selectedMatricula.setAtividade(atividadeSBean.getAtividadeById(atividadeSelectedAtt));
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

	public ManterMatriculaSBean getSbean() {
		return sbean;
	}

	public void setSbean(ManterMatriculaSBean sbean) {
		this.sbean = sbean;
	}

	public String getAlunoSelected() {
		return alunoSelected;
	}

	public void setAlunoSelected(String alunoSelected) {
		this.alunoSelected = alunoSelected;
	}

	public String getAtividadeSelected() {
		return atividadeSelected;
	}

	public void setAtividadeSelected(String atividadeSelected) {
		this.atividadeSelected = atividadeSelected;
	}

	public String getProfessorSelected() {
		return professorSelected;
	}

	public void setProfessorSelected(String professorSelected) {
		this.professorSelected = professorSelected;
	}

	public List<SelectItem> getProfessores() {
		return professores;
	}

	public void setProfessores(List<SelectItem> professores) {
		this.professores = professores;
	}

	public List<SelectItem> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<SelectItem> atividades) {
		this.atividades = atividades;
	}

	public List<SelectItem> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<SelectItem> alunos) {
		this.alunos = alunos;
	}

	public String getAlunoSelectedAtt() {
		return alunoSelectedAtt;
	}

	public void setAlunoSelectedAtt(String alunoSelectedAtt) {
		this.alunoSelectedAtt = alunoSelectedAtt;
	}

	public String getAtividadeSelectedAtt() {
		return atividadeSelectedAtt;
	}

	public void setAtividadeSelectedAtt(String atividadeSelectedAtt) {
		this.atividadeSelectedAtt = atividadeSelectedAtt;
	}

	public String getProfessorSelectedAtt() {
		return professorSelectedAtt;
	}

	public void setProfessorSelectedAtt(String professorSelectedAtt) {
		this.professorSelectedAtt = professorSelectedAtt;
	}
	
}