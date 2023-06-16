package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.beans.AreaBeanRemoteRemote;

public class DAOArea extends DAO<AreaBeanRemoteRemote> {
	private static DAOArea instance = new DAOArea();
	private AreaBeanRemoteRemote areaBean;
	
	public static DAOArea getInstance() {
		return instance;
	}
	
	public DAOArea() {
		initilize("ejb:/ProyectoEJB/AreaBeanRemote!com.bigfive.beans.AreaBeanRemoteRemote");
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
