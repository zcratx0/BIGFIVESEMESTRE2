package funcionalidades;

import javax.naming.InitialContext;

import com.bigfive.beans.DepartamentoBeanRemote;
import com.bigfive.beans.UsuarioBeanRemote;

public class FuncionalidadesDepartamento {
	private static FuncionalidadesDepartamento instance = new FuncionalidadesDepartamento();
	private DepartamentoBeanRemote departamentoBean;
	
	public static FuncionalidadesDepartamento getInstance() {
		return instance;
	}
	
	public FuncionalidadesDepartamento() {
		try {
			setDepartamentoBean((DepartamentoBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/DepartamentoBean!com.bigfive.beans.DepartamentoBeanRemote"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DepartamentoBeanRemote getDepartamentoBean() {
		return departamentoBean;
		
	}

	public void setDepartamentoBean(DepartamentoBeanRemote departamentoBean) {
		this.departamentoBean = departamentoBean;
		
	}
}
