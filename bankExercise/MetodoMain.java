import java.util.Scanner;
public class MetodoMain{
	static Scanner sc = new Scanner(System.in);
	static Cuenta cnt=new Cuenta();
	static String codigo, cuenta="";
	static double saldoTarjeta =0;
	private static Tarjeta.Proveedor proveedor;
	static Tarjeta tar=new Tarjeta(proveedor, codigo, cuenta, saldoTarjeta);
	public static void main(String[] args) {
		pedirInformacionCuenta();
		menu();
	}
	public static void pedirInformacionCuenta() {
	    System.out.println("Nombre del titular:"); 
		cnt.setTitular(sc.nextLine());
		System.out.println("Dinero en la cuenta:");
		cnt.setSaldoCuenta(sc.nextDouble());
		System.out.println("Cual es tu proveedor:\n1.MASTERCARD\n2.VISA\n3.AMERICANEXPRESS");
		int proveRespu= sc.nextInt();
		switch (proveRespu){
		case 1:{
			tar.setProveedor(Tarjeta.Proveedor.MASTERCARD);
			break;
			}
		case 2:{
			tar.setProveedor(Tarjeta.Proveedor.VISA);
			break;
			}
		case 3:{
			tar.setProveedor(Tarjeta.Proveedor.AMERICANEXPRESS);
			break;
			}
		default:
			System.out.println("error");
		}sc.nextLine();
	    System.out.println("El codigo de la tarjeta:");
		codigo = tar.setCodigo(sc.nextLine());
		System.out.println("Cuenta asociada:");
		cuenta =tar.setCuentaAsociada( sc.nextLine());
		System.out.println("Saldo de la tarjeta:");
		saldoTarjeta =tar.setSaldoTarjeta(sc.nextDouble());
	}
	static int respuesta=0;
	public static void menu(){
		do{
		System.out.println("------------------------------------------------");
		System.out.println("Que opcion eliges:\n1.Ingresar dinero\n2.Sacar dinero\n3.Cargar dinero en la tarjeta"
		+"\n4.Pagar con la tarjeta\n5.Mostrar informacion\n6.Salir");
		respuesta=sc.nextInt();
		double cantidad;
		switch (respuesta) {
		case 1:{
			System.out.println("Cuanto quieres ingresar:");
			cantidad= sc.nextDouble();
			cnt.ingresarSaldoCuenta(cantidad);
			break;
		}
		case 2:{
			System.out.println("Cuanto quieres sacar:");
			cantidad = sc.nextDouble();
			cnt.sacarSaldoCuenta(cantidad);
			break;
		}
		case 3:{
			System.out.println("Cuanto dinero quieres tranferir a la tarjeta:");
			cantidad=sc.nextDouble();
			if(cantidad<0){
				System.out.println("No se puedo completar la operacion.");
			}else if(cantidad>cnt.getSaldoCuenta()){
				System.out.println("No tienes tanto dinero.");
				break;
			}else{
				tar.transferirSaldo(cantidad);
				cnt.sacarSaldoCuenta(cantidad);
			}
			break;
		}
		case 4:{
			System.out.println("¿De cuánto es la dolorosa?");
			cantidad=sc.nextDouble();
			tar.pagar(cantidad);
			break;
		}
		case 5:{
			cnt.mostrarInformacion();
			tar.mostrarInformacionTarjeta();
			break;
		}
		case 6:{
			System.out.println("Saliendo\n.\n..\n...");
			break;
		}
		default:
			System.out.println("error");
		}
	}while(respuesta!=6);
  }
}
