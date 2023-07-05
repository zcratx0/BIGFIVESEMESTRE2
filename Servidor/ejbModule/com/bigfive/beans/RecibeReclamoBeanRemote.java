package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Reclamo;

@Remote
public interface RecibeReclamoBeanRemote extends ICrud<Reclamo> {

}
