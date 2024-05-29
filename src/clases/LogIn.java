package clases;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sqlEjercicio.sql;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LogIn extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	private ImageIcon imagenIcon;

	public LogIn() {
		setTitle("Inicio de Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/imagenes/imagen.png")));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setBounds(24, 32, 102, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(24, 93, 102, 31);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(136, 32, 114, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(136, 91, 114, 33);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText(); // El boton guarda el texto puesto
				String contra = String.valueOf(passwordField.getPassword());
				Short verdad = sql.confirmarID(name, contra);
				System.out.println("Nombre: " + name + ", contraseña: " + contra);
				System.out.println("Cargo devuelto: " + verdad);
				if (verdad == 404) {
					JOptionPane.showMessageDialog(null, "No pusiste nada crack");
				} else if (verdad >= 1) { // admin
					dispose();
					ButtonWindow iniciar = new ButtonWindow();
				} else if (verdad == 0) {// no admin
					dispose();
					PanelRepartidor panelRepartidor = new PanelRepartidor(name);
				}
			}
			
		});
		btnNewButton.setBounds(75, 145, 132, 36);
		getContentPane().add(btnNewButton);
		setVisible(true);
		setSize(286, 231);
		setLocationRelativeTo(null);
		
		
	}
}
