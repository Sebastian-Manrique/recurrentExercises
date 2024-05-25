package sqlEjercicio;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Empleado;
import clases.Paquete;

public class agarrarDatos extends javax.swing.JFrame {
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("End");

	public agarrarDatos() {
	}// Constructor con las cosas minimas

//	public void iniciarSesion() { // La ventana para inicar sesion
//		panel = new JPanel(new GridLayout(3, 3, 5, 5));
//		Font comic = new Font("Comic Sans MS", Font.PLAIN, 18); // fuente usada
//		JLabel titulo = new JLabel("Nombre de usuario:");
//		JTextField textField = new JTextField("Tu nombre");
//		textField.setFont(comic);
//		JLabel contraTitulo = new JLabel("Contraseña:");
//		JTextField contraUser = new JTextField("Tu contraseña");
//		contraUser.setFont(comic);
//		panel.add(titulo);
//		panel.add(textField);
//		panel.add(contraTitulo);
//		panel.add(contraUser);
//		panel.add(button);
//		f.add(panel);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(400, 400);
//		f.setVisible(true);
//		button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String string = textField.getText();
//				JOptionPane.showMessageDialog(null, "Tu nombre es " + string); // El botodn guarda el texto puesto
//
//			}
//		});
//	}

	public void panelDeBotones() {
		panel.setLayout(new GridLayout(7, 5, 10, 10)); // Grid layout
		f = new JFrame("CORREOS WANNABE"); // Titulo de la ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
		ImageIcon ImageIcon = new ImageIcon("images.jpg");
		Image Image = ImageIcon.getImage();
		f.setIconImage(Image);// Iconito
		JButton paqueteAdd = new JButton("Añadir paquete");
		JButton empleadoAdd = new JButton("Añadir empleado");
		JButton envioAdd = new JButton("Añadir envio");
		JButton paquetSupr = new JButton("Eliminar paquete");
		JButton empleadoSupr = new JButton("Eliminar empleado");
		JButton envioSupr = new JButton("Eliminar envio");
		JButton salir = new JButton("Salir");
		Color c = new Color(214, 35, 37);
		salir.setBackground(c);
		paqueteAdd.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Nombre del paquete");
				String id = JOptionPane.showInputDialog("Id del paquete");
				double peso = Double.parseDouble(JOptionPane.showInputDialog("introduce cuanto pesa"));
				Paquete p1 = new Paquete(id, name , peso);
				sql.crearPaquete(p1);
			}
		});
		empleadoAdd.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Nombre del empleado");
				String id = JOptionPane.showInputDialog("Id del empleado");
				int cargo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del cargo: \n0.Repartidor\n1.Trabajafor normal"));
				Empleado em1 = new Empleado(id, name, cargo);
				sql.crearEmpleado(em1);
			}
		});
		paquetSupr.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				sql.eliminarPaquete();
			}
		});
		empleadoSupr.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				sql.eliminarEmpleado();
			}
		});
		salir.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(paqueteAdd);
		panel.add(empleadoAdd);
		panel.add(envioAdd);
		panel.add(paquetSupr);
		panel.add(empleadoSupr);
		panel.add(envioSupr);
		panel.add(salir);
		f.add(panel);
		f.setSize(600, 1000);
		f.setVisible(true);
	}
}
