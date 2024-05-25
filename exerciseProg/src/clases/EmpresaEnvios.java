package clases;
import java.util.ArrayList;	//Todos con constructor y sus respectivos getters y setters
	
class EmpresaEnvios {
    private ArrayList<Envio> envios;
    //Constructor
    public EmpresaEnvios() {
        envios = new ArrayList<>();
    }
    //Getters y setters
    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

	public void setEnvios(ArrayList<Envio> envios) {
		this.envios = envios;
	}
}