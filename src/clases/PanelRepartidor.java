package clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//import sqlEjercicio.CustomTableCellRenderer;

import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRepartidor extends JFrame{
	String url = "jdbc:mysql://localhost:3307/proyectojava";
	private JTextField textField;
	private JTable table;
	DefaultTableModel tabla;
	String [] titulos = new String[] {
			"Id Envio", "Id Paquete", "Id Trabajador"
	};
	String [] datos = new String[3];
	
	public PanelRepartidor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanelRepartidor.class.getResource("/imagenes/imagen.png")));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id del envio");
		lblNewLabel.setBounds(20, 23, 87, 30);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(97, 21, 111, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(20, 85, 807, 321);
		getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(270, 27, 89, 23);
		getContentPane().add(btnNewButton);
		setVisible(true);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
	}
	
	public void actualizarTabla(DefaultTableModel tabla) {
        String sSQL = "SELECT * FROM ENVIOS";
        tabla = new DefaultTableModel(null, titulos);
        Connection c = null;
		try {
			c = DriverManager.getConnection(url, "root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        tabla.addRow(titulos);
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()) {
                if(rs.getString("Comprado-Alquilado").equalsIgnoreCase("Si")) { // Si esta comprado alquilado no se añade
                    continue;
                }
                datos[0]=rs.getInt("Id Envio")+"";
                datos[1]=rs.getInt("Id Paquete")+"";
                datos[2]=rs.getInt("Id Trabajador")+"";
                tabla.addRow(datos);
            }

            table.setModel(tabla);
        } catch (SQLException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "error " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
 }
	   static class CustomTableCellRenderer extends DefaultTableCellRenderer {
	         
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        
	                cell.setBackground(Color.LIGHT_GRAY);  // Color de fondo por defecto
	                cell.setForeground(Color.WHITE);  // Color del texto por defecto

	            return cell;
	        }
	    }
}
