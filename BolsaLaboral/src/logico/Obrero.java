package logico;

import java.util.ArrayList;

public class Obrero extends Personal {
	
	private ArrayList<String>skills;

	public Obrero(String nombre, String apellido, String sexo, String id, int edad, ArrayList<String> idiomas,
			String telefono, String correo, boolean vehiciculo, boolean disp_viajar, int aniosExperiencia,
			boolean contratado, ArrayList<String> skills) {
		super(nombre, apellido, sexo, id, edad, idiomas, telefono, correo, vehiciculo, disp_viajar, aniosExperiencia,
				contratado);
		this.skills = skills;
	}

	
	
	
	
	
	

}
