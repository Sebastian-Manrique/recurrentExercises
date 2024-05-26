package sqlEjercicio;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import clases.Empleado;
import clases.Envio;
import clases.Paquete;

public class agarrarDatos extends javax.swing.JFrame {
	JFrame f = new JFrame("CORREOS WANNABE"); // Titulo de la ventana
	JPanel panel = new JPanel();
	ImageIcon ImageIcon = new ImageIcon("imagen.png");
	Image Image = ImageIcon.getImage();
	JLabel iconoCorreos = new JLabel(); // Iconito
	Font comic = new Font("Comic Sans MS", Font.PLAIN, 18); // fuente usada

	public agarrarDatos() { // Constructor con las cosas minimas
		f.setIconImage(Image);
		iconoCorreos.setIcon(ImageIcon);
		f.setVisible(true);
	}

	public void iniciarSesion() { // La ventana para inicar sesion
		panel = new JPanel(new GridLayout(3, 3, 5, 5));
		JLabel titulo = new JLabel("Nombre de usuario:");
		JTextField nameUser = new JTextField("Tu nombre");
		JLabel contraTitulo = new JLabel("Contraseña:");
		JPasswordField contraUser = new JPasswordField();
		JButton button = new JButton("End");
		titulo.setFont(comic);
		nameUser.setFont(comic);
		contraTitulo.setFont(comic);
		contraUser.setFont(comic);
		panel.add(titulo);
		panel.add(nameUser);
		panel.add(contraTitulo);
		panel.add(contraUser);
		panel.add(button);
		f.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 400);
		f.setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameUser.getText(); // El boton guarda el texto puesto
				String contra = String.valueOf(contraUser.getPassword());
				Short verdad = sql.confirmarID(name, contra);
				System.out.println("Nombre: " + name + ", contraseña: " + contra);
				System.out.println("Cargo devuelto: " + verdad);
				if (verdad == 404) {
					JOptionPane.showMessageDialog(null, "No pusiste nada crack");
				} else if (verdad >= 1) { // admin
					agarrarDatos iniciar = new agarrarDatos();
					f.dispose();
					iniciar.panelDeBotones();
				} else if (verdad == 0) {// no admin
					agarrarDatos iniciar = new agarrarDatos();
					f.dispose();
					iniciar.panelRepartidor();
				}

			}
		});
	}

	public void panelDeBotones() { // USUARIOS ADMIN
		panel.setLayout(new GridLayout(7, 5, 10, 10)); // Grid layout
		f = new JFrame("CORREOS WANNABE"); // Titulo de la ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
		ImageIcon ImageIcon = new ImageIcon("imagen.png");
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
				Paquete p1 = new Paquete(id, name, peso);
				sql.crearPaquete(p1);
			}
		});
		empleadoAdd.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Id del empleado");
				String name = JOptionPane.showInputDialog("Nombre del empleado");
				String apellido = JOptionPane.showInputDialog("apellido:");
				int cargo = Integer.parseInt(JOptionPane
						.showInputDialog("Introduce el numero del cargo: \n0.Repartidor\n1.Trabajafor normal"));
				String password = JOptionPane.showInputDialog("contraseña:");
				Empleado em1 = new Empleado(id, name, cargo, apellido, password);
				sql.crearEmpleado(em1);
			}
		});
		envioAdd.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("id Envio");
				String id = JOptionPane.showInputDialog("Id del paquete");
				String idTra = JOptionPane.showInputDialog("Id trabajador");
				Envio envio = new Envio(name, id, idTra);
				sql.crearEnvio(envio);
				JOptionPane.showMessageDialog(null, "El id del envio es: "+ name+ "el id del paquete es: "+id
						+" el id del trabajador es: "+ idTra);
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
		envioSupr.addActionListener((ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sql.eliminarEnvio();
				
			}
		});
		salir.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(iconoCorreos);
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

	public void panelRepartidor() { // USUARIOS CORRIENTES
		panel.setLayout(new GridLayout(2, 2, 10, 10)); // Grid layout
		f = new JFrame("CORREOS WANNABE"); // Titulo de la ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
		ImageIcon ImageIcon = new ImageIcon("images.jpg");
		Image Image = ImageIcon.getImage();
		f.setIconImage(Image);// Iconito
		JButton paqueteAdd = new JButton("Ver paquetes");
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
				Paquete p1 = new Paquete(id, name, peso);
				sql.crearPaquete(p1);
			}
		});
		salir.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(paqueteAdd);
		panel.add(salir);
		f.add(panel);
		f.setSize(600, 1000);
		f.setVisible(true);
		JTextField idEn = new JTextField();
	}

	void mostrarPaquetesVentana() {
		ArrayList<String> paquetesArraysArrayList = new ArrayList<String>();
		paquetesArraysArrayList = sql.mostrarPaquetes();
		JLabel paquetesLabel = new JLabel();
		paquetesLabel.setFont(comic);
		for (String paqueteString : paquetesArraysArrayList) {
			paquetesLabel = new JLabel(paqueteString);
			panel.add(paquetesLabel);
		}
		panel.setLayout(new GridLayout(20, 1, 1, 1)); // Grid layout
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
		f.add(panel);
		f.setSize(500, 500);
	}

	void mostrarTrabajadoresVentana() {
		ArrayList<String> trabajadoresArrayList = new ArrayList<String>();
		trabajadoresArrayList = sql.mostrarTrabajadores();
		JLabel trabajadoresLabel = new JLabel();
		for (String paqueteString : trabajadoresArrayList) {
			trabajadoresLabel = new JLabel(paqueteString);
			panel.add(trabajadoresLabel);
		}
		panel.setLayout(new GridLayout(20, 1, 1, 1)); // Grid layout
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
		f.add(panel);
		f.setBounds(1000, 0, 600, 500);
	}
}
