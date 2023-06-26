package funcionalidades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bigfive.beans.AnalistaBeanRemoteRemote;

public abstract class DAO<T> {
	public T bean;
	
	public void initilize(String ejb) {
		try {
			this.setBean((T) InitialContext.doLookup(ejb));
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setBean(T bean) {
		this.bean = bean;
	}
	public T getBean() {
		return this.bean;
	}
}
