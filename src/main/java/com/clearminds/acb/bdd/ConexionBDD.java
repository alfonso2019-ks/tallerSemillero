package com.clearminds.acb.bdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.clearminds.acb.excepciones.BDDException;

public class ConexionBDD {
	
	public static String leerPropiedad(String nombrePropiedad) throws FileNotFoundException, IOException {
		File f=new File("conexion.properties");
		System.out.println("ruta:"+f.getAbsoluteFile());
		Properties p = new Properties();
		p.load(new FileReader("D:\\tallerSemillero\\tallerSemillero\\conexion.properties"));
		if(p.getProperty(nombrePropiedad)!=null) {
			return p.getProperty(nombrePropiedad);
		}
		return null;
	}
	
	public static Connection obtenerConexion() throws BDDException {
		
		try {
			String user = leerPropiedad("usuario");
			String password = leerPropiedad("password");
			String pathConexion = leerPropiedad("urlConexion");
			Connection conn=null;
			conn = DriverManager.getConnection(pathConexion, user, password);
			return conn;
		}catch(Exception se){
		      se.printStackTrace();
		      throw new BDDException("Error: No se pudo conectar a la base de datos");
		}
	}
}
