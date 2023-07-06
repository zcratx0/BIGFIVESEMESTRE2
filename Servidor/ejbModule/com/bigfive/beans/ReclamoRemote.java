package com.bigfive.beans;

import java.util.List;

import javax.ejb.Remote;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Evento;
import com.bigfive.entities.Reclamo;
@Remote
public interface ReclamoRemote extends ICrud<Reclamo> {
	public List<Reclamo> reclamosDelEstudiante(Estudiante estudiante);

	boolean agregarReclamo(Reclamo value, Evento evento);
}
