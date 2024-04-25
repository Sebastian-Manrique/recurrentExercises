import java.util.Scanner;
public class Cuenta {
	private String titular="";
	private double saldoCuenta=0;
	static Scanner sc = new Scanner(System.in);
	
	//GETTERS Y SETTERS
	public String getTitular() {
		return titular;
	}
	public String setTitular(String titular) {
		return this.titular=titular;
	}
	public double getSaldoCuenta() {
		return saldoCuenta;
	}
	public double setSaldoCuenta(double saldoCuenta) {
		return this.saldoCuenta=saldoCuenta;
	} //OTROS METODOS
	public void ingresarSaldoCuenta(double cantidad) {
		if(cantidad<0) {
			System.out.println("No se puedo completar la operacion.");
		}else {
			saldoCuenta +=cantidad;
		}
	}
	public boolean sacarSaldoCuenta(double cantidad) {
		if(cantidad<0){
			System.out.println("No se puedo completar la operacion.");
			return false;
		}else if(cantidad>this.saldoCuenta){
			System.out.println("No tienes tanto dinero.");
			return false;
		}
		else {
			saldoCuenta -=cantidad;
			return true;
		}
	}
	public void mostrarInformacion() {
		System.out.println("Nombre del titular: "+this.getTitular());
		System.out.println("Dinero en la cuenta: "+this.getSaldoCuenta()+"€.");
	}
}

