package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Personal implements Serializable {
	

	///******************************SETTERS Y GETTERS*******************************************************

	private static final long serialVersionUID = 1L;
	protected String codigo;
	protected String cedula;
	protected String nombres;
	protected String apellidos;
	protected String telefono;
	//protected LocalDate fechaNacimiento;
	protected String nacionalidad;
	protected String sexo;
	protected String estadoCivil;
	protected String direccion;
	protected String provincia;
	protected String email;
	protected boolean vehiculoPropio;
	protected int categoriaLicencia;
	protected int annosExperiencia;
	protected ArrayList<String> idiomas;
	protected boolean contratado;
	protected int edad;
	protected boolean mudarse;
	protected String ciudad;
	protected String sector;
	protected String calle;
	protected int numeroCasa;
	protected String referencia;
	protected LocalDate FechaContratado;

	

	public Personal( String cedula, String nombres, String apellidos,int edad, String telefono, String nacionalidad, String sexo, String estadoCivil, String direccion,
			String provincia, String email, boolean vehiculoPropio, int categoriaLicencia, int annosExperiencia,
			ArrayList<String> idiomas, boolean contratado, boolean mudarse, String ciudad, String sector,
			String calle, int numeroCasa, String referencia) {
		super();
		this.edad=edad;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		//this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.direccion = direccion;
		this.provincia = provincia;
		this.email = email;
		this.vehiculoPropio = vehiculoPropio;
		this.categoriaLicencia = categoriaLicencia;
		this.annosExperiencia = annosExperiencia;
		this.idiomas = idiomas;
		this.contratado = contratado;
		this.mudarse = mudarse;
		this.ciudad = ciudad;
		this.sector = sector;
		this.calle = calle;
		this.numeroCasa = numeroCasa;
		this.referencia = referencia;
	}
	

	public LocalDate getFechaContratado() {
		return FechaContratado;
	}


	public void setFechaContratado(LocalDate fechaContratado) {
		FechaContratado = fechaContratado;
	}


	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public boolean isMudarse() {
		return mudarse;
	}

	public void setMudarse(boolean mudarse) {
		this.mudarse = mudarse;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVehiculoPropio() {
		return vehiculoPropio;
	}

	public void setVehiculoPropio(boolean vehiculoPropio) {
		this.vehiculoPropio = vehiculoPropio;
	}

	public int getCategoriaLicencia() {
		return categoriaLicencia;
	}

	public void setCategoriaLicencia(int categoriaLicencia) {
		this.categoriaLicencia = categoriaLicencia;
	}

	public int getAnnosExperiencia() {
		return annosExperiencia;
	}

	public void setAnnosExperiencia(int annosExperiencia) {
		this.annosExperiencia = annosExperiencia;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public boolean isContratado() {
		return contratado;
	}

	public void setContratado(boolean contratado) {
		this.contratado = contratado;
	}

	public long getEdad() {
		
		return edad;
	}

	// creo que este set no es necesaria
	public void setEdad(int edad) {
		this.edad = edad;
	}

	



//*********************Rellenar atributos************************



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
