package sqlEjercicio;


import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class agarrarDatos extends  javax.swing.JFrame{
	JFrame f= new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("End");
	
	public agarrarDatos() {
		JTextField textField=new JTextField();
//		Font azi =new Font("Comic Sans MS", Font.BOLD, 200);
		textField.setFont(new Font("Serif", Font.ITALIC, 150));
//		textField.setFont(azi);
		textField=new JTextField("HOLA");
		panel.add(textField);
		f.add(panel);
		f.setSize(400,400);
		f.setVisible(true);
	}
}
