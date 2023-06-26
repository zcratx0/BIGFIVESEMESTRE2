package funcionalidades;

import com.bigfive.beans.ConstanciaBeanRemote;

public class DAOConstancia extends DAO<ConstanciaBeanRemote> {
	private static DAOConstancia instance = new DAOConstancia();
	
	
	public DAOConstancia() {
		initilize("ejb:/ProyectoEJB/ConstanciaBeanRemote!com.bigfive.beans.ConstanciaBeanRemoteRemote");
	}
	
	/**
	 * @return the instance
	 */
	public static DAOConstancia getInstance() {
		return instance;
	}
	
}
