package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import model.transferobject.TOUsuario;
import sessionbean.ManterUsuarioSBean;

@ViewScoped
@ManagedBean(name = "home")
public class IU01_cad_usuarioMBean {

	private TOUsuario usuario;
	private List<TOUsuario> usuarios;
	private TOUsuario selectedUsuario;
	private ManterUsuarioSBean sbean = new ManterUsuarioSBean();

	public IU01_cad_usuarioMBean() {
		this.usuario = new TOUsuario();
		this.setUsuarios(new ArrayList<>());
		listarUsuarios();
	}

	public String getMessage() {
		return "Primeira Tela";
	}
	
	private void listarUsuarios() {
		this.usuarios = sbean.listarUsuarios();
	}
	
	public void cadastrarUsuario() {
		sbean.cadastrarUsuario(usuario);
		listarUsuarios();
	}
	
	public void onRowSelect(SelectEvent<?> event){
		selectedUsuario = (TOUsuario) event.getObject();
	}
	
	public void atualizarUsuario() {
		sbean.atualizarUsuario(selectedUsuario);
		listarUsuarios();
		showInfo();
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Atualização de dados", "Dados salvos com sucesso");
    }
	
	public TOUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(TOUsuario usuario) {
		this.usuario = usuario;
	}

	public List<TOUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<TOUsuario> usuarios) {
		this.usuarios = usuarios;
	}

	public TOUsuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(TOUsuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

}