package com.codeholic.eao.shop;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.codeholic.eao.GenericEaoImpl;
import com.codeholic.pojos.jpa.StoreInfo;

/**
 * Session Bean implementation class StoreInfoEao
 */
@Stateless
@LocalBean
public class StoreInfoEao extends GenericEaoImpl<StoreInfo>{

    /**
     * Default constructor. 
     */
    public StoreInfoEao() {
        // TODO Auto-generated constructor stub
    }

}
