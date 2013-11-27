package com.codeholic.business;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class GenericServiceImpl
 */
@Stateless
@Local(GenericService.class)
public class GenericServiceImpl {

    /**
     * Default constructor. 
     */
    public GenericServiceImpl() {
    	
    }

}
