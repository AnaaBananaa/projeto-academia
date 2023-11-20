package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import enums.EnumDiaSemana;
import enums.EnumHorario;
import model.transferobject.TOAtividade;
import sessionbean.ManterAtividadeSBean;

@ViewScoped
@ManagedBean(name = "atividadeMBean")
public class IU01_cad_atividadeMBean {

	private TOAtividade atividade;
	private List<TOAtividade> atividades;
	private TOAtividade selectedAtividade;
	private List<String> diasSemana = new ArrayList<>();
	private List<String> horarios = new ArrayList<>();
	private ManterAtividadeSBean sbean = new ManterAtividadeSBean();

	public IU01_cad_atividadeMBean() {
		List<EnumDiaSemana> semanas = Arrays.asList(EnumDiaSemana.values());
		for(EnumDiaSemana e : semanas) {
			this.diasSemana.add(e.getDiaSemana());
		}
		List<EnumHorario> horario = Arrays.asList(EnumHorario.values());
		for(EnumHorario e : horario) {
			this.horarios.add(e.getHorario());
		}
		this.atividade = new TOAtividade();
		this.setAtividades(new ArrayList<>());
		listarAtividades();
	}

	public String getMessage() {
		return "Primeira Tela";
	}
	
	private void listarAtividades() {
		this.atividades = sbean.listarAtividades();
	}
	
	public void cadastrarAtividade() {
		sbean.cadastrarAtividade(atividade);
		listarAtividades();
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedAtividade = (TOAtividade) event.getObject();
	}
	
	public void atualizarAtividade() {
		sbean.atualizarAtividade(selectedAtividade);
		listarAtividades();
		showInfo();
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Atualização de dados", "Dados salvos com sucesso");
    }

	public TOAtividade getAtividade() {
		return atividade;
	}

	public void setAtividade(TOAtividade atividade) {
		this.atividade = atividade;
	}

	public List<TOAtividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<TOAtividade> atividades) {
		this.atividades = atividades;
	}

	public TOAtividade getSelectedAtividade() {
		return selectedAtividade;
	}

	public void setSelectedAtividade(TOAtividade selectedAtividade) {
		this.selectedAtividade = selectedAtividade;
	}

	public List<String> getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(List<String> diasSemana) {
		this.diasSemana = diasSemana;
	}

	public List<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}
	
}