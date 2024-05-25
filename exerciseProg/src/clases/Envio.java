package clases;
public class Envio {	//Todos con constructor y sus respectivos getters y setters
    private Paquete paquete;
    private Empleado empleado;
    //Constructor
    public Envio(Paquete paquete, Empleado empleado) {
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
}
