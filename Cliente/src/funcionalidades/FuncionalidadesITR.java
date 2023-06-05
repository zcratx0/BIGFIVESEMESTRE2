package funcionalidades;

import javax.naming.InitialContext;

import com.bigfive.beans.DepartamentoBeanRemote;

public class FuncionalidadesITR {
	private static FuncionalidadesITR instance = new FuncionalidadesITR();
	private DepartamentoBeanRemote departamentoBean;
	
	public static FuncionalidadesITR getInstance() {
		return instance;
	}
	
	public FuncionalidadesITR() {
		try {
			setDepartamentoBean(() InitialContext.doLookup("ejb:/ProyectoEJB/DepartamentoBean!com.bigfive.beans.DepartamentoBeanRemote"));
			
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
