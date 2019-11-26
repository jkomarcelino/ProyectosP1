package logico;

import java.util.ArrayList;

public abstract class Solicitud {
	
protected Empresa empresa;
protected String codigo;
protected String tipo_de_contrato;
protected int min_anios_exp;
protected boolean vehiculo;//
protected String sexo;//
protected ArrayList<String>idiomas=new ArrayList<String>();
protected String ciudad;
protected boolean soltero;

protected boolean disp_viajar;


private static int CODIGO_SIGUIENTE=0;









public Solicitud(Empresa empresa, String codigo, String tipo_de_contrato, int min_anios_exp, boolean vehiculo,
		String sexo, ArrayList<String> idiomas, String ciudad, boolean soltero, boolean disp_viajar) {
	super();
	this.empresa = empresa;
	this.codigo = codigo;
	this.tipo_de_contrato = tipo_de_contrato;
	this.min_anios_exp = min_anios_exp;
	this.vehiculo = vehiculo;
	this.sexo = sexo;
	this.idiomas = idiomas;//agregar for??
	this.ciudad = ciudad;
	this.soltero = soltero;
	this.disp_viajar = disp_viajar;
}



public Empresa getEmpresa() {
	return empresa;
}



public void setEmpresa(Empresa empresa) {
	this.empresa = empresa;
}



public String getCodigo() {
	return codigo;
}



public void setCodigo(String codigo) {
	this.codigo = codigo;
}



public String getTipo_de_contrato() {
	return tipo_de_contrato;
}



public void setTipo_de_contrato(String tipo_de_contrato) {
	this.tipo_de_contrato = tipo_de_contrato;
}



public int getMin_anios_exp() {
	return min_anios_exp;
}



public void setMin_anios_exp(int min_anios_exp) {
	this.min_anios_exp = min_anios_exp;
}



public boolean isVehiculo() {
	return vehiculo;
}



public void setVehiculo(boolean vehiculo) {
	this.vehiculo = vehiculo;
}



public String getSexo() {
	return sexo;
}



public void setSexo(String sexo) {
	this.sexo = sexo;
}



public ArrayList<String> getIdiomas() {
	return idiomas;
}



public void setIdiomas(ArrayList<String> idiomas) {
	this.idiomas = idiomas;
}






public boolean isDisp_viajar() {
	return disp_viajar;
}



public void setDisp_viajar(boolean disp_viajar) {
	this.disp_viajar = disp_viajar;
}



public static int getCODIGO_SIGUIENTE() {
	return CODIGO_SIGUIENTE;
}



public static void setCODIGO_SIGUIENTE(int cODIGO_SIGUIENTE) {
	CODIGO_SIGUIENTE = cODIGO_SIGUIENTE;
}





}
