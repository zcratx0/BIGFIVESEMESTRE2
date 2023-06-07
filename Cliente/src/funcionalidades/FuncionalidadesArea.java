package funcionalidades;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.AnalistaBeanRemoteRemote;
import com.bigfive.beans.AreaBeanRemote;
import com.bigfive.beans.AreaBeanRemoteRemote;

public class FuncionalidadesArea {
	private static FuncionalidadesArea instance = new FuncionalidadesArea();
	private AreaBeanRemoteRemote areaBean;
	
	public static FuncionalidadesArea getInstance() {
		return instance;
	}
	
	public FuncionalidadesArea() {
		try {
			setAreaBean((AreaBeanRemoteRemote) InitialContext.doLookup(	"ejb:/ProyectoEJB/AreaBeanRemote!com.bigfive.beans.AreaBeanRemoteRemote"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AreaBeanRemoteRemote getAreaBean() {
		return areaBean;
	}
	
	public void setAreaBean(AreaBeanRemoteRemote areaBean) {
		this.areaBean = areaBean;
	}
	
	public void cargarComboBox(JComboBox cb) {
		try {
			areaBean.listarElementos().forEach(t -> {
				cb.addItem(t.toString());
			});
		} catch (Exception e) {
			
		}
	}
}
