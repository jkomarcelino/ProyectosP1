package logico;

import java.util.ArrayList;

public class Tecnico extends Personal {

	
	private String area;

	

	public Tecnico(String nombre, String apellido, String sexo, String nacionalidad, String id, int edad,
			ArrayList<String> idiomas, String telefono, String correo, boolean vehiciculo, boolean disp_viajar,
			int aniosExperiencia, boolean contratado, int codigo_persona, String area) {
		super(nombre, apellido, sexo, nacionalidad, id, edad, idiomas, telefono, correo, vehiciculo, disp_viajar,
				aniosExperiencia, contratado, codigo_persona);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
	
	
	
	
	
}
