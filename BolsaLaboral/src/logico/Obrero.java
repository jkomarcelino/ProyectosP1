package logico;

import java.util.ArrayList;

public class Obrero extends Personal {
	
	private ArrayList<String>skills;

	public Obrero(String nombre, String id, int edad, String telefono, String correo, boolean vehiciculo,
			boolean disp_viajar, boolean experiencia,boolean contratado, ArrayList<String> skills) {
		super(nombre, id, edad, telefono, correo, vehiciculo, disp_viajar, experiencia, contratado);
		this.skills = skills;
	}
	
	
	
	
	

}
