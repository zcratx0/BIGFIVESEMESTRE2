package funcionalidades;

import com.bigfive.beans.RecibeReclamoBean;
import com.bigfive.entities.RecibeReclamo;

public class DAORecibeReclamo extends DAO<RecibeReclamoBean>{
	private static DAORecibeReclamo instance = new DAORecibeReclamo();
	private DAORecibeReclamo bean;
	
	public static DAORecibeReclamo getInstance() {
		return instance;
	}
	
	public DAORecibeReclamo() {
		initilize("ejb:/ProyectoEJB/RecibeConstanciaBean!com.bigfive.beans.RecibeConstanciaBeanRemote");
	}
}
