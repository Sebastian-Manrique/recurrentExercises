package sqlEjercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import clases.Empleado;
import clases.Envio;
import clases.Paquete;

public class sql {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";

	public static void crearPaquete(Paquete p) {
		String texto = "Nombre del currante: " + p.getNombre() + "\nId: " + p.getId();
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
			String ordenSQL = "INSERT INTO Trabajadores (idEmpleado, nombreEmpleado, cargoPaquete) VALUES (?,?,?)";
			PreparedStatement ps = c.prepareStatement(ordenSQL);
			ps.setString(1, em.getId()); // Trabajador es el True
			ps.setString(2, em.getNombre());
			ps.setInt(3, em.getCargo());
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
			String ordenSQL = "DELETE FROM TRABAJADORES WHERE idEmpleado ='"+id+"';";
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
	
}
