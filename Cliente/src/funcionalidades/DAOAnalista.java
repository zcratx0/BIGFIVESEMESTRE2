package funcionalidades;

import com.bigfive.beans.AnalistaBeanRemoteRemote;

public class DAOAnalista extends DAO<AnalistaBeanRemoteRemote> {
	private static DAOAnalista instance = new DAOAnalista();
	public static DAOAnalista getInstance() {
		return instance;
	}
	
	private DAOAnalista() {
		initialize("ejb:/ProyectoEJB/AnalistaBeanRemote!com.bigfive.beans.AnalistaBeanRemoteRemote");		
	}

}
