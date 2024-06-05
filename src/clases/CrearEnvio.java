package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sqlEjercicio.sql;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearEnvio extends JFrame {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JTable table_2;

	String[] titulos = new String[] {
			"ID","Nombre","Apellido","Cargo","Password"
			};
	String[] datos = new String[5];
	
	String[] titulos1 = new String[] {
			"ID","Nombre Paquete","Peso"
			};
	String[] datos1 = new String[3];

	String[] titulos2 = new String[] {
			"ID Envio","ID Paquete","ID Trabajador"
			};
	String[] datos2 = new String[3];
	

	public CrearEnvio() {
		setVisible(true);
		setTitle("CORREOS WANNABE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearEnvio.class.getResource("/imagenes/imagen.png")));
		setBounds(100, 100, 1013, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Envio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 70, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Paquete");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(230, 11, 96, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID Trabajador");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(494, 11, 112, 29);
		contentPane.add(lblNewLabel_2);
		
		
		
		textField = new JTextField();
		textField.setBounds(82, 8, 138, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(336, 11, 137, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setBounds(616, 9, 151, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable(tabla);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 89, 274, 263);
		contentPane.add(scrollPane);
		
		DefaultTableModel tabla1 = new DefaultTableModel(titulos1, 0);
		table_1 = new JTable(tabla1);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(366, 89, 274, 263);
		contentPane.add(scrollPane_1);
		
		DefaultTableModel tabla2 = new DefaultTableModel(titulos2, 0);
		table_2 = new JTable(tabla2);
		
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setBounds(680, 89, 274, 263);
		contentPane.add(scrollPane_2);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idEnvio = textField.getText(); // El boton guarda el texto puesto
				String idPaq = textField_1.getText();
				String idEmp = textField_2.getText();
				Envio envio = new Envio(idEnvio, idPaq, idEmp);
				sql.crearEnvio(envio);
				actualizarTablaEnvios(tabla2);
			}
		});
		btnNewButton.setBounds(810, 9, 147, 37);
		contentPane.add(btnNewButton);
		
		JButton guardarEnFicheroBtn = new JButton("Guardar en un fichero");
		guardarEnFicheroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearFichero();
			}

			private void crearFichero() {
				
			}
		});
		guardarEnFicheroBtn.setBounds(405, 382, 159, 55);
		contentPane.add(guardarEnFicheroBtn);
		setLocationRelativeTo(null);
		
		
		
		actualizarTablaEmpleados(tabla);
		actualizarTablaPaquetes(tabla1);
		actualizarTablaEnvios(tabla2);
		
	}
	public void actualizarTablaEmpleados(DefaultTableModel tabla) {
        
//		tabla.addRow(titulos);
		tabla = new DefaultTableModel(null, titulos);

		try {
			Connection c = DriverManager.getConnection(url, "root", "1234");
			Statement st = c.createStatement();
			String sSQL = "SELECT * FROM TRABAJADORES";
			ResultSet rs = st.executeQuery(sSQL);
			while (rs.next()) {
				datos[0] = rs.getString("idTrabajadores");
				datos[1] = rs.getString("nombre");
				datos[2] = rs.getString("apellido");
				datos[3] = rs.getString("cargo");
				datos[4] = rs.getString("password");
				String data = rs.getString("idTrabajadores") + " " + rs.getString("idTrabajadores") + " "
						+ rs.getString("nombre") + " " + rs.getString("apellido") + " " + rs.getString("cargo") + " "
						+ rs.getString("password");
				System.out.println(data);
				tabla.addRow(datos);
			}
			table.setModel(tabla);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
	
public void actualizarTablaPaquetes(DefaultTableModel tabla1) {
        
//		tabla1.addRow(titulos);
		tabla1 = new DefaultTableModel(null, titulos1);

      try {
      	Connection c = DriverManager.getConnection(url, "root", "1234");
      	Statement st = c.createStatement();
          String sSQL = "SELECT * FROM Paquete";
          ResultSet rs = st.executeQuery(sSQL);
          
          while(rs.next()) {
              datos1[0]=rs.getString("idPaquete");
              datos1[1]=rs.getString("nombrePaquete");
              datos1[2]=rs.getString("pesoPaquete");
              for(String dato:datos1) {
              	System.out.println(dato);
              	
              }
              tabla1.addRow(datos1);
          }

          table_1.setModel(tabla1);
      } catch (Exception e) {
          // TODO: handle exception
      	System.out.println(e.getMessage());
      }
}

public void actualizarTablaEnvios(DefaultTableModel tabla2) {
    
//	tabla.addRow(titulos);
	tabla2 = new DefaultTableModel(null, titulos2);

  try {
  	Connection c = DriverManager.getConnection(url, "root", "1234");
  	Statement st = c.createStatement();
      String sSQL = "SELECT * FROM Envio";
      ResultSet rs = st.executeQuery(sSQL);
      
      while(rs.next()) {
          datos2[0]=rs.getString("idEnvio");
          datos2[1]=rs.getString("idPaquete");
          datos2[2]=rs.getString("idTrabajador");
          for(String dato:datos2) {
          	System.out.println(dato);
          	
          }
          tabla2.addRow(datos2);
      }

      table_2.setModel(tabla2);
  } catch (Exception e) {
      // TODO: handle exception
  	System.out.println(e.getMessage());
  }
}
}
