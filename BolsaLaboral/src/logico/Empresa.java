package logico;

import java.util.ArrayList;

public class Empresa {
	
	private String nombre;
	private String id;
	private String telefono;
	private String correo;
	private String ubicacion;
	private ArrayList<Personal>misContratados;//almacenar aquellos contratos de cada empresa
	
	

	public Empresa(String nombre, String id, String telefono, String correo, String ubicacion) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.telefono = telefono;
		this.correo = correo;
		this.ubicacion = ubicacion;
		this.misContratados = new ArrayList<Personal>();
	}
	

	///***************************SETTER Y GETTERS**************************************************************
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
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public ArrayList<Personal> getMisContratados() {
		return misContratados;
	}
	
	/*
	 * public void setMisContratados(ArrayList<Personal> misContratados) {
	 * this.misContratados = misContratados; }
	 */
	
	public void agregarContratado(Personal empleado) {//PARA AGREGAR UN EMPLEADO AL ARREGLO
		//FECHA
		empleado.setContratado(true);
		misContratados.add(empleado);
		
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
