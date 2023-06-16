package funcionalidades;

import com.bigfive.beans.EstudianteBeanRemote;

public class DAOEstudiante extends DAO<EstudianteBeanRemote>{
	private static DAOEstudiante instance = new DAOEstudiante();
	
	public static DAOEstudiante getInstance() {
		return instance;
	}
	
	public DAOEstudiante() {
		initilize("ejb:/ProyectoEJB/EstudianteBean!com.bigfive.beans.EstudianteBeanRemote");
	}

}
