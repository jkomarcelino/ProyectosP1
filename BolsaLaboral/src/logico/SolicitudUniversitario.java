package logico;

import java.util.ArrayList;

public class SolicitudUniversitario extends Solicitud {
	
	
	private String profesion;

	
	
	
	public SolicitudUniversitario(Empresa empresa, String codigo, String tipo_de_contrato, int min_anios_exp,
			boolean vehiculo, String sexo, ArrayList<String> idiomas, boolean vehiciculo, boolean disp_viajar,
			String profesion) {
		super(empresa, codigo, tipo_de_contrato, min_anios_exp, vehiculo, sexo, idiomas, vehiciculo, disp_viajar);
		this.profesion = profesion;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	
	

}
