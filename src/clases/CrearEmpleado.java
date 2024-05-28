package clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sqlEjercicio.sql;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearEmpleado extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public CrearEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearEmpleado.class.getResource("/imagenes/imagen.png")));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(37, 25, 70, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(37, 68, 70, 32);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(37, 111, 70, 32);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setBounds(37, 154, 70, 32);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña");
		lblNewLabel_4.setBounds(37, 197, 70, 32);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(181, 25, 127, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 68, 127, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 111, 127, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 153, 127, 34);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(181, 197, 127, 32);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idEmp = textField.getText(); // El boton guarda el texto puesto
				String nombreEmp = textField_1.getText();
				String surname = textField_2.getText();
				int cargoEmp = Integer.parseInt(textField_3.getText());
				String password = textField_4.getText();
				Empleado em1 = new Empleado(idEmp, nombreEmp,cargoEmp,surname, password);
				sql.crearEmpleado(em1);
				dispose();
			}
		});
		btnNewButton.setBounds(106, 249, 166, 55);
		getContentPane().add(btnNewButton);
		setVisible(true);
		setSize(400, 354);
		setLocationRelativeTo(null);

	}
}
