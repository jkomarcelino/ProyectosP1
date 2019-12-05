package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BolsaLaboral implements Serializable {
	/*
	 * private ArrayList<Solicitud> listSolicitudes; private ArrayList<Personal>
	 * listPersonal; private ArrayList<Empresa> listEmpresa; private String archivo
	 * = "BolsaLaboral.dat"; private static BolsaLaboral bolsa=null; borrar
	 * 
	 * public ArrayList<Solicitud> getListSolicitudes() { return listSolicitudes; }
	 * public void setListSolicitudes(ArrayList<Solicitud> listSolicitudes) {
	 * this.listSolicitudes = listSolicitudes; } public ArrayList<Personal>
	 * getListPersonal() { return listPersonal; } public void
	 * setListPersonal(ArrayList<Personal> listPersonal) { this.listPersonal =
	 * listPersonal; } public ArrayList<Empresa> getListEmpresa() { return
	 * listEmpresa; } public void setListEmpresa(ArrayList<Empresa> listEmpresa) {
	 * this.listEmpresa = listEmpresa; } public void agregarEmpresa(Empresa empresa)
	 * { listEmpresa.add(empresa);
	 * 
	 * }
	 * 
	 * public BolsaLaboral() { super(); //bolsa null this.listSolicitudes = new
	 * ArrayList<Solicitud>(); this.listPersonal = new ArrayList<Personal>();
	 * this.listEmpresa = new ArrayList<Empresa>(); } public static BolsaLaboral
	 * getInstance(){//asegurar una instancia de la clase controladora if
	 * (bolsa==null) { bolsa=new BolsaLaboral();
	 * 
	 * }
	 * 
	 * return bolsa; }
	 * 
	 * 
	 * 
	 * 
	 * ///**********************METODOS PARA
	 * EMPRESA**************************************************
	 * 
	 * 
	 * 
	 * public void modificarEmpresa(Empresa empr) {//recibe un objeto empresa y lo
	 * busca en en lso id de lalistempresa
	 * 
	 * for (Empresa laempresa : listEmpresa) {
	 * 
	 * if (empr.getId().equalsIgnoreCase(laempresa.getId())) {
	 * laempresa.setNombre(empr.getNombre()); laempresa.setCorreo(empr.getCorreo());
	 * laempresa.setTelefono(empr.getTelefono());
	 * laempresa.setUbicacion(empr.getUbicacion());
	 * 
	 * //aqui se hizo el cambio }
	 * 
	 * } }
	 * 
	 * 
	 * public int cantSolicitudesEmpresa(String id) {//buscar la cant de solicitudes
	 * realizadas por una empresa int contador=0;
	 * 
	 * for (Empresa emp : listEmpresa) { if (emp.getId().equalsIgnoreCase(id)) {
	 * contador++;
	 * 
	 * }
	 * 
	 * } return contador; }
	 * 
	 * ///eliminar una empresa public void eliminar_empresa(String id) { Empresa
	 * empresa_borrar = null; for (int i = 0; i < listEmpresa.size(); i++) {
	 * 
	 * if (listEmpresa.get(i).getId().equalsIgnoreCase(id)) { empresa_borrar=
	 * listEmpresa.get(i);
	 * 
	 * } }
	 * 
	 * listEmpresa.remove(empresa_borrar);
	 * 
	 * }
	 * 
	 * public Empresa buscarempresa(String id) {//encuentra una empresa y la retorna
	 * dando un id de empresa Empresa emp_aux=null; int i=0; boolean
	 * encontrado=false; while (!encontrado || i<listEmpresa.size()) { if
	 * (listEmpresa.get(i).getId().equalsIgnoreCase(id)) {
	 * emp_aux=listEmpresa.get(i); encontrado=true;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return emp_aux; } ///*****************************METODOS PARA
	 * PERSONAL*********************************************
	 * 
	 * 
	 * public void agregarPersonal(Personal solicitante) {
	 * 
	 * solicitante.setContratado(false); listPersonal.add(solicitante);
	 * 
	 * }
	 * 
	 * public Personal buscarPersonal(String id) { Personal persona = null; for (int
	 * i = 0; i < listPersonal.size(); i++) { if
	 * (listPersonal.get(i).getId().equalsIgnoreCase(id)) {
	 * persona=listPersonal.get(i);
	 * 
	 * } }
	 * 
	 * return persona; }
	 * 
	 * public void modificarPersonal(Personal persona) { for (Personal p :
	 * listPersonal) { if (p.getId().equalsIgnoreCase(persona.getId())) {
	 * p.setSoltero(persona.isSoltero()); p.setCiudad(persona.getCiudad());
	 * p.setTelefono(persona.getTelefono()); p.setCorreo(persona.getCorreo());
	 * p.setIdiomas(persona.getIdiomas()); p.setVehiciculo(persona.isVehiciculo());
	 * p.setCiudad(persona.getCiudad()); p.setDisp_viajar(persona.isDisp_viajar());
	 * 
	 * } } }
	 * 
	 * 
	 * public void eliminar_personal(String id) { Personal persona_borrar=null;
	 * 
	 * for (int i = 0; i < listPersonal.size(); i++) {
	 * 
	 * if (listPersonal.get(i).getId().equalsIgnoreCase(id)) { persona_borrar=
	 * listPersonal.get(i);
	 * 
	 * } }
	 * 
	 * listPersonal.remove(persona_borrar);
	 * 
	 * }
	 * 
	 * 
	 * //AGREGAR CONTEO DE PERSONAL POR TIPO public int
	 * cant_personal_universitario() {
	 * 
	 * int contador=0; for (int i = 0; i < listPersonal.size(); i++) { if
	 * (listPersonal.get(i) instanceof Universitario) { contador++; }
	 * 
	 * } return contador;
	 * 
	 * }
	 * 
	 * public int cant_personal_obrero() {
	 * 
	 * int contador=0; for (int i = 0; i < listPersonal.size(); i++) { if
	 * (listPersonal.get(i) instanceof Obrero) { contador++; }
	 * 
	 * } return contador;
	 * 
	 * } public int cant_personal_tecnico() {
	 * 
	 * int contador=0; for (int i = 0; i < listPersonal.size(); i++) { if
	 * (listPersonal.get(i) instanceof Tecnico) { contador++; }
	 * 
	 * } return contador;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * ///cantidad de personas contratadas public int cant_contratados() {
	 * 
	 * int contador = 0;
	 * 
	 * for (Personal per : listPersonal) { if (per.isContratado()) { contador++; } }
	 * return contador; } //Para contratar public void contratarPersonal(Solicitud
	 * sol, ArrayList<Personal> personal) { Empresa empresa = sol.getEmpresa(); for
	 * (Personal per : personal) {
	 * 
	 * empresa.agregarContratado(per); } } ///*********************METODOS PARA
	 * SOLICITUD**********************************
	 * 
	 * 
	 * public void agregarSolicitud(Solicitud solicitud) {
	 * listSolicitudes.add(solicitud); }
	 * 
	 * public boolean buscarSolicitud(Solicitud sol) { boolean encontrado=false;
	 * 
	 * if(listSolicitudes.contains(sol)) { encontrado=true; } return encontrado; }
	 * ///***********************METODOS PARA
	 * MATCHEO************************************************** //para obrero
	 * 
	 * 
	 * public ArrayList<Personal> matching(Solicitud sol){
	 * ArrayList<Personal>aspirante=new ArrayList<Personal>();
	 * 
	 * if (sol instanceof SolicitudUniversitario) { for (int i = 0; i <
	 * listPersonal.size(); i++) { if (listPersonal.get(i) instanceof Universitario)
	 * { ///validar if (validacion(listPersonal.get(i),sol)) { if
	 * (validar_universitario(listPersonal.get(i),sol)) {
	 * aspirante.add(listPersonal.get(i));
	 * 
	 * } }
	 * 
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * if (sol instanceof SolicitudObrero) {
	 * 
	 * for (int i = 0; i < listPersonal.size(); i++) { if (listPersonal.get(i)
	 * instanceof Obrero) { ///validar if (validacion(listPersonal.get(i),sol)) { if
	 * (validar_obrero(listPersonal.get(i),sol)) {
	 * aspirante.add(listPersonal.get(i));
	 * 
	 * } }
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * 
	 * if (sol instanceof SolicitudTecnico) {
	 * 
	 * for (int i = 0; i < listPersonal.size(); i++) { if (listPersonal.get(i)
	 * instanceof Tecnico) { ///validar if (validacion(listPersonal.get(i),sol)) {
	 * if (validar_obrero(listPersonal.get(i),sol)) {
	 * aspirante.add(listPersonal.get(i));
	 * 
	 * } }
	 * 
	 * } }
	 * 
	 * } return aspirante; }
	 * 
	 * public boolean validarEmail(String email) { Pattern patt = Pattern.compile(
	 * "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	 * Matcher match = patt.matcher(email); if (!match.find()) { return true; } else
	 * { return false; } }
	 * 
	 * ///validacion
	 * 
	 * 
	 * public boolean validacion(Personal solicitante, Solicitud sol) {
	 * 
	 * boolean validado = false;
	 * 
	 * if (solicitante.contratado == false) { if (solicitante.isVehiciculo() ==
	 * sol.isVehiculo()) { if (solicitante.isDisp_viajar() == sol.isDisp_viajar()) {
	 * if (solicitante.getAniosExperiencia() >= sol.getMin_anios_exp()) { if
	 * (solicitante.getEdad()>= sol.getEdad_minima()) { //agregar idiomas
	 * validado=true; } }
	 * 
	 * } } } return validado; }
	 * 
	 * //Validaciones
	 * 
	 * private boolean validar_obrero(Personal persona, Solicitud soli) { boolean
	 * valido=false; for (String skills : ((SolicitudObrero)soli).getSkills()) { if
	 * (((Obrero)persona).getSkills().contains(skills)) { valido=true;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return valido; }
	 * 
	 * //valida el obrero private boolean validar_tecnico(Personal persona,
	 * Solicitud sol) { boolean valido = false; if (((Tecnico)
	 * persona).getArea().equalsIgnoreCase(((SolicitudTecnico) sol).getArea())) {
	 * valido = true; } return valido; }
	 * 
	 * //valida el universitario
	 * 
	 * private boolean validar_universitario(Personal persona, Solicitud sol) {
	 * boolean validar = false; if (((Universitario)
	 * persona).getProfesion().equalsIgnoreCase(((SolicitudUniversitario)
	 * sol).getProfesion())) { validar = true;
	 * 
	 * } return validar; }
	 * 
	 * /////**********************ESCRIBIR
	 * FICHEROS*************************************************
	 * 
	 * 
	 * public void writeBolsa() { FileOutputStream bolsaFile = null;
	 * ObjectOutputStream bolsaOut = null; try { bolsaFile = new
	 * FileOutputStream(archivo); } catch (FileNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } try { bolsaOut = new
	 * ObjectOutputStream(bolsaFile); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } try {
	 * bolsaOut.writeObject(bolsa); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } } public void readBolsa() {
	 * FileInputStream bolsaFile = null; ObjectInputStream bolsaIn = null; try {
	 * bolsaFile = new FileInputStream("BolsaLaboral.dat"); bolsaIn = new
	 * ObjectInputStream(bolsaFile); try { bolsa = (BolsaLaboral)
	 * bolsaIn.readObject(); } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 * 
	 * ///*****************Contratados***********************************
	 * 
	 * 
	 * // Retornar cant. Universitarios desempleado public int desempleadoU() { int
	 * cant = 0; for (Personal soli : listPersonal) { if (!soli.isContratado()) { if
	 * (soli instanceof Universitario) { cant++; } } } return cant; } // Retornar
	 * cant. Tecnicos desempleado public int desempleadoT() { int cant = 0; for
	 * (Personal soli : listPersonal) { if (!soli.isContratado()) { if (soli
	 * instanceof Tecnico) { cant++; } } } return cant; } // Retornar cant. Obreros
	 * desempleado public int desempleadoO() { int cant = 0; for (Personal soli :
	 * listPersonal) { if (!soli.isContratado()) { if (soli instanceof Obrero) {
	 * cant++; } } } return cant; }
	 * 
	 * // Retorna % de Obreros Contratados public float porcientoO() { float cant =
	 * 0; float porciento = 0; float total = totalContratado(); for (Personal soli :
	 * listPersonal) { if (soli instanceof Obrero) { if (soli.isContratado()) {
	 * cant++; } } } if (total != 0) { porciento = (cant / total) * 100; } return
	 * porciento; } // Retorna % de Universitarios Contratados public float
	 * porcientoU() { float cant = 0; float porciento = 0; float total =
	 * totalContratado(); for (Personal soli : listPersonal) { if (soli instanceof
	 * Universitario) { if (soli.isContratado()) { cant++; } } } if (total != 0) {
	 * porciento = (cant / total) * 100; } return porciento; } // Retorna % de
	 * Tecnicos Contratados public float porcientoT() { float cant = 0; float
	 * porciento = 0; float total = totalContratado(); for (Personal soli :
	 * listPersonal) { if (soli instanceof Tecnico) { if (soli.isContratado()) {
	 * cant++; } } } if (total != 0) { porciento = (cant / total) * 100; } return
	 * porciento; }
	 * 
	 * // Retorna total de contratados public int totalContratado() { int cant = 0;
	 * for (Personal soli : listPersonal) { if (soli.isContratado()) { cant++; } }
	 * return cant; }
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Personal> misSolicitantes;
	private ArrayList<Empresa> misEmpresas;
	private ArrayList<Solicitud> misSolicitudes;
	
	private FileWriter writer_1;
	private String archivo = "BolsaLaboral.dat";
	private static BolsaLaboral bolsa;

//*************************CONSTRUCTOR******************************************************
	public BolsaLaboral() {
		super();
		this.bolsa = null;
		this.misEmpresas = new ArrayList<>();
		this.misSolicitantes = new ArrayList<>();
		this.misSolicitudes = new ArrayList<>();

	}
	
//**********************SETTERS Y GETTERS************************************************************************

	public ArrayList<Empresa> getMisEmpresas() {
		return misEmpresas;
	}

	public ArrayList<Personal> getMisPersonas() {
		return misSolicitantes;
	}

	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public static BolsaLaboral getInstance() {
		if (bolsa == null) {
			bolsa = new BolsaLaboral();
		}
		return bolsa;

	}

	

//########################**************EMPRESA***************########################################################

	
	public int CantTCon(String rnc) {// Devuelve la cantidad de Tecnicos que contrato una empresa
		int CantconT = 0;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				for (Personal soli : empresa.getMisContratados()) {
					if (soli instanceof Tecnico) {
						CantconT++;
					}
				}
			}
		}
		return CantconT;
	}

	public void insertEmpresa(Empresa empresa) {
		misEmpresas.add(empresa);
	}

	
	
	public Empresa RetornarEmpresa(String RNC) {// Retornar una Empresa pasando un RNC
		Empresa miEmpresa = null;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(RNC)) {
				miEmpresa = empresa;
			}

		}
		return miEmpresa;
	}

	
	public void eliminarEmpresa(String cod) {//Elimina una empresa pasandole el codigo
		Empresa empresaeliminar = null;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(cod)) {
				empresaeliminar = empresa;
			}
		}
		misEmpresas.remove(empresaeliminar);
	}

	public void modificaEmpresa(Empresa empresa) {//Modifica una empresa que se reciba

		for (Empresa miempresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(miempresa.getRNC())) {
				miempresa.setArea(empresa.getArea());
				miempresa.setNombre(empresa.getNombre());
				miempresa.setDireccion(empresa.getDireccion());
				miempresa.setEmail(empresa.getEmail());
				miempresa.setTelefono(empresa.getRNC());
			}
		}
	}

	
	public boolean EmpresaExiste(String rnc) {//Devuelve un boolean de si existe una empresa pasando RNC
		boolean existe = false;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				existe = true;
			}
		}
		return existe;

	}

//########################**************PERSONAL***************########################################################

	public void insertSolicitante(Personal pSolicitante) {//inserta un solicitante a al arreglo de solicitantes
		
		String code = getCodeSolicitante();
		pSolicitante.setCodigo(code);
		pSolicitante.setContratado(false);
		misSolicitantes.add(pSolicitante);
		
	}

	public boolean buscarSolicitante(Personal pSolicitante) {//devuelve un boolean de si existe un solicitante
		
		boolean find = false;
		if (misSolicitantes.contains(pSolicitante)) {
			find = true;
		}
		return find;
		
	}

	

	
	public Personal retornarSolicitante(String cedula) {// Retornar Solicitante dando una cedula
		
		Personal solicitante = null;
		for (Personal soli : misSolicitantes) {
			if (soli.getCedula().equalsIgnoreCase(cedula))
				solicitante = soli;
		}

		return solicitante;
	}

	
	public void updateSolicitante(Personal soli) {// Modificar un solicitante
		
		for (Personal solis : misSolicitantes) {
			if (solis.getCedula().equalsIgnoreCase(soli.getCedula())) {
				solis.setEstadoCivil(soli.getEstadoCivil());
				solis.setCategoriaLicencia(soli.getCategoriaLicencia());
				solis.setProvincia(soli.getProvincia());
				solis.setTelefono(soli.getTelefono());
				solis.setEmail(soli.getEmail());
				solis.setIdiomas(soli.getIdiomas());
				solis.setVehiculoPropio(soli.isVehiculoPropio());
				solis.setCalle(soli.getCalle());
				solis.setCiudad(soli.getCiudad());
				solis.setSector(soli.getSector());
				solis.setReferencia(soli.getReferencia());
				solis.setNumeroCasa(soli.getNumeroCasa());
			}
		}
	}

	
	public int indexSolicitante(String code) {// Retornar indice el arraylist del Solicitate
		
		int index = 0;
		for (int i = 0; i < misSolicitantes.size(); i++) {
			if (misSolicitantes.get(i).getCodigo().equalsIgnoreCase(code)) {
				index = i;
			}
		}
		return index;
	}

	

		public Personal BuscarSoliCedula(String Cedula) {// buscar solicitante por cedula
			Personal solicitante = null;
			for (Personal soli : misSolicitantes) {
				if (soli.getCedula().equalsIgnoreCase(Cedula)) {
					solicitante = soli;
				}

			}
			return solicitante;
		}

		
		public boolean SolicitanteExiste(String cedula) {// retorna si existe un solicitante
			boolean existe = false;
			for (Personal solicitante : misSolicitantes) {

				if (solicitante.getCedula().equalsIgnoreCase(cedula)) {
					existe = true;
				}
			}
			return existe;
		}
	public void eliminarSolicitante(Personal persona) {// Elimianr solicitante por codigo
		
		int index = indexSolicitante(persona.getCodigo());
		misSolicitantes.remove(index);
	}

	
	public void contratarCandidatos(Solicitud solicitud, ArrayList<Personal> empleados) {// Contratar Candidatos
		
		Empresa empresa = solicitud.getEmpresa();
		for (Personal solicitante : empleados) {
			solicitud.IncreasedCantReal();
			empresa.insertContratado(solicitante);
		}

	}

	
	public void removerContratados(ArrayList<Personal> misContratados) {// Quitar las solicitudes de los contratados

		for (Personal contratado : misContratados) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante.isContratado() == false) {
					if (contratado.getCedula().equalsIgnoreCase(solicitante.getCedula())) {
						misSolicitantes.remove(solicitante);
					}
				}
			}
		}
	}

	
	public String tipoSolicitante(Personal soli) {// retorna el tipo de solicitante
		String solici = null;

		if (soli instanceof Obrero) {
			solici = "Obrero";

		}
		if (soli instanceof Universitario) {
			solici = "Universitario";

		}
		if (soli instanceof Tecnico) {
			solici = "Tecnico";

		}

		return solici;

	}

	

	public String contradato(Personal soli) {// retorna un boolean si esta contratado o no
		String estado = null;
		if (soli.isContratado()) {
			estado = "Contratado";

		} else {
			estado = "Desempleado";
		}
		return estado;
	}

//########################**************SOLICITUD***************########################################################

	public void insertSolicitud(Solicitud pSolicitud) {//Agregar una solicitud al arraylist
		String code = getCodeSolicitud();
		pSolicitud.setCodigo(code);
		misSolicitudes.add(pSolicitud);
	}

	
	

	
	public boolean buscarSolicitud(Solicitud pSolicitud) {//DEVUELVE UN BOOLEAN SI LA SOLICITUD EXISTE O NO
		boolean find = false;
		if (misSolicitudes.contains(pSolicitud)) {
			find = true;
		}
		return find;
	}

	
	public int cantSoliO(String rnc) {// Retorna cantidad de solicitudes de obreros por una empresa
		int cantO = 0;
		Empresa miEm = RetornarEmpresa(rnc);
		for (Solicitud soli : misSolicitudes) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli instanceof SolicitudObrero) {
					cantO++;
				}
			}
		}
		return cantO;
	}

	
	public int cantSoliU(String rnc) {// Retorna cantidad de solicitudes de Universitarios por una empresa
		int cantU = 0;
		for (Solicitud soli : misSolicitudes) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli instanceof SolicitudUniversitario) {
					cantU++;
				}
			}
		}
		return cantU;
	}

	
	public int cantSoliT(String rnc) {// Retorna cantidad de solicitudes de tecnicos  por una empresa
		int cantT = 0;

		for (Solicitud soli : misSolicitudes) {
			if (soli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {

				if (soli instanceof SolicitudTecnico) {
					cantT++;
				}
			}
		}
		return cantT;
	}

	public int CantOCon(String rnc) {//retorna la cantidad de Obreros que contrato una empresa determinada
		int CantconO = 0;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				for (Personal soli : empresa.getMisContratados()) {
					if (soli instanceof Obrero) {
						CantconO++;
					}
				}
			}
		}
		return CantconO;
	}
	
	
		
		public int CantUCon(String rnc) {// retorna la cantidad de Universitaarios que contrato una empresa
			int CantconU = 0;
			for (Empresa empresa : misEmpresas) {
				if (empresa.getRNC().equalsIgnoreCase(rnc)) {
					for (Personal soli : empresa.getMisContratados()) {
						if (soli instanceof Universitario) {
							CantconU++;
						}
					}
				}
			}
			return CantconU;
		}
		
		
	
	public Solicitud RetornarSolocitudCod(String codigo) {// Retornar Solicitud pansando su codigo
		Solicitud miSolicitud = null;
		for (Solicitud solicitud : misSolicitudes) {
			if (solicitud.getCodigo().equalsIgnoreCase(codigo)) {
				miSolicitud = solicitud;
			}

		}
		return miSolicitud;
	}

	
	

	

	

	
	public int cantidadSolicitante(Personal soli) {// retorna cantidad de solicitudes del solicitane
		int cant = 0;
		for (Personal misoli : misSolicitantes) {
			if (soli.getCedula().equalsIgnoreCase(misoli.getCedula())) {
				cant++;
			}

		}
		return cant;

	}

	

	public ArrayList<Solicitud> RetornaSolicitudEmp(Empresa emp) {// Retorna todas las solicitudes de una empresa
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		for (Solicitud solicitud : misSolicitudes) {
			if (solicitud.getEmpresa().getRNC().equalsIgnoreCase(emp.getRNC())) {
				solicitudes.add(solicitud);
			}

		}
		return solicitudes;
	}

	

	public boolean EliminarSolicitud(String codigo) {//borra un solicitud pasando su codigo
		boolean eliminar = false;
		Solicitud SolicitudEliminar = null;
		for (Solicitud soli : misSolicitudes) {
			if (soli.getCodigo().equalsIgnoreCase(codigo)) {
				SolicitudEliminar = soli;
				eliminar = true;
			}

		}
		misSolicitudes.remove(SolicitudEliminar);
		return eliminar;
	}
//########################**************MACHING Y VALIDACION***************###############################################################

	
	public boolean validarGeneral(Personal persona, Solicitud solicitud) {//VALIDA AL PERSONAL GENERAL
		int porciento=0;
		boolean valido = false;
		if (persona.contratado == false) {
			porciento++;
			if (persona.isVehiculoPropio() == solicitud.isVehiculoPropio()) {
				porciento++;
				if (persona.isMudarse() == solicitud.isMudarse()) {
					porciento++;
					if (persona.getCategoriaLicencia() >= solicitud.getCategoriaLicencia()) {
						porciento++;
						if (persona.getAnnosExperiencia() >= solicitud.getAnnosExperiencia()) {
							porciento++;
							if ((persona.getEdad() >= solicitud.getEdadMin())
									&& (persona.getEdad() <= solicitud.getEdadMax())) {
								porciento++;
								if (validarIdiomas(persona, solicitud)) {
									porciento++;
									

								}

							}

						}

					}
				}
			}
		}
 if (porciento>=5) {//si se cumple el 70%
	valido = true;
}
 
		return valido;
	}

	// Validacion Obrero con solicitud
	private boolean ValidarObrero(Personal solicitante, Solicitud solicitud) {
		boolean validar = false;
		for (String habilidadObrero : ((SolicitudObrero) solicitud).getHabilidades()) {
			if (((Obrero) solicitante).getHabilidades().contains(habilidadObrero)) {
				validar = true;
			} else {
				validar = false;
				break;
			}
		}

		return validar;
	}

	// Validacion Tecnico con solicitud
	private boolean ValidarTecnico(Personal solicitante, Solicitud soli) {
		boolean validar = false;
		if (((Tecnico) solicitante).getArea().equalsIgnoreCase(((SolicitudTecnico) soli).getArea())) {
			validar = true;
		}
		return validar;
	}

	// Validacion Universitario con solicitud
	private boolean validarUniversitario(Personal solicitante, Solicitud soli) {
		boolean validar = false;
		if (((Universitario) solicitante).getCarrera().equalsIgnoreCase(((SolicitudUniversitario) soli).getCarrera())) {
			validar = true;
			if (!((Universitario) solicitante).isPostGrado() && ((SolicitudUniversitario) soli).isPostGrado()) {
				validar = false;
			}

		}
		return validar;
	}

	
	public boolean validarIdiomas(Personal persona, Solicitud soli) {// Validar Idiomas
		boolean aux = false;
		if (soli.idiomas.size() == 0) {
			aux = true;
		}
		for (String idiomas : soli.getIdiomas()) {
			if (persona.getIdiomas().contains(idiomas)) {
				aux = true;
			} else {
				aux = false;
				break;

			}
		}

		return aux;
	}

	// validacion de Email
	public boolean validarEmail(String email) {
		Pattern patt = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher match = patt.matcher(email);
		if (!match.find()) {
			return true;
		} else {
			return false;
		}
	}

	//MATCHEO
	public ArrayList<Personal> matcheo(Solicitud soli) {

		ArrayList<Personal> candidato = new ArrayList<>();
		if (soli instanceof SolicitudObrero) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante instanceof Obrero) {
					if (validarGeneral(solicitante, soli)) {
						if (ValidarObrero(solicitante, soli)) {
							candidato.add(solicitante);
							/*
							 * soli.getEmpresa().insertContratado(solicitante); Crear una funcion qune
							 * inserte los contradado y sea llamada desde el boton: Contratar Solicitante
							 */

						}
					}
				}
			}

		}

		if (soli instanceof SolicitudTecnico) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante instanceof Tecnico) {
					if (validarGeneral(solicitante, soli)) {
						if (ValidarTecnico(solicitante, soli)) {
							candidato.add(solicitante);
							/*
							 * soli.getEmpresa().insertContratado(solicitante); Crear una funcion qune
							 * inserte los contradado y sea llamada desde el boton: Contratar Solicitante
							 */
						}

					}
				}
			}
		}
		if (soli instanceof SolicitudUniversitario) {
			for (Personal solicitante : misSolicitantes) {
				if (solicitante instanceof Universitario) {
					if (validarGeneral(solicitante, soli)) {
						if (validarUniversitario(solicitante, soli)) {
							candidato.add(solicitante);
							/*
							 * soli.getEmpresa().insertContratado(solicitante); Crear una funcion qune
							 * inserte los contradado y sea llamada desde el boton: Contratar Solicitante
							 */
						}

					}
				}
			}
		}

		return candidato;
	}

	
	public Empresa RetornaEmpresaSoli(String rnc) {// retorna una solicitud dado el rnc de una empresa
		Empresa empre = null;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				empre = empresa;
			}

		}
		return empre;

	}

	// Actualizar una solicitud cuando se modifica
	public void ActualizarSolicitud(Solicitud modi, Solicitud modificarSoli) {
		int index = 0;
		if (misSolicitudes.contains(modi)) {
			index = misSolicitudes.indexOf(modi);
		}
		misSolicitudes.set(index, modificarSoli);

	}
