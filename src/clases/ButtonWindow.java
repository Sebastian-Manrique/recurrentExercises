package clases;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

import sqlEjercicio.agarrarDatos;
import sqlEjercicio.sql;

import java.awt.Color;

public class ButtonWindow extends JFrame{
	public ButtonWindow() {
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Añadir Paquete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agarrarDatos iniciar = new agarrarDatos();
		    	iniciar.crearPaqueteVentana();
			}
		});
		btnNewButton.setBounds(26, 73, 161, 39);
		
		JButton btnNewButton_1 = new JButton("Añadir Envio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	agarrarDatos iniciar = new agarrarDatos();
		    	iniciar.crearEnvioVentana();
			}
		});
		btnNewButton_1.setBounds(26, 123, 161, 39);
		
		JButton btnNewButton_2 = new JButton("Eliminar Empleado");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql.eliminarEmpleado();
			}
		});
		btnNewButton_2.setBounds(26, 173, 161, 43);
		
		JButton btnNewButton_3 = new JButton("Eliminar Paquete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agarrarDatos iniciar = new agarrarDatos();
			    iniciar.eliminarPaqueteVentana();
			}
		});
		btnNewButton_3.setBounds(26, 227, 161, 42);
		
		JButton btnNewButton_4 = new JButton("Eliminar Envio");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql.eliminarEnvio();
			}
		});
		btnNewButton_4.setBounds(26, 280, 161, 45);
		
		JButton btnNewButton_6 = new JButton("Añadir Empleado");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agarrarDatos iniciar = new agarrarDatos();
				iniciar.crearEmpleadoVentana();
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton_6.setBounds(26, 22, 161, 40);
		
		JButton btnNewButton_5 = new JButton("Salir");
		btnNewButton_5.setBackground(new Color(255, 0, 0));
		btnNewButton_5.setBounds(26, 337, 161, 51);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		frame.getContentPane().add(btnNewButton_6);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().add(btnNewButton_3);
		frame.getContentPane().add(btnNewButton_4);
		frame.getContentPane().add(btnNewButton_5);
		frame.setVisible(true);
		frame.setSize(239, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se acabe al cerrar
		
	}
}
