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
	
	private String getId() {
		id = id+1;
		return "A"+id;
	}
	
}
