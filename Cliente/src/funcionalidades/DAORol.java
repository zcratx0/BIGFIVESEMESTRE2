package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.beans.RolBeanRemote;

public class DAORol extends DAO<RolBeanRemote>{
	private static DAORol instance = new DAORol();
	
	public static DAORol getInstance() {
		return instance;
	}
	
	public DAORol() {
		initilize("ejb:/ProyectoEJB/RolBean!com.bigfive.beans.RolBeanRemote");
	}
	
	public void cargarComboBox(JComboBox cb) {
		try {
			this.bean.listarElementos().forEach(t -> {
				cb.addItem(t.toString());
			});
		} catch (Exception e) {
			
		}
	}
}
