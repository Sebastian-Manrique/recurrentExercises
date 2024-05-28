package sqlEjercicio;

import java.awt.Color;
import java.awt.Font;
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
		f.setVisible(true);
		ImageIcon ImageIcon = new ImageIcon("imagen.png");
		Image Image = ImageIcon.getImage();
		f.setIconImage(Image);
	}

	public void iniciarSesion() { // La ventana para inicar sesion
		panel = new JPanel(new GridLayout(3, 3, 5, 5));
		JLabel tituloJLabel = new JLabel("Nombre de usuario:");
		JTextField nameUserJTextField = new JTextField("Tu nombre");
		JLabel contraTituloJLabel =  new JLabel("Contraseña:");
		JPasswordField contraUserJPasswordField =new JPasswordField();
		JButton button = new JButton("End");
		tituloJLabel.setFont(comic);
		nameUserJTextField.setFont(comic);
		contraTituloJLabel.setFont(comic);
		contraUserJPasswordField.setFont(comic);
		panel.add(tituloJLabel);
		panel.add(nameUserJTextField);
		panel.add(contraTituloJLabel);
		panel.add(contraUserJPasswordField);
		panel.add(button);
		f.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 400);
		f.setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameUserJTextField.getText(); // El boton guarda el texto puesto
				String contra = String.valueOf(contraUserJPasswordField.getPassword());
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
		panel.setLayout(new GridLayout(2,4)); // Grid layout
		iconoCorreos.setIcon(ImageIcon); //Label con la imagen de correos
		f.setIconImage(Image);// Iconito
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
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
				agarrarDatos iniciar = new agarrarDatos();
		    	iniciar.crearPaqueteVentana();
			}
		});
		empleadoAdd.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				agarrarDatos iniciar = new agarrarDatos();
		    	iniciar.crearEmpleadoVentana();
			}
		});
		envioAdd.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
				agarrarDatos iniciar = new agarrarDatos();
		    	iniciar.crearEnvioVentana();
			}

		});
		paquetSupr.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
			agarrarDatos iniciar = new agarrarDatos();
		    iniciar.eliminarPaqueteVentana();
			}
		});
		empleadoSupr.addActionListener((ActionListener) new ActionListener() { // Add the action listener to the button
			// BOTONES
			@Override
			public void actionPerformed(ActionEvent e) {
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
		f.setSize(500,400);
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
	public void crearPaqueteVentana() { // La ventana para crear paquetes
		panel = new JPanel(new GridLayout(4, 4, 5, 5));
		JLabel idPaqueteJLabel = new JLabel("Id paquete:");
		JTextField idPaqueteJTextField = new JTextField();
		JLabel namePaqueteJLabel = new JLabel("Nombre paquete:");
		JTextField namePaqueJTextField = new JTextField();
		JLabel pesoPaqueteJLabel = new JLabel("Peso del paquete:");
		JTextField pesoPaqueTextField = new JTextField();
		
		JButton button = new JButton("End");
		idPaqueteJLabel.setFont(comic);
		idPaqueteJTextField.setFont(comic);
		namePaqueteJLabel.setFont(comic);
		namePaqueJTextField.setFont(comic);
		pesoPaqueTextField.setFont(comic);
		panel.add(idPaqueteJLabel);
		panel.add(idPaqueteJTextField);
		panel.add(namePaqueteJLabel);
		panel.add(namePaqueJTextField);
		panel.add(pesoPaqueteJLabel);
		panel.add(pesoPaqueTextField);
		panel.add(button);
		f.add(panel);
		f.setSize(400, 400);
		f.setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idPq = idPaqueteJTextField.getText(); // El boton guarda el texto puesto
				String nombrePq = namePaqueJTextField.getText();
				double pesoPq = Double.parseDouble(pesoPaqueTextField.getText());
				Paquete pq = new Paquete(idPq,nombrePq, pesoPq);
				sql.crearPaquete(pq);
				f.dispose();
				JOptionPane.showMessageDialog(null, "De locos pana!");
			}
		});
	}
	public void crearEmpleadoVentana() { // La ventana para crear paquetes
		panel = new JPanel(new GridLayout(6, 6, 5, 5));
		JLabel idEmpleadoJLabel = new JLabel("Id :");
		JTextField idEmpleadoJTextField = new JTextField();
		JLabel nameEmpleadoJLabel = new JLabel("Nombre del empleado:");
		JTextField nameEmpleadoJTextField = new JTextField();
		JLabel surnameEmpleadoJLabel = new JLabel("Apellido del empleado:");
		JTextField surnameEmpleadoJTextField = new JTextField();
		JLabel cargoEmpleadoJLabel = new JLabel("cargo del empleado:");
		JTextField cargoEmpleadoJTextField = new JTextField();
		JLabel passwordEmpleadoJLabel = new JLabel("Contraseña del empleado:");
		JPasswordField passwordEmpleadoJPasswordField = new JPasswordField();
		JButton button = new JButton("End");
		idEmpleadoJLabel.setFont(comic);
		idEmpleadoJTextField.setFont(comic);
		nameEmpleadoJLabel.setFont(comic);
		nameEmpleadoJTextField.setFont(comic);
		cargoEmpleadoJTextField.setFont(comic);
		surnameEmpleadoJLabel.setFont(comic);
		surnameEmpleadoJTextField.setFont(comic);
		panel.add(idEmpleadoJLabel);
		panel.add(idEmpleadoJTextField);
		panel.add(nameEmpleadoJLabel);
		panel.add(nameEmpleadoJTextField);
		panel.add(surnameEmpleadoJLabel);
		panel.add(surnameEmpleadoJTextField);
		panel.add(cargoEmpleadoJLabel);
		panel.add(cargoEmpleadoJTextField);
		panel.add(passwordEmpleadoJLabel);
		panel.add(passwordEmpleadoJPasswordField);
		panel.add(button);
		f.add(panel);
		f.setSize(400, 400);
		f.setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                boolean error = false;
                do {
                    String idEmp = idEmpleadoJTextField.getText(); // El boton guarda el texto puesto
                    String nombreEmp = nameEmpleadoJTextField.getText();
                    int cargoEmp = Integer.parseInt(cargoEmpleadoJTextField.getText());
                    if (cargoEmp == 0 | cargoEmp == 1) {
                        String password = String.valueOf(passwordEmpleadoJPasswordField.getPassword());
                        String surname = surnameEmpleadoJTextField.getText();
                        Empleado em1 = new Empleado(idEmp, nombreEmp, cargoEmp, surname, password);
                        sql.crearEmpleado(em1);
                        f.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "El cargo solo puede ser:\n1.JEFE\n0.TRABAJADOR");
                        error = true;
                    }
                } while (error=false);
                

            }
        });
	}
	public void crearEnvioVentana() {
		panel = new JPanel(new GridLayout(6, 6, 5, 5));
		JLabel idEnvioJLabel= new JLabel("Id del envio:");
		JTextField idEnvioJTextField = new JTextField();
		JLabel idPaqueteJLabel = new JLabel("Id del paquete:");
		JTextField idPaquetJTextField = new JTextField();
		JLabel idEmpleadoJLabel = new JLabel("Id del empleado:");
		JTextField idEmpleadoJTextField = new JTextField();
		JButton button = new JButton("End");
		idPaqueteJLabel.setFont(comic);
		idPaquetJTextField.setFont(comic);
		idEmpleadoJLabel.setFont(comic);
		idEmpleadoJTextField.setFont(comic);
		idEnvioJLabel.setFont(comic);
		idEnvioJTextField.setFont(comic);
		panel.add(idEnvioJLabel);
		panel.add(idEnvioJTextField);
		panel.add(idPaqueteJLabel);
		panel.add(idPaquetJTextField);
		panel.add(idEmpleadoJLabel);
		panel.add(idEmpleadoJTextField);
		panel.add(button);
		f.add(panel);
		f.setSize(400, 400);
		f.setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idEnvio = idPaquetJTextField.getText(); // El boton guarda el texto puesto
				String idPaq = idEmpleadoJTextField.getText();
				String idEmp = idEnvioJTextField.getText();
				Envio envio = new Envio(idEnvio, idPaq, idEmp);
				sql.crearEnvio(envio);
				f.dispose();
			}
		});
	}
	public void eliminarPaqueteVentana() { // La ventana para crear paquetes
		panel = new JPanel(new GridLayout(4, 4, 5, 5));
		JLabel idPaqueteJLabel =  new JLabel("Id paquete:");
		JTextField idPaqueteJTextField = new JTextField();	
		JButton button = new JButton("End");
		idPaqueteJLabel.setFont(comic);
		idPaqueteJTextField.setFont(comic);
		panel.add(idPaqueteJLabel);
		panel.add(idPaqueteJTextField);
		panel.add(button);
		f.add(panel);
		f.setSize(400, 400);
		f.setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idPq = Integer.parseInt(idPaqueteJTextField.getText()); // El boton guarda el texto puesto
				sql.eliminarPaquete(idPq);
				f.dispose();
				JOptionPane.showMessageDialog(null, "De locos pana!");
			}
		});
	}
}
