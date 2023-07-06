package com.bigfive.beans;
import javax.ejb.Remote;
import com.bigfive.entities.Accione;
import com.bigfive.entities.Reclamo;

@Remote
public interface AccionesBeanRemote extends ICrud<Accione>{

	boolean reportaarAccion(Accione accion, Reclamo reclamo);

}
