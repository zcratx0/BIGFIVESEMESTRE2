package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;

import com.bigfive.entities.Tutor;

/**
 * Session Bean implementation class TutorBean
 */
@Stateless
public class TutorBean implements TutorBeanRemote {

    /**
     * Default constructor. 
     */
    public TutorBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean crear(Tutor value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public boolean borrar(Tutor value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrar'");
    }

    @Override
    public boolean modificar(Tutor value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public List<Tutor> listarElementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarElementos'");
    }

}
