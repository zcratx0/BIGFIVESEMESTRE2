package funcionalidades;

import com.bigfive.beans.UsuarioBeanRemote;
import com.bigfive.entities.Usuario;

public class DAOUsuario extends DAO<UsuarioBeanRemote>{
	private static DAOUsuario instance = new DAOUsuario();
	public static DAOUsuario getInstance() {
		return instance;
	}
	
	private DAOUsuario() {
		initialize("ejb:/ProyectoEJB/UsuarioBean!com.bigfive.beans.UsuarioBeanRemote");
	}
	
	public Usuario login(String user, String password) {
		return this.getBean().loginUsuario(user, password);
	}
	public int getTipo(Usuario usuario) {
		return this.getBean().detectarUsuario(usuario.getIdUsuario());
	}
}
