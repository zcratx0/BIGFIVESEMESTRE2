package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.entities.EnumDepartamentos;

public class DAODepartamento {
	private static DAODepartamento instance = new DAODepartamento();
	public static DAODepartamento getInstance() {
		return instance;
	}
	
	public void cargarComboBox(JComboBox cb) {
		for (EnumDepartamentos departamentos : EnumDepartamentos.values()) {
			cb.addItem(departamentos);
		}
	}
	
}
