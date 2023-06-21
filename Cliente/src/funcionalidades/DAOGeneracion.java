package funcionalidades;

import com.bigfive.beans.GeneracionBeanRemote;

public class DAOGeneracion extends DAO<GeneracionBeanRemote> {
	private static DAOGeneracion instance = new DAOGeneracion();
	public static DAOGeneracion getInstance() {
		return instance;
	}
	
	private DAOGeneracion() {
		initialize("ejb:/ProyectoEJB/GeneracionBean!com.bigfive.beans.GeneracionBeanRemote");
	}
}
