package logico;

import java.util.ArrayList;

public class SolicCentro {
	private String idSoliC;
	private ArrayList<Empresa> listEmpresa;
	private String nivel;
	private int annoExp;
	private boolean vehiculo;
	private boolean disp_viajar;
	private boolean licencia;
	private String sector;
	private float sueldo;
	private String tipoSueldo;
	
	
	public SolicCentro(String idSoliC, ArrayList<Empresa> listEmpresa, String nivel, int annoExp, boolean vehiculo,
			boolean disp_viajar, boolean licencia, String sector, float sueldo, String tipoSueldo) {
		super();
		this.idSoliC = idSoliC;
		this.listEmpresa = listEmpresa;
		this.nivel = nivel;
		this.annoExp = annoExp;
		this.vehiculo = vehiculo;
		this.disp_viajar = disp_viajar;
		this.licencia = licencia;
		this.sector = sector;
		this.sueldo = sueldo;
		this.tipoSueldo = tipoSueldo;
	}
	
	
	
	public String getIdSoliC() {
		return idSoliC;
	}
	public void setIdSoliC(String idSoliC) {
		this.idSoliC = idSoliC;
	}
	public ArrayList<Empresa> getListEmpresa() {
		return listEmpresa;
	}
	public void setListEmpresa(ArrayList<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public int getAnnoExp() {
		return annoExp;
	}
	public void setAnnoExp(int annoExp) {
		this.annoExp = annoExp;
	}
	public boolean isVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(boolean vehiculo) {
		this.vehiculo = vehiculo;
	}
	public boolean isDisp_viajar() {
		return disp_viajar;
	}
	public void setDisp_viajar(boolean disp_viajar) {
		this.disp_viajar = disp_viajar;
	}
	public boolean isLicencia() {
		return licencia;
	}
	public void setLicencia(boolean licencia) {
		this.licencia = licencia;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public String getTipoSueldo() {
		return tipoSueldo;
	}
	public void setTipoSueldo(String tipoSueldo) {
		this.tipoSueldo = tipoSueldo;
	}
	
	
}
