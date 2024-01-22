import java.util.Scanner;
public class Tarjeta {
	public enum Proveedor {MASTERCARD, VISA, AMERICANEXPRESS};
	private String codigo = "";
	String cuentaAsociada= "";
	private double saldoTarjeta=0;
	 private Proveedor proveedor;
	static Scanner sc = new Scanner(System.in);
	//CONSTRUCTOR
	public Tarjeta(Proveedor proveedor, String codigo, String cuentaAsociada, double saldoTarjeta) {
		this.proveedor = proveedor;
		this.codigo = codigo;
		this.cuentaAsociada = cuentaAsociada;
		this.saldoTarjeta = saldoTarjeta;
	}
	//GETTERS Y SETTERS
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public String getCuentaAsociada() {
		return cuentaAsociada;
	}
	public String setCuentaAsociada(String cuentaAsociada) {
		return this.cuentaAsociada = cuentaAsociada;
	}
	public String getCodigo() {
		return codigo;
	}
	public String setCodigo(String codigo) {
		do{ // Verificar si la longitud del código es 16 y si solo contiene dígitos
            if (codigo.length() == 16 && codigo.matches("\\d+")) {
                System.out.println("Código válido");
            } else {
            	System.out.println("Codigo no valido, introducelo otra vez:");
        		codigo = sc.nextLine();
        		}
        } while (!(codigo.length() == 16 && codigo.matches("\\d+")));
		return this.codigo = codigo;
	}
	public double getSaldoTarjeta() {
		return saldoTarjeta;
	}
	public double setSaldoTarjeta(double saldoTarjeta) {
		return this.saldoTarjeta = saldoTarjeta;
	} //OTROS METODOS
	public void transferirSaldo(double cantidad){
		saldoTarjeta+=cantidad;
	}
	public boolean pagar(double cantidad){
		if(cantidad<0){
			System.out.println("No se puedo completar la operacion.");
			return false;
		}else if(cantidad>this.saldoTarjeta){
			System.out.println("No tienes tanto dinero.");
			return false;
		}
		else {
			saldoTarjeta -=cantidad;
			return true;
		}
	}
	public void mostrarInformacionTarjeta(){
		System.out.println("Saldo tarjeta: "+saldoTarjeta+"€."
		+"\nProveedor: "+proveedor
		+"\nCodigo tarjeta: "+codigo
		+"\nCuenta asociada: "+cuentaAsociada);
	}
}
