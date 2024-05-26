 package sqlEjercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Empleado;
import clases.Envio;
import clases.Paquete;

public class sql {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";

	public static void crearPaquete(Paquete p) {
		String texto = "Nombre del currante: " + p.getNombre() + "\nId: " + p.getId()+ "\nPeso: " + p.getPeso();
		JOptionPane.showMessageDialog(null, texto);
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			String ordenSQL = "INSERT INTO paquete (idPaquete, nombrePaquete, pesoPaquete) VALUES (?,?,?)";
			PreparedStatement ps = c.prepareStatement(ordenSQL);
			ps.setString(1, p.getId()); 
			ps.setString(2, p.getNombre());
			ps.setDouble(3, p.getPeso());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearEmpleado(Empleado em) {
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			String ordenSQL ="INSERT INTO trabajadores (idTrabajadores, nombre, apellido, cargo, password) VALUES (?,?,?,?,?);";
			PreparedStatement ps = c.prepareStatement(ordenSQL);
			ps.setString(1, em.getId()); // Trabajador es el True
			ps.setString(2, em.getNombre());
			ps.setString(3, em.getApellido());
			ps.setInt(4, em.getCargo());
			ps.setString(5, em.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearEnvio(Envio en) {
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			String ordenSQL = "INSERT INTO Envio (idEnvio, idPaquete, idTrabajador) VALUES (?,?,?)";
			PreparedStatement ps = c.prepareStatement(ordenSQL);
			ps.setString(1, en.getIdEnvio()); 
			ps.setString(2, en.getPaquete().getId());
			ps.setString(3, en.getEmpleado().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarEmpleado() {
		String id = JOptionPane.showInputDialog("Dime la ID del trabajador que quieres eliminar");
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			Statement ps = c.createStatement(); //Creamos Statement
			String ordenSQL = "DELETE FROM TRABAJADORES WHERE idTrabajadores ='"+id+"';";
			System.out.println("Fila borrada correctamente");
			ps.executeUpdate(ordenSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarPaquete() {
		String id = JOptionPane.showInputDialog("Dime la ID del paquete que quieres eliminar");
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			Statement ps = c.createStatement(); //Creamos Statement
			String ordenSQL = "DELETE FROM PAQUETE WHERE idPaquete ='"+id+"';";
			System.out.println("Fila borrada correctamente");
			ps.executeUpdate(ordenSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarEnvio() {
		String id = JOptionPane.showInputDialog("Dime la ID del envio que quieres eliminar");
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			Statement ps = c.createStatement(); //Creamos Statement
			String ordenSQL = "DELETE FROM ENVIO WHERE idEnvio ='"+id+"';";
			System.out.println("Fila borrada correctamente");
			ps.executeUpdate(ordenSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Short confirmarID(String name, String contra) {
		short cargo=404;
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			Statement ps = c.createStatement(); // Creamos Statement
			ResultSet rs = ps.executeQuery("SELECT * FROM trabajadores");
			while (rs.next()) { // Mientras haya más registros en el ResultSet, comprobamos las claves, si cargo es 1, te lleva a menu de opciones
				System.out.println("Nombre: "+rs.getString(2)+" contraseña: "+rs.getString(5));
				if (contra.equals(rs.getString(5))){
					if (name.equals(rs.getString(2))){
						if (rs.getShort(4)==1) { //Aqui comprueba el cargo, si es cero te lleva a la lista de paquetes.
							System.out.println("Eres admin");
							cargo = rs.getShort(4);
						}
						else {
							System.out.println("No eres admin");
							cargo = rs.getShort(4);
						}
						return cargo;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cargo;
	}

	public static ArrayList<String> mostrarPaquetes() {
		ArrayList<String> paquetesArraysArrayList = new ArrayList<String>();
		String paqueteString="";
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			String ordenSQL = "SELECT * FROM PAQUETE";
			Statement s = c.createStatement(); // Creamos Statement
			ResultSet rs = s.executeQuery(ordenSQL);
			while (rs.next()) { // Mientras haya más registros en el ResultSet
				paqueteString = "Id paquete: "+rs.getString(1)+", nombre del paquete: "+rs.getString(2)+", peso del paquete: "+rs.getString(3)+"\n";
				paquetesArraysArrayList.add(paqueteString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paquetesArraysArrayList;
	}
	public static ArrayList<String> mostrarTrabajadores() {
		ArrayList<String> paquetesArraysArrayList = new ArrayList<String>();
		String paqueteString="";
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			String ordenSQL = "SELECT * FROM TRABAJADORES";
			Statement s = c.createStatement(); // Creamos Statement
			ResultSet rs = s.executeQuery(ordenSQL);
			while (rs.next()) { // Mientras haya más registros en el ResultSet
				paqueteString = "Id trabajador: "+rs.getString(1)+", nombre del trabajador: "+rs.getString(2)+", apellido del trabajador: "
			+rs.getString(3)+", cargo: "+rs.getShort(4)+"\n";
				paquetesArraysArrayList.add(paqueteString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paquetesArraysArrayList;
	}

}
