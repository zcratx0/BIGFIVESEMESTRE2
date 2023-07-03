package funcionalidades;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.TutorBeanRemote;
import com.bigfive.entities.Tutor;

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

    public void cargarComboBox(JComboBox<Tutor> tfDocente) {
    }
	
}
