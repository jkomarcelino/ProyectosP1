package logico;

import java.util.ArrayList;

public class SolicitudObrero extends Solicitud {
	
	private ArrayList<String>skills=new ArrayList<String>();

	
	
	
	public SolicitudObrero(Empresa empresa, String codigo, String tipo_de_contrato, int min_anios_exp, boolean vehiculo,
			String sexo, ArrayList<String> idiomas, String ciudad, boolean soltero, boolean disp_viajar,
			ArrayList<String> skills) {
		super(empresa, codigo, tipo_de_contrato, min_anios_exp, vehiculo, sexo, idiomas, ciudad, soltero, disp_viajar);
		this.skills = skills;
	}



	public ArrayList<String> getSkills() {
		return skills;
	}

	

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
	
	

}