//########################**************FICHERO***************########################################################		

	public String getCodeSolicitud() {
		String code = "";
		String codigo = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		for (int i = 0; i < 3;) {
			char c = (char) r.nextInt(225);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				code += c;
				i++;
			}

		}
		codigo = "SO" + code;
		return codigo;
	}

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

//########################**************CONTEOS Y PORCIENTOS***************########################################################		

	
	
public int cantSolicitudes(String RNC) {//Retorna la cantidad de solicitudes por una empresa
		
		int cant = 0;
		for (Empresa empresa : misEmpresas) {
			if (empresa.getRNC().equalsIgnoreCase(RNC)) {
				cant++;
			}
		}
		return cant;
	}


public int cantSolicitanteUniversitario() {//devuelve cantidad de solicitantes universitarios
		
		int cant = 0;
		for (Personal solicitante : misSolicitantes) {
			if (solicitante instanceof Universitario) {
				cant++;
			}
		}

		return cant;
	}

	public int cantSolicitanteTecnico() {//devuelve cantidad de solicitantes tecnicos
		
		int cant = 0;
		for (Personal solicitante : misSolicitantes) {
			if (solicitante instanceof Tecnico) {
				cant++;
			}
		}

		return cant;
	}

	public int cantSolicitanteObrero() {//devuelve cantidad de solicitantes obreros
		
		int cant = 0;
		for (Personal solicitante : misSolicitantes) {
			if (solicitante instanceof Obrero) {
				cant++;
			}
		}

		return cant;
	}
	
	public float porcientoU() {// Retorna % de Universitarios Contratados
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Universitario) {
				if (soli.isContratado()) {
					cant++;
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}

	
	public float porcientoT() {// Retorna % de Tecnicos Contratados
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Tecnico) {
				if (soli.isContratado()) {
					cant++;
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}

	
	public int totalContratado() {// Retorna total de contratados
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (soli.isContratado()) {
				cant++;
			}
		}
		return cant;
	}

	
	public float porcientoSolicitud(Solicitud soli) {//RETORNA EL PORCIENTO DE LAS SOLICITUDES ACTIVAS
		float por = 0;
		if (soli.getCantReal() != soli.cantVacantes) {
			float cantTotal = soli.getCantVacantes();
			float cantActual = soli.getCantReal();
			por = (cantActual / cantTotal) * 100;
		} else {
			por = 100;
		}
		return por;
	}

	
	public int desempleadoU() {// Retornar cant. Universitarios desempleado
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (!soli.isContratado()) {
				if (soli instanceof Universitario) {
					cant++;
				}
			}
		}
		return cant;
	}

	
	public int desempleadoT() {// Retornar cant. Tecnicos desempleado
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (!soli.isContratado()) {
				if (soli instanceof Tecnico) {
					cant++;
				}
			}
		}
		return cant;
	}

	
	public int desempleadoO() {// Retornar cant. Obreros desempleado
		int cant = 0;
		for (Personal soli : misSolicitantes) {
			if (!soli.isContratado()) {
				if (soli instanceof Obrero) {
					cant++;
				}
			}
		}
		return cant;
	}

	//////////////// PARA LOS GENEROS
	
	
	
	//...................MASCULINO
	
	
	public float porcientoF() {// Retorna % de Obreros femeninos Contratado
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Obrero) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Femenino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Universitario) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Femenino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Tecnico) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Femenino")) {
						cant++;
					}
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}
	
	
///..................MASCULINO
	
	public float porcientoH() {//retorna el % de masculino
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Obrero) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Masculino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Universitario) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Masculino")) {
						cant++;
					}
				}
			}
			if (soli instanceof Tecnico) {
				if (soli.isContratado()) {
					if (soli.sexo.equalsIgnoreCase("Masculino")) {
						cant++;
					}
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}

	
	public float porcientoO() {// Retorna % de Obreros Contratados
		float cant = 0;
		float porciento = 0;
		float total = totalContratado();
		for (Personal soli : misSolicitantes) {
			if (soli instanceof Obrero) {
				if (soli.isContratado()) {
					cant++;
				}
			}
		}
		if (total != 0) {
			porciento = (cant / total) * 100;
		}
		return porciento;
	}


	
	
		public String getCodeSolicitante() {// Generacion de Codigos....
			String code = "";
			String codigo = "";
			long milis = new java.util.GregorianCalendar().getTimeInMillis();
			Random r = new Random(milis);
			for (int i = 0; i < 3;) {
				char c = (char) r.nextInt(225);
				if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
					code += c;
					i++;
				}

			}
			codigo = "S" + code;
			return codigo;
		}
		
		
