package funcionalidades;

import com.bigfive.beans.ReclamoRemote;

public class DAOReclamo extends DAO<ReclamoRemote> {
	private static DAOReclamo instance = new DAOReclamo();
	
	public static DAOReclamo getInstance() {
		return instance;
	}
	
	public DAOReclamo() {
		initialize("ejb:/ProyectoEJB/ReclamoBean!com.bigfive.beans.ReclamoRemote");
	}

	

}
