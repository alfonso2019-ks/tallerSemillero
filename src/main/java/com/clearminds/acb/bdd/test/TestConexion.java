package com.clearminds.acb.bdd.test;

import java.sql.Connection;

import com.clearminds.acb.bdd.ConexionBDD;
import com.clearminds.acb.excepciones.BDDException;

public class TestConexion {

	public static void main(String[] args) {
		try {
			Connection conexion = ConexionBDD.obtenerConexion();
			if(conexion!=null) {
				System.out.println("Conexión exitosa");
			}
		}catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
