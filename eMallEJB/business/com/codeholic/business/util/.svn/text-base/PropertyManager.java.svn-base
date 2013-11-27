package com.codeholic.business.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyManager {
	
    public PropertyManager() {
    	//
    }
    
    /**
     * 
     * @param filename:properties文件路径名
     * @return：一个Properties对象
     */
    public static Properties openFile(String filename)
    {
    	File propertyFile = new File(filename); 
    	FileInputStream fis = null;
    	Properties prop = null;
    	try {
    		fis = new FileInputStream(propertyFile);
    		prop = new Properties();
    		prop.load(fis);
    		
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe){
			ioe.printStackTrace();
			
		}
    	return prop;
    }

}
