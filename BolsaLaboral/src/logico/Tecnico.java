package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tecnico extends Personal implements Serializable{

	public Tecnico(String cedula, String nombres, String apellidos,int edad, String telefono,
			String nacionalidad, String sexo, String estadoCivil, String direccion, String provincia, String email,
			boolean vehiculoPropio, int categoriaLicencia, int annosExperiencia, ArrayList<String> idiomas,
			boolean contratado, boolean mudarse, String ciudad, String sector, String calle, int numeroCasa,
			String referencia, String area) {
		super(cedula, nombres, apellidos,edad, telefono,nacionalidad, sexo, estadoCivil, direccion, provincia,
				email, vehiculoPropio, categoriaLicencia, annosExperiencia, idiomas, contratado, mudarse, ciudad, sector, calle,
				numeroCasa, referencia);
		this.area = area;
	}

	private static final long serialVersionUID = 1L;
	private String area;


	

	

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
	
	
	
	
	
	
}
