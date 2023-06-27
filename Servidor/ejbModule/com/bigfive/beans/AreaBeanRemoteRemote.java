package com.bigfive.beans;

import java.util.List;

import javax.ejb.Remote;

import com.bigfive.entities.Area;

@Remote
public interface AreaBeanRemoteRemote extends ICrud<Area>{
	public List<Area> listarAreas();
}
