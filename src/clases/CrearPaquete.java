package clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sqlEjercicio.sql;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CrearPaquete extends JFrame{
	static String url = "jdbc:mysql://localhost:3306/proyectojava";

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	
	String[] titulos = new String[] {
			"ID","Nombre","Peso"
			};
	String[] datos = new String[3];
	public CrearPaquete() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearPaquete.class.getResource("/imagenes/imagen.png")));
		setTitle("CORREOS WANNABE");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(33, 45, 102, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(210, 45, 102, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Peso");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(413, 45, 102, 33);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(69, 47, 131, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(271, 47, 131, 33);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(460, 47, 131, 33);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(54, 118, 730, 297);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idPq = textField.getText(); // El boton guarda el texto puesto
				String nombrePq = textField_1.getText();
				double pesoPq = Double.parseDouble(textField_2.getText());
				Paquete pq = new Paquete(idPq,nombrePq, pesoPq);
				sql.crearPaquete(pq);
				actualizarTablaPaquetes(tabla);
			}
		});
		btnNewButton.setBounds(654, 39, 144, 49);
		getContentPane().add(btnNewButton);
		setVisible(true);
		setSize(860, 496);
		actualizarTablaPaquetes(tabla);
	}

public void actualizarTablaPaquetes(DefaultTableModel tabla) {
        
//		tabla1.addRow(titulos);
		tabla = new DefaultTableModel(null, titulos);

      try {
      	Connection c = DriverManager.getConnection(url, "root", "1234");
      	Statement st = c.createStatement();
          String sSQL = "SELECT * FROM Paquete";
          ResultSet rs = st.executeQuery(sSQL);
          
          while(rs.next()) {
              datos[0]=rs.getString("idPaquete");
              datos[1]=rs.getString("nombrePaquete");
              datos[2]=rs.getString("pesoPaquete");
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
