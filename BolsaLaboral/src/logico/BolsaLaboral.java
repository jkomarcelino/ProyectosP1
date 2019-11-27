package logico;

import java.util.ArrayList;

public class BolsaLaboral {
	//private ArrayList<SolicCentro> listSolisC;
	private ArrayList<Solicitud> listSolicitudes;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Empresa> listEmpresa;
	private static BolsaLaboral bolsa=null;
	
	 
	
	
	public BolsaLaboral() {
		super();
		//bolsa null
		this.listSolicitudes = new ArrayList<Solicitud>();
		this.listPersonal = new ArrayList<Personal>();
		this.listEmpresa = new ArrayList<Empresa>();
	}

	public BolsaLaboral getInstance(){//asegurar una instancia de la clase controladora
		if (bolsa==null) {
			bolsa=new BolsaLaboral();
			
		}
		
		return bolsa;
	}
	
	/*public ArrayList<SolicCentro> getListSolisC() {
		return listSolisC;
	}
	public void setListSolisC(ArrayList<SolicCentro> listSolisC) {
		this.listSolisC = listSolisC;
	}*/
	public ArrayList<Solicitud> getListSollicitudes() {
		return listSolicitudes;
	}
	public void setListSolisP(ArrayList<Solicitud> listSolisP) {
		this.listSolicitudes = listSolicitudes;
	}
	public ArrayList<Personal> getListPersonal() {
		return listPersonal;
	}
	public void setListPersonal(ArrayList<Personal> listPersonal) {
		this.listPersonal = listPersonal;
	}
	public ArrayList<Empresa> getListEmpresa() {
		return listEmpresa;
	}
	public void setListEmpresa(ArrayList<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}
	
///**********************METODOS PARA EMPRESA**************************************************
	
	public void agregarEmpresa(Empresa empresa) {
		listEmpresa.add(empresa);
		
	}
	
	public void modificarEmpresa(Empresa empr) {
		
		for (Empresa laempresa : listEmpresa) {
			
			if (empr.getId().equalsIgnoreCase(laempresa.getId())) {
				laempresa.setNombre(empr.getNombre());
				laempresa.setCorreo(empr.getCorreo());
				laempresa.setTelefono(empr.getTelefono());
				laempresa.setUbicacion(empr.getUbicacion());
			}
			
		}
	}
	
///*****************************METODOS PARA PERSONAL*********************************************
	
	
	public void agregarPersonal(Personal solicitante) {
		
		solicitante.setContratado(false);
		listPersonal.add(solicitante);
		
	}
	
	public int cant_personal_universitario() {
		
		int contador=0;
		for (int i = 0; i < listPersonal.size(); i++) {
			if (listPersonal.get(i) instanceof Universitario) {
				contador++;
			}
			
		}
		return contador;
		
	}
	
public int cant_personal_obrero() {
		
		int contador=0;
		for (int i = 0; i < listPersonal.size(); i++) {
			if (listPersonal.get(i) instanceof Obrero) {
				contador++;
			}
			
		}
		return contador;
		
	}

public int cant_personal_tecnico() {
	
	int contador=0;
	for (int i = 0; i < listPersonal.size(); i++) {
		if (listPersonal.get(i) instanceof Tecnico) {
			contador++;
		}
		
	}
	return contador;
	
}

///*********************METODOS PARA SOLICITUD**********************************
	
	
	public void agregarSolicitud(Solicitud solicitud) {
		listSolicitudes.add(solicitud);
	}
///***********************METODOS PARA MATCHEO**************************************************
	//para obrero
	
	
	public ArrayList<Personal> matching(Solicitud sol){
	ArrayList<Personal>aspirantes=new ArrayList<Personal>();
	
	if (sol instanceof SolicitudUniversitario) {
		for (int i = 0; i < listPersonal.size(); i++) {
			if (listPersonal.get(i) instanceof Universitario) {
				///validar
				aspirantes.add(listPersonal.get(i));
			}
		}
		
	}
	
if (sol instanceof SolicitudObrero) {
	
	for (int i = 0; i < listPersonal.size(); i++) {
		if (listPersonal.get(i) instanceof Obrero) {
			///validar
			aspirantes.add(listPersonal.get(i));
		}
	}
		
	}
	
	
if (sol instanceof SolicitudTecnico) {
	
	for (int i = 0; i < listPersonal.size(); i++) {
		if (listPersonal.get(i) instanceof Tecnico) {
			///validar
			aspirantes.add(listPersonal.get(i));
		}
	}
		
	}
return aspirantes;
	}
	
}