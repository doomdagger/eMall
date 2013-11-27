package com.codeholic.business.util;

import java.util.ArrayList;

public class GoodTrend{

    /**
     * Default constructor. 
     */
    public GoodTrend() {
        // TODO Auto-generated constructor stub
    }
    
    public static float getLeastSquaresRate(ArrayList<Integer> sales,int days)
    {    	
    	int sx=0,sy=0,sxx=0,sxy=0;
    	float xe,ye,xye,xxe;
    	float a,b,rate;
    	for(int i=0; i<days; i++)
    	{
    		sx = sx + i;
    		sy = sy + sales.get(i);
    		sxx = sxx + i*i;
    		sxy = sxy + i*sales.get(i);
    	}
    	xe = sx/days;
    	ye = sy/days;
    	xye = sxy/days;
    	xxe = sxx/days;
    	
    	a=(xye-xe*ye)/(xxe-xe*xe);
    	b=ye-a*xe;
    	
    	//根据a,b得到导函数
    	rate = a/b;
    	return rate;
    }

}
