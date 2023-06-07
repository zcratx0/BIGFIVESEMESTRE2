package funcionalidades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bigfive.beans.GeneracionBeanRemote;

public class FuncionalidadesGeneracion {
	private static FuncionalidadesGeneracion instance = new FuncionalidadesGeneracion();
	private GeneracionBeanRemote bean;
	public static FuncionalidadesGeneracion getInstance() {
		return instance;
	}
	
	private FuncionalidadesGeneracion() {
		try {
			setBean((GeneracionBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/GeneracionBean!com.bigfive.beans.GeneracionBeanRemote"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public GeneracionBeanRemote getBean() {
		return bean;
		
	}

	public void setBean(GeneracionBeanRemote bean) {
		this.bean = bean;
	}
}
