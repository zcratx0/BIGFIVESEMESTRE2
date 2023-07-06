package funcionalidades;

import com.bigfive.beans.RecibeReclamoBeanRemote;

public class DAORecibeReclamo extends DAO<RecibeReclamoBeanRemote>{
private static DAORecibeReclamo instance = new DAORecibeReclamo();
	
	public static DAORecibeReclamo getInstance() {
		return instance;
	}
	
	public DAORecibeReclamo() {
		initilize("ejb:/ProyectoEJB/RecibeReclamoBean!com.bigfive.beans.RecibeReclamoBeanRemote");
	}
}
