package clases;

public class Envio {//Todos con constructor y sus respectivos getters y setters
	
	private String idEnvio;
    private Paquete paquete;
    private Empleado empleado;
    
    //Constructor
    public Envio(String idEnvio, Paquete paquete, Empleado empleado) {
    	this.idEnvio = idEnvio;
        this.paquete = paquete;
        this.empleado = empleado;
    }
    
    //Getters y setters
    public Paquete getPaquete() {
        return paquete;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
	public String getIdEnvio() {
		return idEnvio;
	}
	
	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}
}
