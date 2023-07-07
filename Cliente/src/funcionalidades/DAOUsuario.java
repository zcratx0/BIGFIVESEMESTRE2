package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.beans.UsuarioBeanRemote;
import com.bigfive.entities.Usuario;

public class DAOUsuario extends DAO<UsuarioBeanRemote>{
	private static DAOUsuario instance = new DAOUsuario();
	public static DAOUsuario getInstance() {
		return instance;
	}
	
	private DAOUsuario() {
		initilize("ejb:/ProyectoEJB/UsuarioBean!com.bigfive.beans.UsuarioBeanRemote");
	}
	
	public Usuario login(String user, String password) {
		return this.bean.loginUsuario(user, password);
	}
	public int getTipo(Usuario usuario) {
		return this.bean.detectarUsuario(usuario.getIdUsuario());
	}
	public void cargarTiposCBox(Usuario usuario, JComboBox cb) {
		String tipo = this.bean.getTipoDeUsuario(usuario);
		System.out.println(tipo);
		if (tipo != null) {
			for (String i : tipo.split(",")) {
				cb.addItem(i);
			}
		}
	}
}
