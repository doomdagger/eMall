package com.codeholic.eao.receipt;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.codeholic.eao.GenericEaoImpl;
import com.codeholic.pojos.jpa.DaySale;

/**
 * Session Bean implementation class DaySaleEao
 */
@Stateless
@LocalBean
public class DaySaleEao extends GenericEaoImpl<DaySale>{

    /**
     * Default constructor. 
     */
    public DaySaleEao() {
        // TODO Auto-generated constructor stub
    }

}
