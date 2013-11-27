package com.codeholic.eao.receipt;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.codeholic.eao.GenericEaoImpl;
import com.codeholic.pojos.jpa.MonthSale;

/**
 * Session Bean implementation class MounthSaleEao
 */
@Stateless
@LocalBean
public class MonthSaleEao extends GenericEaoImpl<MonthSale>{

    /**
     * Default constructor. 
     */
    public MonthSaleEao() {
        // TODO Auto-generated constructor stub
    }

}
