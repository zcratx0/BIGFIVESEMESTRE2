package funcionalidades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bigfive.beans.AnalistaBeanRemote;
import com.bigfive.beans.AnalistaBeanRemoteRemote;
import com.bigfive.beans.UsuarioBeanRemote;

public class FuncionalidadesAnalista {
	private static FuncionalidadesAnalista instance = new FuncionalidadesAnalista();
	private AnalistaBeanRemoteRemote bean;
	public static FuncionalidadesAnalista getInstance() {
		return instance;
	}
	
	private FuncionalidadesAnalista() {
		try {
			setBean((AnalistaBeanRemoteRemote) InitialContext.doLookup("ejb:/ProyectoEJB/AnalistaBeanRemote!com.bigfive.beans.AnalistaBeanRemoteRemote"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public AnalistaBeanRemoteRemote getBean() {
		return bean;
		
	}

	public void setBean(AnalistaBeanRemoteRemote analistaBeanRemoteRemote) {
		this.bean = analistaBeanRemoteRemote;
	}

}
