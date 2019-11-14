package logico;

import java.util.ArrayList;

public class BolsaLaboral {
	private ArrayList<SolicCentro> listSolisC;
	private ArrayList<SolicPerson> listSolisP;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Empresa> listEmpresa;
	
	
	public BolsaLaboral(ArrayList<SolicCentro> listSolisC, ArrayList<SolicPerson> listSolisP,
			ArrayList<Personal> listPersonal, ArrayList<Empresa> listEmpresa) {
		super();
		this.listSolisC = listSolisC;
		this.listSolisP = listSolisP;
		this.listPersonal = listPersonal;
		this.listEmpresa = listEmpresa;
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
	
///**********************FUNCIONES PARA EMPRESA*********************************************
	
}