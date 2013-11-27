package com.codeholic.business.util;

import javax.naming.NamingException;

import com.ibm.websphere.naming.DumpNameSpace;

public class DumpContainerNamespace {
	public static void main(String[] args) throws NamingException{
		String[] myargs = new String[]{"-host","localhost","-user", "lihe", "-password", "911119"};
		DumpNameSpace.main(myargs);
	}
}
