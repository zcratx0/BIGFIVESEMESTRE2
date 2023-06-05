package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Departamento;

@Remote
public interface DepartamentoBeanRemote extends ICrud<Departamento>{

}
