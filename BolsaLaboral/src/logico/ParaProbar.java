package logico;

public class ParaProbar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BolsaLaboral bolsa=new BolsaLaboral();
		
		Empresa emp=new Empresa("sirena", "98", "94885", "correo@", "moca");
		
		bolsa.agregarEmpresa(emp);
		
		Universitario obr=new Universitario("juan", "lamur", "masculino", "haitiana", "3", 34, null, "5544", "hhfd@", false, false,4, false, 4, false, "moca", "itt");
		bolsa.agregarPersonal(obr);
		
		Obrero obr2=new Obrero("jimmy", "gomez", "masculino", "dominicana", "3", 34, null, "5544", "hhfd@", false, false,4, false, 4, false, "moca", null);
		bolsa.agregarPersonal(obr2);
		
		
				
		Solicitud solob2=new SolicitudObrero(emp, "22", "completo", 4, false, "masculino", null, "moca", false, false, null);
		Solicitud solob=new SolicitudUniversitario(emp, "22", "completo", 4, false, "masculino", null, "moca", false, false, "itt");
		
		bolsa.agregarSolicitud(solob);
		
		bolsa.agregarSolicitud(solob2);
		
		System.out.println(bolsa.cant_personal_universitario());
		
		System.out.println(bolsa.cant_personal_obrero());

	}

}
