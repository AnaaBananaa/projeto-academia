package sessionbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.entity.Usuario;
import model.transferobject.TOUsuario;
import repository.Repository;

public class ManterUsuarioSBean {
	
	private Repository repository = Repository.getInstance();
	private static int id = 1;
	
	
	public void cadastrarUsuario(TOUsuario to) {
		Usuario usuario = new Usuario(getId(),to.getNome(), to.getSenha());
		repository.addUsuarios(usuario);
		
	}
	
	public List<TOUsuario> listarUsuarios() {
		List<TOUsuario> tos = new ArrayList<>();
		List<Usuario> usuarios =repository.getUsuarios();
		for(Usuario user: usuarios) {
			tos.add(new TOUsuario(user.getId(), user.getNome(), user.getSenha()));
		}
		return tos;
	}
	
	public void atualizarUsuario(TOUsuario usuario) {
		List<Usuario> usuarios =repository.getUsuarios();
		for(Usuario u : usuarios) {
			if(u.getId().equals(usuario.getId())) {
				u.setNome(usuario.getNome());
				u.setSenha(usuario.getSenha());
			}
		}
	}
	
	public boolean encontrarUsuario(String nome, String senha) {
		List<Usuario> usuarios =repository.getUsuarios();
		for(Usuario u : usuarios) {
			if(u.getNome().equals(nome) && u.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}
	
}
