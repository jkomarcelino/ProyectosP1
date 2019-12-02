package logico;

import java.util.ArrayList;

public abstract class Personal {
	protected String nombre;
	protected String apellido;
	protected String sexo;
	protected String nacionalidad;
	protected String id;
	protected int edad;
	protected ArrayList<String>idiomas;
	protected String telefono;
	protected String correo;
	protected boolean vehiciculo;
	protected boolean disp_viajar;//add uml
	protected int aniosExperiencia;//add uml
	protected boolean contratado;
	protected int codigo_persona;
	protected boolean soltero;
	protected String ciudad;

	private static int CODIGO_SIGUIENTE=0;



	//***************************CONSTRUCTOR********************************************************



	///***************************SETTERS Y GETTERS**************************************************************




	public Personal(String nombre, String apellido, String sexo, String nacionalidad, String id, int edad,
			ArrayList<String> idiomas, String telefono, String correo, boolean vehiciculo, boolean disp_viajar,
			int aniosExperiencia, boolean contratado, int codigo_persona, boolean soltero, String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.id = id;
		this.edad = edad;
		this.idiomas = idiomas;
		this.telefono = telefono;
		this.correo = comprobarCorreo(correo);
		this.vehiciculo = vehiciculo;
		this.disp_viajar = disp_viajar;
		this.aniosExperiencia = aniosExperiencia;
		this.contratado = false;

		this.soltero = soltero;
		this.ciudad = ciudad;

		this.codigo_persona = CODIGO_SIGUIENTE;

		CODIGO_SIGUIENTE++;///para que cada vez que se cree una persona sea diferente
	}


	///******************************SETTERS Y GETTERS*******************************************************

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public ArrayList<String> getIdiomas() {
		return idiomas;
	}



	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public boolean isVehiciculo() {
		return vehiciculo;
	}



	public void setVehiciculo(boolean vehiciculo) {
		this.vehiciculo = vehiciculo;
	}



	public boolean isDisp_viajar() {
		return disp_viajar;
	}



	public void setDisp_viajar(boolean disp_viajar) {
		this.disp_viajar = disp_viajar;
	}



	public int getAniosExperiencia() {
		return aniosExperiencia;
	}



	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}



	public boolean isContratado() {
		return contratado;
	}



	public void setContratado(boolean contratado) {
		this.contratado = contratado;
	}



	public int getCodigo_persona() {
		return codigo_persona;
	}



	public void setCodigo_persona(int codigo_persona) {
		this.codigo_persona = codigo_persona;
	}



	public boolean isSoltero() {
		return soltero;
	}



	public void setSoltero(boolean soltero) {
		this.soltero = soltero;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}








	//************************METODOS PARA COMPROBAR ATRIBUTOS**************************************************





	private String comprobarCorreo(String correo) {//comprobar que sea un correo valido
		boolean arroba=false;
		for (int i = 0; i < correo.length(); i++) {

			if (correo.charAt(i)=='@') {
				arroba=true;

			}

		}

		if (arroba) {
			return correo;

		}

		else {
			return "No valido";
		}
	}



}
