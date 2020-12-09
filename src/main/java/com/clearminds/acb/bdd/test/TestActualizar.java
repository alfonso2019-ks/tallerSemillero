package com.clearminds.acb.bdd.test;

import com.clearminds.acb.dtos.Estudiante;
import com.clearminds.acb.excepciones.BDDException;
import com.clearminds.acb.servicios.ServicioEstudiante;

public class TestActualizar {

	public static void main(String[] args) {
		ServicioEstudiante estudianteService = new ServicioEstudiante();
		try {
			estudianteService.actualizarEstudiante(new Estudiante("Pedro", "Navaja", 1));
		}catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
