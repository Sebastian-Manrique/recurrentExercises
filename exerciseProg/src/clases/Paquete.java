package clases;
public class Paquete { //Todos con constructor y sus respectivos getters y setters
    private String id;
    private String nombre;
    private double peso;
    //Constructor
    public Paquete(String id, String nombre, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }
    //getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
