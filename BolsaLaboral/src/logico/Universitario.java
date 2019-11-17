package logico;

import java.util.ArrayList;

public class Universitario extends Personal {
	
	
	private String profesion;

	

	public Universitario(String nombre, String apellido, String sexo, String id, int edad, ArrayList<String> idiomas,
			String telefono, String correo, boolean vehiciculo, boolean disp_viajar, int aniosExperiencia,
			boolean contratado, String profesion) {
		super(nombre, apellido, sexo, id, edad, idiomas, telefono, correo, vehiciculo, disp_viajar, aniosExperiencia,
				contratado);
		this.profesion = profesion;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	
	

}
