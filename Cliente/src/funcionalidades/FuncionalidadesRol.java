package funcionalidades;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.RolBeanRemote;

public class FuncionalidadesRol {
	private static FuncionalidadesRol instance = new FuncionalidadesRol();
	private RolBeanRemote rolBean;
	
	public static FuncionalidadesRol getInstance() {
		return instance;
	}
	
	public FuncionalidadesRol() {
		try {
			setRolBean((RolBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/RolBean!com.bigfive.beans.RolBeanRemote"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public RolBeanRemote getRolBean() {
		return rolBean;
	}

	public void setRolBean(RolBeanRemote rolBean) {
		this.rolBean = rolBean;
	}

	public void cargarComboBox(JComboBox cb) {
		try {
			rolBean.listarElementos().forEach(t -> {
				cb.addItem(t.toString());
			});
		} catch (Exception e) {
			
		}
	}
}