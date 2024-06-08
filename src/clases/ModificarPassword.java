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
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ModificarPassword extends JFrame {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	String[] titulos = new String[] {
			"ID","Nombre","Apellido","Cargo","Password"
			};
	String[] datos = new String[5];
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					ModificarPassword frame = new ModificarPassword();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public ModificarPassword() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarPassword.class.getResource("/imagenes/imagen.png")));
		setTitle("CORREOS WANNABE");
		setVisible(true);
		setBounds(100, 100, 629, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID del Trabajador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 9, 124, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nueva Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 56, 124, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(177, 11, 147, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 56, 147, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable(tabla);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 110, 593, 264);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				String passwordString = textField_1.getText();
				sql.modificarPassword(passwordString, id);
				actualizarTabla(tabla);
			}
		});
		btnNewButton.setBounds(396, 32, 179, 36);
		contentPane.add(btnNewButton);
		
		actualizarTabla(tabla);
		repaint();
		
	}

public void actualizarTabla(DefaultTableModel tabla) {
        
//      tabla.addRow(titulos);
		tabla = new DefaultTableModel(null, titulos);

      try {
      	Connection c = DriverManager.getConnection(url, "root", "1234");
      	Statement st = c.createStatement();
          String sSQL = "SELECT * FROM TRABAJADORES";
          ResultSet rs = st.executeQuery(sSQL);
          
          while(rs.next()) {
              datos[0]=rs.getString("idTrabajadores");
              datos[1]=rs.getString("nombre");
              datos[2]=rs.getString("apellido");
              datos[3]=rs.getString("cargo");
              datos[4]=rs.getString("password");
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
