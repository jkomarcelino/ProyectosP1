package logico;

import java.util.ArrayList;

public class BolsaLaboral {
	private ArrayList<SolicCentro> listSolisC;
	private ArrayList<SolicPerson> listSolisP;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Empresa> listEmpresa;
	private static BolsaLaboral bolsa=null;
	
	 
	
	
	public BolsaLaboral() {
		super();
		this.listSolisC = listSolisC;
		this.listSolisP = listSolisP;
		this.listPersonal = listPersonal;
		this.listEmpresa = listEmpresa;
	}

	public BolsaLaboral getInstance(){//asegurar una instancia de la clase controladora
		if (bolsa==null) {
			bolsa=new BolsaLaboral();
			
		}
		
		return bolsa;
	}
	
	public ArrayList<SolicCentro> getListSolisC() {
		return listSolisC;
	}
	public void setListSolisC(ArrayList<SolicCentro> listSolisC) {
		this.listSolisC = listSolisC;
	}
	public ArrayList<SolicPerson> getListSolisP() {
		return listSolisP;
	}
	public void setListSolisP(ArrayList<SolicPerson> listSolisP) {
		this.listSolisP = listSolisP;
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
	
///*****************************METODOS PARA PERSONAL*********************************************
	
	
	public void agrgregarPersonal(Personal solicitante) {
		
		solicitante.setContratado(false);
		listPersonal.add(solicitante);
		
	}
	
///***********************METODOS PARA MATCHEO**************************************************
	
	
	
}