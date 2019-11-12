package logico;

public class Empresa {
	
	private String nombre;
	private int id;
	private String telefono;
	private String correo;
	private String ubicacion;
	
	
	
	///***************************SETTER Y GETTERS**************************************************************
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
