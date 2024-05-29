 package sqlEjercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import clases.Empleado;
import clases.Envio;
import clases.PanelRepartidor;
import clases.Paquete;

public class sql {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";

	public static boolean crearPaquete(Paquete p) {
		boolean correcto = false;
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			String ordenSQL = "INSERT INTO paquete (idPaquete, nombrePaquete, pesoPaquete) VALUES (?,?,?)";
			PreparedStatement ps = c.prepareStatement(ordenSQL);
			ps.setString(1, p.getId()); 
			ps.setString(2, p.getNombre());
			ps.setDouble(3, p.getPeso());
			ps.executeUpdate();
			correcto = true;
			return correcto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return correcto;
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
			String ordenSQL2 = "INSERT INTO Envio_historico (idEnvio, idPaquete, idTrabajador) VALUES (?,?,?)";
			PreparedStatement ps = c.prepareStatement(ordenSQL);
			ps.setString(1, en.getIdEnvio()); 
			ps.setString(2, en.getPaquete());
			ps.setString(3, en.getEmpleado());
			ps.executeUpdate();
			PreparedStatement ps2 = c.prepareStatement(ordenSQL2);
			ps2.setString(1, en.getIdEnvio()); 
			ps2.setString(2, en.getPaquete());
			ps2.setString(3, en.getEmpleado());
			ps2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarEmpleado(String id) {
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
	
	public static void eliminarPaquete(int id) {
		System.out.println("holaaa"+id);
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			Statement ps = c.createStatement(); //Creamos Statement
			String ordenSQL = "DELETE FROM PAQUETE WHERE idPaquete = "+id+" ";
			System.out.println("Fila borrada correctamente");
			ps.executeUpdate(ordenSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarEnvio(int id) {
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

	
	public static boolean modificarPassword(String password, int id) {
		boolean verdad = false;
		String ordenSqlString = "UPDATE `proyectojava`.`trabajadores` SET `password` = '1297' WHERE (`idTrabajadores` = '12')";
		try {
			Connection c = DriverManager.getConnection(url, "root", "1234"); // Creamos conexion
			Statement ps = c.createStatement(); //Creamos Statement
			String ordenSQL = "UPDATE `proyectojava`.`trabajadores` SET `password` = '"+password+"' WHERE (`idTrabajadores` = '"+id+"')";
			System.out.println("Contraseña modificada correctamente");
			ps.executeUpdate(ordenSQL);
			verdad = true;
			return verdad;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verdad;
	}

}
