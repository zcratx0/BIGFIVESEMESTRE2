package funcionalidades;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.GeneroBeanRemote;
import com.bigfive.beans.ITRBeanRemote;

public class DAOGenero extends DAO<GeneroBeanRemote>{
private static DAOGenero instance = new DAOGenero();
	private GeneroBeanRemote Bean;

	public static DAOGenero getInstance() {
		return instance;
	}
	
	public DAOGenero() {
		try {
			setBean((GeneroBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/GeneroBean!com.bigfive.beans.GeneroBeanRemote"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public GeneroBeanRemote getBean() {
		return Bean;
	}

	public void setBean(GeneroBeanRemote Bean) {
		this.Bean = Bean;
	}
	public void cargarComboBox(JComboBox cb) {
		try {
			Bean.listarElementos().forEach(t -> {
                System.out.println(t);
				cb.addItem(t);
			});
		} catch (Exception e) {
	
    System.out.println("errorcargar genero " + e.getMessage());
    
    ;        // TODO: handle exception
		}		
	}
	
}
