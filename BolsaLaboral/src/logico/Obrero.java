package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Obrero extends Personal {
	
	
	private static final long serialVersionUID = 1L;
	ArrayList<String> habilidades;

	
	
	
	public Obrero(String cedula, String nombres, String apellidos, String telefono,
			String nacionalidad, String sexo, String estadoCivil, String direccion, String provincia, String email,
			boolean vehiculoPropio, int categoriaLicencia, int annosExperiencia, ArrayList<String> idiomas,
			boolean contratado, boolean mudarse, String ciudad, String sector, String calle, int numeroCasa,
			String referencia, ArrayList<String> habilidades) {
		super(cedula, nombres, apellidos, telefono,nacionalidad, sexo, estadoCivil, direccion, provincia,
				email, vehiculoPropio, categoriaLicencia, annosExperiencia, idiomas, contratado, mudarse, ciudad, sector, calle,
				numeroCasa, referencia);
	this.habilidades = habilidades;
	}

	
	


	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}

	

	

	
	
	
	
	
	

}
