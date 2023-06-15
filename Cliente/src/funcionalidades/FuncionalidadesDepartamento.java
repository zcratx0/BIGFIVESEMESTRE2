package funcionalidades;

import java.util.List;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.DepartamentoBeanRemote;
import com.bigfive.beans.UsuarioBeanRemote;
import com.bigfive.entities.Departamento;
import com.bigfive.entities.EnumDepartamentos;

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
	
	public void cargarComboBox(JComboBox cb) {
		for (EnumDepartamentos departamentos : EnumDepartamentos.values()) {
			cb.addItem(departamentos);
		}
	}
	
}
