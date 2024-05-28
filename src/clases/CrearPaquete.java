package clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sqlEjercicio.sql;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CrearPaquete extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public CrearPaquete() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearPaquete.class.getResource("/imagenes/imagen.png")));
		setTitle("CORREOS WANNABE");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(33, 45, 102, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 105, 102, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Peso");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(33, 165, 102, 33);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(183, 45, 131, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 105, 131, 33);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 165, 131, 33);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idPq = textField.getText(); // El boton guarda el texto puesto
				String nombrePq = textField_1.getText();
				double pesoPq = Double.parseDouble(textField_2.getText());
				Paquete pq = new Paquete(idPq,nombrePq, pesoPq);
				sql.crearPaquete(pq);
				dispose();
				JOptionPane.showMessageDialog(null, "De locos pana!");
			}
		});
		btnNewButton.setBounds(89, 226, 144, 49);
		getContentPane().add(btnNewButton);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(348, 324);
	}

}
