package sqlEjercicio;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ventana extends JFrame{
	public ventana() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(26, 50, 89, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 35, 284, 153);
		getContentPane().add(scrollPane);
	}
}
