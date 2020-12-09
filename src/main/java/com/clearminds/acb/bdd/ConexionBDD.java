package com.clearminds.acb.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConexionBDD {
	public static String leerPropiedad(String nombrePropiedad) {
		Properties p = new Properties();
		try {
			p.load(new FileReader("./conexion.properties"));
			return p.getProperty(nombrePropiedad);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
