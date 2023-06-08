package funcionalidades;

import javax.naming.InitialContext;

import com.bigfive.beans.DepartamentoBeanRemote;
import com.bigfive.beans.EstudianteBeanRemote;

public class FuncionalidadesEstudiante {
	private static FuncionalidadesEstudiante instance = new FuncionalidadesEstudiante();
	private EstudianteBeanRemote bean;
	
	public static FuncionalidadesEstudiante getInstance() {
		return instance;
	}
	
	public FuncionalidadesEstudiante() {
		try {
			setBean((EstudianteBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/EstudianteBean!com.bigfive.beans.EstudianteBeanRemote"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EstudianteBeanRemote getBean() {
		return bean;
		
	}

	public void setBean(EstudianteBeanRemote bean) {
		this.bean = bean;
		
	}
}
