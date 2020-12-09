package com.clearminds.acb.servicios;

import com.clearminds.acb.dtos.Estudiante;
import com.clearminds.acb.excepciones.BDDException;

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
		cerrarConexion();
	}
	
}
