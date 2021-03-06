package com.clearminds.acb.servicios;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.clearminds.acb.bdd.ConexionBDD;
import com.clearminds.acb.dtos.Estudiante;
import com.clearminds.acb.excepciones.BDDException;
import com.clearminds.acb.utils.DateUtil;

public class ServicioEstudiante extends ServicioBase {

	@Override
	public void abrirConexion() throws BDDException {
		super.abrirConexion();
	}

	@Override
	public void cerrarConexion() {
		super.cerrarConexion();
	}
	
	public void insertarEstudiante(Estudiante estudiante) throws BDDException{
		abrirConexion();
		System.out.println("Insertando estudiante :"+estudiante);
		Statement stm = null;
		try {
			if(ConexionBDD.obtenerConexion()!=null) {
				stm = ConexionBDD.obtenerConexion().createStatement();
				String sql = "insert into estudiantes (nombre, apellido, edad, fecha_modificacion) "
						+ "values('"+estudiante.getNombre()+"','"+estudiante.getApellido()
						+"',"+estudiante.getEdad()+",'"+DateUtil.obtenerFecha(new Date())+"')";
				
				System.out.println("Script: "+sql);
				
				stm.executeUpdate(sql);
				cerrarConexion();
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar el estudiante");
		}
	}
	
	public void actualizarEstudiante(Estudiante estudiante) throws BDDException{
		abrirConexion();
		System.out.println("Modificando estudiante :"+estudiante);
		Statement stm = null;
		try {
			if(ConexionBDD.obtenerConexion()!=null) {
				stm = ConexionBDD.obtenerConexion().createStatement();
				String sql = "update estudiantes set nombre = '"+estudiante.getNombre()
						+ "' , apellido = '"+estudiante.getApellido()+"'"+" ,edad = "+estudiante.getEdad()
						+", fecha_modificacion = '"+DateUtil.obtenerFecha(new Date()) +"' where id ="+estudiante.getId();
				
				System.out.println("Script: "+sql);
				
				stm.executeUpdate(sql);
				cerrarConexion();
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar el estudiante");
		}
	}
	
}
