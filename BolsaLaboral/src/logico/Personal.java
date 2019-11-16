package logico;

public abstract class Personal {
protected String nombre;
protected String id;
protected int edad;
protected String telefono;
protected String correo;
protected boolean vehiciculo;
protected boolean disp_viajar;//add uml
protected boolean experiencia;//add uml
protected boolean contratado;



//***************************CONSTRUCTOR*************************************************

public Personal(String nombre, String id, int edad, String telefono, String correo, boolean vehiciculo,
		boolean disp_viajar, boolean experiencia,boolean contratado) {
	super();
	this.nombre = nombre;
	this.id = id;
	this.edad = edad;
	this.telefono = telefono;
	this.correo = correo;
	this.vehiciculo = vehiciculo;
	this.disp_viajar = disp_viajar;
	this.experiencia = experiencia;
	this.contratado=contratado;
}


///***************************SETTERS Y GETTERS**************************************************************
public String getNombre() {
	return nombre;
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

public boolean isExperiencia() {
	return experiencia;
}
public void setExperiencia(boolean experiencia) {
	this.experiencia = experiencia;
}

//************************METODOS PARA COMPROBAR ATRIBUTOS**************************************************

private void comprobarCorreo(String correo) {//comprobar que sea un correo valido
	boolean arroba=false;
	for (int i = 0; i < correo.length(); i++) {
		
		if (correo.charAt(i)=='@') {
			arroba=true;
			
		}
		
	}
	
	if (arroba) {
		this.correo=correo;
		
	}
	
	else {
		this.correo="No valido";
	}
}



}
