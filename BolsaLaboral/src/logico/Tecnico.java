package logico;

import java.util.ArrayList;

public class Tecnico extends Personal {

	
	private String area;

	

	public Tecnico(String nombre, String apellido, String sexo, String id, int edad, ArrayList<String> idiomas,
			String telefono, String correo, boolean vehiciculo, boolean disp_viajar, int aniosExperiencia,
			boolean contratado, String area) {
		super(nombre, apellido, sexo, id, edad, idiomas, telefono, correo, vehiciculo, disp_viajar, aniosExperiencia,
				contratado);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
	
	
	
	
	
}
