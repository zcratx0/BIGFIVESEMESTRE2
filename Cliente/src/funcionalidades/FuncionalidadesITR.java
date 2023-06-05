package funcionalidades;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.DepartamentoBeanRemote;
import com.bigfive.beans.ITRBeanRemote;

public class FuncionalidadesITR {
	private static FuncionalidadesITR instance = new FuncionalidadesITR();
	private ITRBeanRemote itrBean;

	public static FuncionalidadesITR getInstance() {
		return instance;
	}
	
	public FuncionalidadesITR() {
		try {
			setItrBean((ITRBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/ITRBean!com.bigfive.beans.ITRBeanRemote"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ITRBeanRemote getItrBean() {
		return itrBean;
	}

	public void setItrBean(ITRBeanRemote itrBean) {
		this.itrBean = itrBean;
	}
	public void cargarComboBox(JComboBox cb) {
		try {
			itrBean.listarElementos().forEach(t -> {
				cb.addItem(t);
			});
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
}
