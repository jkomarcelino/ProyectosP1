package logico;

import java.util.ArrayList;

public class SolicPerson {
	private String idSoliP;
	private Float sueldoMin;
	private Float sueldoMax;
	private ArrayList<Personal> listPersonal;
	private boolean vehiculo;
	private boolean licencia;
	private boolean disp_viajar;
	
	
	public SolicPerson(String idSoliP, Float sueldoMin, Float sueldoMax, ArrayList<Personal> listPersonal,
			boolean vehiculo, boolean licencia, boolean disp_viajar) {
		super();
		this.idSoliP = idSoliP;
		this.sueldoMin = sueldoMin;
		this.sueldoMax = sueldoMax;
		this.listPersonal = listPersonal;
		this.vehiculo = vehiculo; 
		this.licencia = licencia;
		this.disp_viajar = disp_viajar;
	}
	
	
	public String getIdSoliP() {
		return idSoliP;
	}
	public void setIdSoliP(String idSoliP) {
		this.idSoliP = idSoliP;
	}
	public Float getSueldoMin() {
		return sueldoMin;
	}
	public void setSueldoMin(Float sueldoMin) {
		this.sueldoMin = sueldoMin;
	}
	public Float getSueldoMax() {
		return sueldoMax;
	}
	public void setSueldoMax(Float sueldoMax) {
		this.sueldoMax = sueldoMax;
	}
	public ArrayList<Personal> getListPersonal() {
		return listPersonal;
	}
	public void setListPersonal(ArrayList<Personal> listPersonal) {
		this.listPersonal = listPersonal;
	}
	public boolean isVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(boolean vehiculo) {
		this.vehiculo = vehiculo;
	}
	public boolean isLicencia() {
		return licencia;
	}
	public void setLicencia(boolean licencia) {
		this.licencia = licencia;
	}
	public boolean isDisp_viajar() {
		return disp_viajar;
	}
	public void setDisp_viajar(boolean disp_viajar) {
		this.disp_viajar = disp_viajar;
	}
	
	
}