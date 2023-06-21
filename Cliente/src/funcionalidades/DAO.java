package funcionalidades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DAO<T> {
	private T bean;
	
	public void initialize(String path) {
		try {
			setBean((T) InitialContext.doLookup(path));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public T getBean() {
		return bean;	
	}
	public void setBean(T bean) {
		this.bean = bean;
		
	}
}
