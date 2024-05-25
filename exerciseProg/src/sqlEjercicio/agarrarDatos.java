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

public class agarrarDatos extends  javax.swing.JFrame{
	JFrame f= new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("End");
	
	public agarrarDatos() {}//Constructor con las cosas minimas
	
	public void iniciarSesion() {	//La ventana para inicar sesion
		panel = new JPanel(new GridLayout(3, 3, 5, 5));
		Font comic = new Font("Comic Sans MS", Font.PLAIN, 18); //fuente usada
		JLabel titulo = new JLabel ("Nombre de usuario:");
		JTextField textField=new JTextField("Tu nombre");
		textField.setFont(comic);
		JLabel contraTitulo = new JLabel ("Contraseña:");
		JTextField contraUser=new JTextField("Tu contraseña");
		contraUser.setFont(comic);
		panel.add(titulo);
		panel.add(textField);
		panel.add(contraTitulo);
		panel.add(contraUser);
		panel.add(button);
		f.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setVisible(true);
		button.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String string = textField.getText();
		        JOptionPane.showMessageDialog(null, string); //El botodn guarda el texto puesto
		    }
		});
	}
	
	public void panelDeBotones(){
		 JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(5, 5, 2, 2)); // Grid layout
	        JFrame frame = new JFrame("PRUEBA PRUEBA PRUEBA PRUEBA"); //Titulo de la ventana
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Que se acabe al cerrar
	        ImageIcon ImageIcon = new ImageIcon("images.jpg");
	        Image Image = ImageIcon.getImage();
	        frame.setIconImage(Image);//Iconito
	        JButton paquete = new JButton("Añadir paquete");
	        JButton empleadoAdd = new JButton("Añadir empleado");
	        JButton paquetSupr = new JButton("Eliminar paquete");
	        JButton empleadoSupr = new JButton("Eliminar empleado");
	        JButton salir = new JButton("Salir");
	        Color c = new Color(214,35,37);
	        salir.setBackground(c);
	        paquete.addActionListener((ActionListener) new ActionListener() {	// Add the action listener to the button
	        	//BOTONES
	        	@Override
	    		public void actionPerformed(ActionEvent e) {
//	    			String name = JOptionPane.showInputDialog("Nombre del paquete");
//	    			int id = Integer.parseInt(JOptionPane.showInputDialog("Id del paquete"));
//	    			float peso=Float.parseFloat(JOptionPane.showInputDialog("introduce cuanto pesa"));
//	    			sql.crearColumnaSQL(id,name, peso);
	        		agarrarDatos ventana = new agarrarDatos();
	        		}
	        	});
	        	salir.addActionListener((ActionListener) new ActionListener() {	// Add the action listener to the button
	        		@Override
	        		public void actionPerformed(ActionEvent e) {
	        			System.exit(0);
	        			}
	            	});
	            panel.add(paquete);
	            panel.add(empleadoAdd);
	            panel.add(paquetSupr);
	            panel.add(empleadoSupr);
	            panel.add(salir);
	            frame.add(panel);
	            frame.setSize(500,500); 
	            frame.setVisible(true);
	}
}
