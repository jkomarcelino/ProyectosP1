package logico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logica.Obrero;
import logica.Solicitante;
import logica.Solicitud;
import logica.Tecnico;
import logica.Universitario;



public class BolsaLaboral implements  Serializable{
	
	private ArrayList<Solicitud> listSolicitudes;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Empresa> listEmpresa;
	private String archivo = "BolsaLaboral.dat";
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

	public static BolsaLaboral getInstance(){//asegurar una instancia de la clase controladora
		if (bolsa==null) {
			bolsa=new BolsaLaboral();
			
		}
		
		return bolsa;
	}
	
	
	
	
///**********************METODOS PARA EMPRESA**************************************************
	
	
	
	public void modificarEmpresa(Empresa empr) {//recibe un objeto empresa y lo busca en en lso id de lalistempresa
		
		for (Empresa laempresa : listEmpresa) {
			
			if (empr.getId().equalsIgnoreCase(laempresa.getId())) {
				laempresa.setNombre(empr.getNombre());
				laempresa.setCorreo(empr.getCorreo());
				laempresa.setTelefono(empr.getTelefono());
				laempresa.setUbicacion(empr.getUbicacion());
				
				//aqui se hizo el cambio
			}
			
		}
	}
	
	
	public int cantSolicitudesEmpresa(String id) {//buscar la cant de solicitudes realizadas por una empresa
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
	
	public Empresa buscarempresa(String id) {//encuentra una empresa y la retorna dando un id de empresa
		Empresa emp_aux=null;
		int i=0;
		boolean encontrado=false;
		while (!encontrado || i<listEmpresa.size()) {
			if (listEmpresa.get(i).getId().equalsIgnoreCase(id)) {
				emp_aux=listEmpresa.get(i);
				encontrado=true;
				
			}
			
		}
		
		return emp_aux;
	}
///*****************************METODOS PARA PERSONAL*********************************************
	
	
	public void agregarPersonal(Personal solicitante) {
		
		solicitante.setContratado(false);
		listPersonal.add(solicitante);
		
	}
	
	public Personal buscarPersonal(String id) {
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

//Para contratar

public void contratarPersonal(Solicitud sol, ArrayList<Personal> personal) {
	Empresa empresa = sol.getEmpresa();
	for (Personal per : personal) {
		
		empresa.agregarContratado(per);
	}

}

///*********************METODOS PARA SOLICITUD**********************************
	
	
	public void agregarSolicitud(Solicitud solicitud) {
		listSolicitudes.add(solicitud);
	}
	
	public boolean buscarSolicitud(Solicitud sol) {
		boolean encontrado=false;
		
		if(listSolicitudes.contains(sol)) {
			encontrado=true;
		}
		return encontrado;
	}
///***********************METODOS PARA MATCHEO**************************************************
	//para obrero
	
	
	public ArrayList<Personal> matching(Solicitud sol){
	ArrayList<Personal>aspirante=new ArrayList<Personal>();
	
	if (sol instanceof SolicitudUniversitario) {
		for (int i = 0; i < listPersonal.size(); i++) {
			if (listPersonal.get(i) instanceof Universitario) {
				///validar
				if (validacion(listPersonal.get(i),sol)) {
					if (validar_universitario(listPersonal.get(i),sol)) {
						aspirante.add(listPersonal.get(i));
					
				}
				}
				
				
			}
		}
		
	}
	
if (sol instanceof SolicitudObrero) {
	
	for (int i = 0; i < listPersonal.size(); i++) {
		if (listPersonal.get(i) instanceof Obrero) {
			///validar
			if (validacion(listPersonal.get(i),sol)) {
				if (validar_obrero(listPersonal.get(i),sol)) {
					aspirante.add(listPersonal.get(i));
				
			}
			}
			
		}
	}
		
	}
	
	
if (sol instanceof SolicitudTecnico) {
	
	for (int i = 0; i < listPersonal.size(); i++) {
		if (listPersonal.get(i) instanceof Tecnico) {
			///validar
			if (validacion(listPersonal.get(i),sol)) {
			if (validar_obrero(listPersonal.get(i),sol)) {
				aspirante.add(listPersonal.get(i));
			
		}
		}
			
		}
	}
		
	}
return aspirante;
	}
	
	public boolean validarEmail(String email) {
		Pattern patt = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher match = patt.matcher(email);
		if (!match.find()) {
			return true;
		} else {
			return false;
		}
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
	
	//Validaciones
	
	private boolean validar_obrero(Personal persona, Solicitud soli) {
		boolean valido=false;
		for (String skills : ((SolicitudObrero)soli).getSkills()) {
			if (((Obrero)persona).getSkills().contains(skills)) {
				valido=true;
				
			}
			
		}
		
		return valido;
	}
	
	//valida el obrero
	private boolean validar_tecnico(Personal persona, Solicitud sol) {
		boolean valido = false;
		if (((Tecnico) persona).getArea().equalsIgnoreCase(((SolicitudTecnico) sol).getArea())) {
			valido = true;
		}
		return valido;
	}
	
	//valida el universitario
	
	private boolean validar_universitario(Personal persona, Solicitud sol) {
		boolean validar = false;
		if (((Universitario) persona).getProfesion().equalsIgnoreCase(((SolicitudUniversitario) sol).getProfesion())) {
			validar = true;
			
		}
		return validar;
	}
	
/////**********************ESCRIBIR FICHEROS*************************************************
	
	
	public void writeBolsa() {
		FileOutputStream bolsaFile = null;
		ObjectOutputStream bolsaOut = null;

		try {
			bolsaFile = new FileOutputStream(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bolsaOut = new ObjectOutputStream(bolsaFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bolsaOut.writeObject(bolsa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readBolsa() {
		FileInputStream bolsaFile = null;
		ObjectInputStream bolsaIn = null;
		try {
			bolsaFile = new FileInputStream("BolsaLaboral.dat");
			bolsaIn = new ObjectInputStream(bolsaFile);
			try {
				bolsa = (BolsaLaboral) bolsaIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}