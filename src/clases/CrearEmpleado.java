package clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sqlEjercicio.sql;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CrearEmpleado extends JFrame{
	
	static String url = "jdbc:mysql://localhost:3306/proyectojava";
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	
	String[] titulos = new String[] {
			"ID","Nombre","Apellido","Cargo","Password"
			};
	String[] datos = new String[5];
	
	public CrearEmpleado() {
		setTitle("CORREOS WANNABE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearEmpleado.class.getResource("/imagenes/imagen.png")));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(37, 25, 70, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(226, 25, 70, 32);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(443, 25, 70, 32);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setBounds(37, 68, 70, 32);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña");
		lblNewLabel_4.setBounds(253, 68, 70, 32);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(78, 25, 127, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(306, 25, 127, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(500, 25, 127, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 68, 127, 32);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(335, 68, 127, 32);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable(tabla);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                boolean error = false;
                do {
                	String idEmp = textField.getText(); // El boton guarda el texto puesto
    				String nombreEmp = textField_1.getText();
    				String surname = textField_2.getText();
    				int cargoEmp = Integer.parseInt(textField_3.getText());
                    if (cargoEmp == 0 | cargoEmp == 1) {
        				String password = textField_4.getText();
                        Empleado em1 = new Empleado(idEmp, nombreEmp, cargoEmp, surname, password);
                        sql.crearEmpleado(em1);
                        actualizarTabla(tabla);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "El cargo solo puede ser:\n1.JEFE\n0.TRABAJADOR");
                        error = true;
                    }
                } while (error=false);
                

            }
		});
		btnNewButton.setBounds(510, 63, 166, 55);
		getContentPane().add(btnNewButton);
		
	
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(37, 129, 670, 294);
		getContentPane().add(scrollPane);
		
		
		setVisible(true);
		setSize(756, 509);
		setLocationRelativeTo(null);
		actualizarTabla(tabla);

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
