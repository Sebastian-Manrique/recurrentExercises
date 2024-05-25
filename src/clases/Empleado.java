package clases;
public class Empleado {	//Todos con constructor y sus respectivos getters y setters
    private String id;
    private String nombre;
    private int cargo;
    //Constructor
    public Empleado(String id, String nombre, int cargo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
    }
    //Getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCargo() {
        return cargo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
