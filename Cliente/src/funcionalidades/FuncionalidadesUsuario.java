package funcionalidades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bigfive.beans.UsuarioBeanRemote;
import com.bigfive.entities.Usuario;

public class FuncionalidadesUsuario {
	private static FuncionalidadesUsuario instance = new FuncionalidadesUsuario();
	private UsuarioBeanRemote userBean;
	public static FuncionalidadesUsuario getInstance() {
		return instance;
	}
	
	private FuncionalidadesUsuario() {
		try {
			setUserBean((UsuarioBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/UsuarioBean!com.bigfive.beans.UsuarioBeanRemote"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public UsuarioBeanRemote getUserBean() {
		return userBean;
		
	}

	public void setUserBean(UsuarioBeanRemote userBean) {
		this.userBean = userBean;
	}
	
	
	public Usuario login(String user, String password) {
		return userBean.loginUsuario(user, password);
	}
	public int getTipo(Usuario usuario) {
		return userBean.detectarUsuario(usuario.getIdUsuario());
	}
}
