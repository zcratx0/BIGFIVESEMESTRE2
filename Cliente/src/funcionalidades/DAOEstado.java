package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.beans.EstadoBeanRemote;
import com.bigfive.entities.Estado;
import com.bigfive.entities.Tutor;

public class DAOEstado extends DAO<EstadoBeanRemote>{
	private static DAOEstado instance = new DAOEstado();
	public static DAOEstado getInstance() {
		return instance;
	}
	
	private DAOEstado() {
		initilize("ejb:/ProyectoEJB/EstadoBean!com.bigfive.beans.EstadoBeanRemote");		
	}
	
	public void cargarComboBox(JComboBox<Estado> cb)  {
		try {
			this.getBean().listarElementos().forEach(t -> {
				if (t.getEstado() == true) cb.addItem(t);
			});
		} catch (Exception e) {
		}
	}

}
