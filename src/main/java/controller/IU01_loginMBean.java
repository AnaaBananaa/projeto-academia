package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.transferobject.TOUsuario;
import repository.Repository;
import sessionbean.ManterUsuarioSBean;

@ViewScoped
@ManagedBean(name = "loginMBean")
public class IU01_loginMBean {
	public boolean entrou;
	TOUsuario usuario = new TOUsuario();
	private ManterUsuarioSBean sbean = new ManterUsuarioSBean();
	private Repository repository = Repository.getInstance();

	public IU01_loginMBean() {
		repository.setEntrou(false);
		sbean.cadastrarUsuario(new TOUsuario("admin", "admin"));
	}
	
	public void entrar() throws IOException {
		if(sbean.encontrarUsuario(usuario.getNome(), usuario.getSenha())) {
			repository.setEntrou(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("iu01_cad_aluno.jsf");
		}else {
			showError("CREDENCIAIS INVÁLIDAS", "Usuário ou senha inválidos");
		}
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

	public TOUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(TOUsuario usuario) {
		this.usuario = usuario;
	}

}