package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sqlEjercicio.sql;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarEnvio extends JFrame {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	
	String[] titulos = new String[] {
			"ID Envio","ID Paquete","ID Trabajador"
			};
	String[] datos = new String[3];

	public EliminarEnvio() {
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EliminarEnvio.class.getResource("/imagenes/imagen.png")));
		setTitle("CORREOS WANNABE");
		setBounds(100, 100, 482, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Envio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 22, 86, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 24, 129, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable(tabla);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 79, 423, 277);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				sql.eliminarEnvio(id);
				actualizarTablaEnvios(tabla);
			}
		});
		btnNewButton.setBounds(289, 24, 114, 32);
		contentPane.add(btnNewButton);
		
		actualizarTablaEnvios(tabla);
		
	}

	
	public void actualizarTablaEnvios(DefaultTableModel tabla) {
	    
//		tabla.addRow(titulos);
		tabla = new DefaultTableModel(null, titulos);

	  try {
	  	Connection c = DriverManager.getConnection(url, "root", "1234");
	  	Statement st = c.createStatement();
	      String sSQL = "SELECT * FROM Envio";
	      ResultSet rs = st.executeQuery(sSQL);
	      
	      while(rs.next()) {
	          datos[0]=rs.getString("idEnvio");
	          datos[1]=rs.getString("idPaquete");
	          datos[2]=rs.getString("idTrabajador");
	          for(String dato:datos) {
	          	System.out.println(dato);
	          	
	          }
	          tabla.addRow(datos);
	      }

	      table.setModel(tabla);
	  } catch (Exception e) {
	      // TODO: handle exception
	  	System.out.println(e.getMessage());
	  }
	}
	
}
