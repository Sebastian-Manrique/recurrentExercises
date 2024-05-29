package clases;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Message;

import sqlEjercicio.sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarEmpleado extends JFrame {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String[] titulos = new String[] {
			"ID","Nombre","Apellido","Cargo","Password"
			};
	String[] datos = new String[5];
	private JTextField textField;



	public EliminarEmpleado() {
		
		setVisible(true);
		setTitle("CORREOS WANNABE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EliminarEmpleado.class.getResource("/imagenes/imagen.png")));
		setBounds(100, 100, 677, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("ID Trabajador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 130, 49);
		contentPane.add(lblNewLabel);
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable(tabla);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 117, 623, 305);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(189, 16, 165, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Eliminar Trabajador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idString = textField.getText();
				sql.eliminarEmpleado(idString);
				actualizarTabla(tabla);
			}
		});
		btnNewButton.setBounds(403, 20, 187, 34);
		contentPane.add(btnNewButton);
		actualizarTabla(tabla);
		
	}
	
	public void actualizarTabla(DefaultTableModel tabla) {
        
//        tabla.addRow(titulos);
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
