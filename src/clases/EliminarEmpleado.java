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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EliminarEmpleado extends JFrame {

	static String url = "jdbc:mysql://localhost:3306/proyectojava";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String[] titulos = new String[] {
			"ID","Nombre","Apellido","Cargo","Password"
			};
	String[] datos = new String[5];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					EliminarEmpleado frame = new EliminarEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public EliminarEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		DefaultTableModel tabla = new DefaultTableModel(titulos, 0);
		table = new JTable(tabla);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 117, 623, 305);
		contentPane.add(scrollPane);
		actualizarTabla(tabla);
		
	}
	
	public void actualizarTabla(DefaultTableModel tabla) {
        
//        tabla.addRow(titulos);

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
