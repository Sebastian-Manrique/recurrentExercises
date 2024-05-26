package clases;

public class Empleado { // Todos con constructor y sus respectivos getters y setters
	private String id;
	private String nombre;
	private int cargo;
	private String apellido;
	private String password;

	// Constructor
	public Empleado(String id, String nombre, int cargo, String apellido, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
		this.apellido = apellido;
		this.password = password;
	}

	// Getters y setters
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
