package funcionalidades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bigfive.beans.UsuarioBeanRemote;

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
	
	
	public boolean login(String user, String password) {
		
		return false;
	}
}
