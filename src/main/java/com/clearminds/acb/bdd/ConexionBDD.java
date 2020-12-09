package com.clearminds.acb.bdd;

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
	
	public static Connection obtenerConexion() throws BDDException {
		Properties p = new Properties();
		Connection conn = null;
		try {
			p.load(new FileReader("./conexion.properties"));
			String user = p.getProperty("usuario");
			String password = p.getProperty("password");
			String pathConexion = p.getProperty("urlConexion");
			conn = DriverManager.getConnection(pathConexion, user, password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new BDDException("Error: no encuentra la ruta del archivo properties");
		} catch (IOException e) {
			e.printStackTrace();
			throw new BDDException("Error: al obtener las propiedades del archivo properties");
		}catch(SQLException se){
		      se.printStackTrace();
		      throw new BDDException("Error: No se pudo conectar a la base de datos");
		}
		return conn;
	}
}
