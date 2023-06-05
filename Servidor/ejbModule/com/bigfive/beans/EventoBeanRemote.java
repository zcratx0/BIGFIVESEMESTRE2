package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Evento;

@Remote
public interface EventoBeanRemote extends ICrud<Evento>{

}
