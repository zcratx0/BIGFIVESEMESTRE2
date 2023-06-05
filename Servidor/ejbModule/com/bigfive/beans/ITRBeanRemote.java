package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Itr;

@Remote
public interface ITRBeanRemote extends ICrud<Itr> {

}
