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

private static int CODIGO_SIGUIENTE=0;



//***************************CONSTRUCTOR********************************************************



///***************************SETTERS Y GETTERS**************************************************************
public String getNombre() {
	return nombre;
}



public Personal(String nombre, String apellido, String sexo, String nacionalidad, String id, int edad,
		ArrayList<String> idiomas, String telefono, String correo, boolean vehiciculo, boolean disp_viajar,
		int aniosExperiencia, boolean contratado, int codigo_persona) {
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
	this.contratado = contratado;
	this.codigo_persona = CODIGO_SIGUIENTE;
	
	CODIGO_SIGUIENTE++;///para que cada vez que se cree una persona sea diferente
}



public void setNombre(String nombre) {
	this.nombre = nombre;
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

public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}



public ArrayList<String> getIdiomas() {
	return idiomas;
}


public void setIdiomas(ArrayList<String> idiomas) {
	this.idiomas = idiomas;
}


public String getCorreo() {
	return correo;
}


public void setCorreo(String correo) {
	this.correo = correo;
}


public int getAniosExperiencia() {
	return aniosExperiencia;
}


public void setAniosExperiencia(int aniosExperiencia) {
	this.aniosExperiencia = aniosExperiencia;
}


public void setContratado(boolean contratado) {
	this.contratado = contratado;
}
public boolean isContratado() {
	return contratado;
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
