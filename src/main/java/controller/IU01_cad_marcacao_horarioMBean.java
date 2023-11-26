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
import model.transferobject.TOMarcacaoHorario;
import sessionbean.ManterAlunoSBean;
import sessionbean.ManterAtividadeSBean;
import sessionbean.ManterMarcacaoHorarioSBean;

@ViewScoped
@ManagedBean(name = "marcacaoHorarioMBean")
public class IU01_cad_marcacao_horarioMBean {

	private TOMarcacaoHorario marcacaoHorario;
	private List<TOMarcacaoHorario> marcacaoHorarios;
	private TOMarcacaoHorario selectedMarcacaoHorario;
	
	private String alunoSelectedAtt;
	private String atividadeSelectedAtt;
	
	private String alunoSelected;
	private String atividadeSelected;
	private List<SelectItem> atividades = new ArrayList<>();
	private List<SelectItem> alunos = new ArrayList<>();
	
	private ManterMarcacaoHorarioSBean sbean = new ManterMarcacaoHorarioSBean();
	private ManterAlunoSBean alunoSbean = new ManterAlunoSBean();
	private ManterAtividadeSBean atividadeSBean = new ManterAtividadeSBean();

	public IU01_cad_marcacao_horarioMBean() {
		this.marcacaoHorario = new TOMarcacaoHorario();
		this.setMarcacaoHorarioes(new ArrayList<>());
		listarMarcacaoHorarioes();
		populaSelect();
	}
	
	private void populaSelect() {
		populaAluno();
		populaAtividade();
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
	
	private void listarMarcacaoHorarioes() {
		this.marcacaoHorarios = sbean.listarMarcacaoHorarios();
	}
	
	public void cadastrarMarcacaoHorario() {
		marcacaoHorario.setAluno(alunoSbean.getAlunoById(alunoSelected));
		marcacaoHorario.setAtividade(atividadeSBean.getAtividadeById(atividadeSelected));
		sbean.cadastrarMarcacaoHorario(marcacaoHorario);
		listarMarcacaoHorarioes();
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedMarcacaoHorario = (TOMarcacaoHorario) event.getObject();
	}
	
	public void atualizarMarcacaoHorario() {
		selectedMarcacaoHorario.getId();
		selectedMarcacaoHorario.setAluno(alunoSbean.getAlunoById(alunoSelectedAtt));
		selectedMarcacaoHorario.setAtividade(atividadeSBean.getAtividadeById(atividadeSelectedAtt));
		sbean.atualizarMarcacaoHorario(selectedMarcacaoHorario);
		listarMarcacaoHorarioes();
		showInfo();
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Atualização de dados", "Dados salvos com sucesso");
    }

	public TOMarcacaoHorario getMarcacaoHorario() {
		return marcacaoHorario;
	}

	public void setMarcacaoHorario(TOMarcacaoHorario marcacaoHorario) {
		this.marcacaoHorario = marcacaoHorario;
	}

	public List<TOMarcacaoHorario> getMarcacaoHorarioes() {
		return marcacaoHorarios;
	}

	public void setMarcacaoHorarioes(List<TOMarcacaoHorario> marcacaoHorarios) {
		this.marcacaoHorarios = marcacaoHorarios;
	}

	public TOMarcacaoHorario getSelectedMarcacaoHorario() {
		return selectedMarcacaoHorario;
	}

	public void setSelectedMarcacaoHorario(TOMarcacaoHorario selectedMarcacaoHorario) {
		this.selectedMarcacaoHorario = selectedMarcacaoHorario;
	}

	public ManterAlunoSBean getAlunoSbean() {
		return alunoSbean;
	}

	public void setAlunoSbean(ManterAlunoSBean alunoSbean) {
		this.alunoSbean = alunoSbean;
	}

	public ManterAtividadeSBean getAtividadeSBean() {
		return atividadeSBean;
	}

	public void setAtividadeSBean(ManterAtividadeSBean atividadeSBean) {
		this.atividadeSBean = atividadeSBean;
	}

	public List<TOMarcacaoHorario> getMarcacaoHorarios() {
		return marcacaoHorarios;
	}

	public void setMarcacaoHorarios(List<TOMarcacaoHorario> marcacaoHorarios) {
		this.marcacaoHorarios = marcacaoHorarios;
	}

	public ManterMarcacaoHorarioSBean getSbean() {
		return sbean;
	}

	public void setSbean(ManterMarcacaoHorarioSBean sbean) {
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

}