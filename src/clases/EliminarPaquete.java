package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sqlEjercicio.sql;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EliminarPaquete extends JFrame {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	String[] titulos = new String[] {
			"ID","Nombre","Peso"
			};
	String[] datos = new String[3];

	public EliminarPaquete() {
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EliminarPaquete.class.getResource("/imagenes/imagen.png")));
		setTitle("CORREOS WANNABE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID del Paquete");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 6, 124, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 8, 124, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 66, 661, 248);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Eliminar Paquete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				sql.eliminarPaquete(id);
				actualizarTabla(tabla);
			}
		});
		btnNewButton.setBounds(332, 6, 137, 32);
		contentPane.add(btnNewButton);
		
		actualizarTabla(tabla);
	}

	public void actualizarTabla(DefaultTableModel tabla) {
        
//      tabla.addRow(titulos);
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
