package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.beans.AreaBeanRemoteRemote;
import com.bigfive.entities.Area;

public class DAOArea extends DAO<AreaBeanRemoteRemote> {
	private static DAOArea instance = new DAOArea();
	private AreaBeanRemoteRemote areaBean;
	
	public static DAOArea getInstance() {
		return instance;
	}
	
	public DAOArea() {
		initilize("ejb:/ProyectoEJB/AreaBeanRemote!com.bigfive.beans.AreaBeanRemoteRemote");
	}
	
	public void cargarComboBox(JComboBox<Area> cb) {
		try {
			System.out.println("Cargando ComboBox");
			this.getBean().listarElementos().forEach(a -> {
				cb.addItem(a);
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
