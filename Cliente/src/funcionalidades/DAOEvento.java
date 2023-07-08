package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.beans.EventoBeanRemote;

public class DAOEvento extends DAO<EventoBeanRemote>{
	private static DAOEvento instance = new DAOEvento();
	public static DAOEvento getInstance() {
		return instance;
	}
	public DAOEvento() {
		initilize("ejb:/ProyectoEJB/EventoBean!com.bigfive.beans.EventoBeanRemote");
	}
	
	public void cargarComboBox(JComboBox cb) {
		cb.removeAllItems();
		cb.addItem("SELECCIONAR EVENTO");
		instance.getBean().listarElementos().forEach(estado -> {
			cb.addItem(estado);
		});
	}
}
