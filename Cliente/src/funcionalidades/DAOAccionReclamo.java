package funcionalidades;

import com.bigfive.beans.AccionesBeanRemote;

public class DAOAccionReclamo  extends DAO<AccionesBeanRemote>{
	private static DAOAccionReclamo instance = new DAOAccionReclamo();
	private DAOAccionReclamo bean;
	
	public static DAOAccionReclamo getInstance() {
		return instance;
	}
	
	public DAOAccionReclamo() {
		initilize("ejb:/ProyectoEJB/AreaBeanRemote!com.bigfive.beans.AreaBeanRemoteRemote");
	}
}
