package logico;

import java.util.ArrayList;



public class BolsaLaboral {
	//private ArrayList<SolicCentro> listSolisC;
	private ArrayList<Solicitud> listSolicitudes;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Empresa> listEmpresa;
	private static BolsaLaboral bolsa=null;
	
	 
	public ArrayList<Solicitud> getListSolicitudes() {
		return listSolicitudes;
	}

	public void setListSolicitudes(ArrayList<Solicitud> listSolicitudes) {
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

	public void agregarEmpresa(Empresa empresa) {
		listEmpresa.add(empresa);
		
	}
	
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
	
	
	
	
///**********************METODOS PARA EMPRESA**************************************************
	
	
	
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
	
	
	public int cantSolicitudesEmpresa(String id) {
		int contador=0;
		
		for (Empresa emp : listEmpresa) {
			if (emp.getId().equalsIgnoreCase(id)) {
				contador++;
				
			}
			
		}
		return contador;
	}
	
	///eliminar una empresa
	public void eliminar_empresa(String id) {
		Empresa empresa_borrar = null;
		for (int i = 0; i < listEmpresa.size(); i++) {
			
			if (listEmpresa.get(i).getId().equalsIgnoreCase(id)) {
				empresa_borrar= listEmpresa.get(i);
				
			}
		}
		
		listEmpresa.remove(empresa_borrar);
		
	}
	
///*****************************METODOS PARA PERSONAL*********************************************
	
	
	public void agregarPersonal(Personal solicitante) {
		
		solicitante.setContratado(false);
		listPersonal.add(solicitante);
		
	}
	
	public Personal buscarPersona(String id) {
		Personal persona = null;
		for (int i = 0; i < listPersonal.size(); i++) {
			if (listPersonal.get(i).getId().equalsIgnoreCase(id)) {
				persona=listPersonal.get(i);
				
			}
		}
		
		return persona;
	}
	
	public void modificarPersonal(Personal persona) {
		for (Personal p : listPersonal) {
			if (p.getId().equalsIgnoreCase(persona.getId())) {
				p.setSoltero(persona.isSoltero());
				p.setCiudad(persona.getCiudad());
				p.setTelefono(persona.getTelefono());
				p.setCorreo(persona.getCorreo());
				p.setIdiomas(persona.getIdiomas());
				p.setVehiciculo(persona.isVehiciculo());
				p.setCiudad(persona.getCiudad());
				p.setDisp_viajar(persona.isDisp_viajar());
				
			}
		}
	}
	
	
	public void eliminar_personal(String id) {
		Personal persona_borrar=null;
	
		for (int i = 0; i < listPersonal.size(); i++) {
			
			if (listPersonal.get(i).getId().equalsIgnoreCase(id)) {
				persona_borrar= listPersonal.get(i);
				
			}
		}
		
		listPersonal.remove(persona_borrar);
		
	}

	
	
//AGREGAR CONTEO DE PERSONAL POR TIPO
	
	
	
	
	
///cantidad de personas contratadas
public int cant_contratados() {
	
	int contador = 0;
	
	for (Personal per : listPersonal) {
		if (per.isContratado()) {
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
	
	
	///validacion
	
	
	public boolean validacion(Personal solicitante, Solicitud sol) {
		
		boolean validado = false;
		
		if (solicitante.contratado == false) {
			if (solicitante.isVehiciculo() == sol.isVehiculo()) {
				if (solicitante.isDisp_viajar() == sol.isDisp_viajar()) {
						if (solicitante.getAniosExperiencia() >= sol.getMin_anios_exp()) {
							if (solicitante.getEdad()>= sol.getEdad_minima()) {
								//agregar idiomas
									validado=true;
							}

						}

					
				}
			}
		}

		return validado;
	}
	
	
}