package logico;

public class Tecnico extends Personal {

	
	private String area;

	public Tecnico(String nombre, String id, int edad, String telefono, String correo, boolean vehiciculo,
			boolean disp_viajar, boolean experiencia, String area) {
		super(nombre, id, edad, telefono, correo, vehiciculo, disp_viajar, experiencia);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
	
	
	
	
	
}
