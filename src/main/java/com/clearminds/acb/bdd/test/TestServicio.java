package com.clearminds.acb.bdd.test;

import com.clearminds.acb.dtos.Estudiante;
import com.clearminds.acb.excepciones.BDDException;
import com.clearminds.acb.servicios.ServicioEstudiante;

public class TestServicio {
	public static void main(String[] args) {
		ServicioEstudiante estudianteService = new ServicioEstudiante();
		try {
			estudianteService.insertarEstudiante(new Estudiante("Alfonso", "Castro"));
		}catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
