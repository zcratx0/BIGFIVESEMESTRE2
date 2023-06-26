package funcionalidades;

import javax.naming.InitialContext;

import com.bigfive.beans.TutorBeanRemote;

public class DAOTutor extends DAO<TutorBeanRemote> {
	private static DAOTutor instance = new DAOTutor();

	public DAOTutor() {
		initilize("ejb:/ProyectoEJB/TutorBean!com.bigfive.beans.TutorBeanRemote");
	}

	/**
	 * @return the instance
	 */
	public static DAOTutor getInstance() {
		return instance;
	}
	
}
