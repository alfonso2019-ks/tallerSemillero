package com.clearminds.acb.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import com.clearminds.acb.bdd.ConexionBDD;
import com.clearminds.acb.excepciones.BDDException;

public class ServicioBase {
	private Connection conexion;
	
	public void abrirConexion() throws BDDException{
		conexion = ConexionBDD.obtenerConexion();
	}
	
	public void cerrarConexion() {
		if(conexion != null) {
			try {
				conexion.close();
				System.out.println("Conexión cerrada");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al cerrar la conexión");
			}
		}
	}
}
