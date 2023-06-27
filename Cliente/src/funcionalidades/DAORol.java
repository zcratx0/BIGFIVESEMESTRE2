package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.beans.RolBeanRemote;
import com.bigfive.entities.Rol;

public class DAORol extends DAO<RolBeanRemote>{
	private static DAORol instance = new DAORol();
	
	public static DAORol getInstance() {
		return instance;
	}
	
	public DAORol() {
		initilize("ejb:/ProyectoEJB/RolBean!com.bigfive.beans.RolBeanRemote");
	}
	
	public void cargarComboBox(JComboBox<Rol> cb) {
		try {
			this.getBean().listarElementos().forEach(t -> {
				cb.addItem(t);
			});
		} catch (Exception e) {
			
		}
	}
}
