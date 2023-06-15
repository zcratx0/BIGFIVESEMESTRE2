package funcionalidades;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.ReclamoRemote;
import com.bigfive.beans.RolBeanRemote;

public class FuncionalidadesReclamo {
	private static FuncionalidadesReclamo instance = new FuncionalidadesReclamo();
	private ReclamoRemote bean;
	
	public static FuncionalidadesReclamo getInstance() {
		return instance;
	}
	
	public FuncionalidadesReclamo() {
		try {
			setBean((ReclamoRemote) InitialContext.doLookup("ejb:/ProyectoEJB/ReclamoBean!com.bigfive.beans.ReclamoRemote"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the bean
	 */
	public ReclamoRemote getBean() {
		return bean;
	}

	/**
	 * @param bean the bean to set
	 */
	public void setBean(ReclamoRemote bean) {
		this.bean = bean;
	}
	

}
