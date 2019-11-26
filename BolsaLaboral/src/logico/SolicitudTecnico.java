package logico;

import java.util.ArrayList;

public class SolicitudTecnico extends Solicitud {
	
	
	private String area;

	

	public SolicitudTecnico(Empresa empresa, String codigo, String tipo_de_contrato, int min_anios_exp,
			boolean vehiculo, String sexo, ArrayList<String> idiomas, String ciudad, boolean soltero,
			boolean disp_viajar, String area) {
		super(empresa, codigo, tipo_de_contrato, min_anios_exp, vehiculo, sexo, idiomas, ciudad, soltero, disp_viajar);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
	

}
