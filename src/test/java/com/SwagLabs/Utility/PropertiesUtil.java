package com.SwagLabs.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil 
{
	Properties p1;
	public PropertiesUtil() throws FileNotFoundException 
	{

		// File
		File f1 = new File("./" + "\\config.properties");
		// read in a stream by using FileInputStream class
		FileInputStream fs = new FileInputStream(f1);
		// just to handle properties file
		p1 = new Properties();

		// update everything from properties file to here for this using load method

		try {
			p1.load(fs);
		} catch (IOException e) {
		}
	}
		public String getData(String key)
		{
			return p1.getProperty(key);
		}

	}


