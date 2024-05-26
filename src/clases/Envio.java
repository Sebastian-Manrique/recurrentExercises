package clases;

public class Envio {//Todos con constructor y sus respectivos getters y setters
	
	private String idEnvio;
    private String paquete;
    private String empleado;
    
    //Constructor
    public Envio(String idEnvio, String paquete, String empleado) {
    	this.idEnvio = idEnvio;
        this.paquete = paquete;
        this.empleado = empleado;
    }
    
    //Getters y setters
    public String getPaquete() {
        return paquete;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
	public String getIdEnvio() {
		return idEnvio;
	}
	
	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}
}
