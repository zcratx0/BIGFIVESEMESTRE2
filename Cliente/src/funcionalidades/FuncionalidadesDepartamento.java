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
			departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
