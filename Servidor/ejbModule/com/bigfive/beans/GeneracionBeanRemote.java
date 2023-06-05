package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Generacion;

@Remote
public interface GeneracionBeanRemote extends ICrud<Generacion>{

}
