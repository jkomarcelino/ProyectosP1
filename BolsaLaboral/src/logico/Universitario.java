package logico;

public class Universitario extends Personal {
	
	
	private String profesion;

	public Universitario(String nombre, String id, int edad, String telefono, String correo, boolean vehiciculo,
			boolean disp_viajar, boolean experiencia,boolean contratado, String profesion) {
		super(nombre, id, edad, telefono, correo, vehiciculo, disp_viajar, experiencia,contratado);
		this.profesion = profesion;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	
	

}