//.................PARA TEXTO
		
		
	
	/*public void writeEmpresaTXT(String rnc) throws IOException {// escribe fichero texto de una empresa
		writer_1 = new FileWriter(new File("Archivo.txt"));
		Empresa soli = RetornaEmpresaSoli(rnc);
		float cant = 0;
		float cot = 0;
		float cantcontratados = 0;
		writer_1.write("***********************************************************************************" + "\n");
		writer_1.write("*                               Bolsa Laboral                                     *" + "\n");
		writer_1.write("*                                   Empresa                                       *" + "\n");
		writer_1.write("***********************************************************************************" + "\n");
		writer_1.write("Empresa:                " + soli.getNombre() + "\n");
		for (Solicitud misoli : misSolicitudes) {
			if (misoli.getEmpresa().getRNC().equalsIgnoreCase(rnc)) {
				cant = misoli.getCantVacantes();
				cantcontratados = misoli.getCantReal();
				cot++;
			}

		}
		writer_1.write("Cantidad Vacantes inicial: " + cant + "\n");
		writer_1.write("Cantidad Vacantes real:    " + cantcontratados + "\n");
		writer_1.write("Cantidad Solicitudes       " + cot + "\n");
		writer_1.write("***********************************************************************************" + "\n");
		writer_1.close();

	}*/

/*	public void writeSolicitanteTXT(String cedula) throws IOException {
		writer_1 = new FileWriter(new File("Archivo.txt"));
		Personal soli = BuscarSoliCedula(cedula);
		writer_1.write("***********************************************************************************" + "\n");
		writer_1.write("*                               Bolsa Laboral                                     *" + "\n");
		writer_1.write("*                                 Empleado                                        *" + "\n");
		writer_1.write("***********************************************************************************" + "\n");
		writer_1.write("Nombres:                 " + soli.getNombres() + "\n");
		writer_1.write("Apellidos:               " + soli.getApellidos() + "\n");
		writer_1.write("Tipo Solicitante:        " + tipoSolicitante(soli) + "\n");
		writer_1.write("Estado:                  " + contradato(soli) + "\n");
		writer_1.write("Cantidad de Solicitudes: " + cantidadSolicitante(soli) + "\n");
		writer_1.write("***********************************************************************************" + "\n");
		writer_1.close();

	}*/

}