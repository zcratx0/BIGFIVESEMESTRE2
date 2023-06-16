package funcionalidades;

import javax.swing.JComboBox;

import com.bigfive.entities.Departamento;
import com.bigfive.entities.EnumDepartamentos;

public class DAODepartamento extends DAO<Departamento>{
	private static DAODepartamento instance = new DAODepartamento();
	public static DAODepartamento getInstance() {
		return instance;
	}
	public DAODepartamento() {
		//	TODO Ajustar para que nada utilize esta función.
		//initilize("ejb:/ProyectoEJB/DepartamentoBean!com.bigfive.beans.DepartamentoBeanRemote");
	}
	
	public void cargarComboBox(JComboBox cb) {
		for (EnumDepartamentos departamentos : EnumDepartamentos.values()) {
			cb.addItem(departamentos);
		}
	}
	
}
