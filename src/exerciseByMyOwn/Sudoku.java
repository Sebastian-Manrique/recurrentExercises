package exerciseByMyOwn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.synth.Region;
public class Sudoku implements ActionListener{
	
	JFrame f= new JFrame();
	JButton button = new JButton("End");
	
	public Sudoku() {
		ImageIcon img = new ImageIcon("images&Fonts/sudokuIcon.png");
		f.setIconImage(img.getImage());
		f.setTitle("Sudoku");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close on exit
		f.setSize(600,650);
		Font newTextFieldFont=new Font("Roboto", Font.PLAIN, 30);//60 //Create font. Code from https://java2everyone.blogspot.com/2008/12/set-jtextfield-text-size.html
		JPanel panel = new JPanel(new GridLayout(6, 6));
		for (int i=0; i<6;i++) { //Row
			for (int j = 0; j <6; j++) { //Column	
				JTextField t = new JTextField(" i " + i + ", j " + j);
				t.setFont(newTextFieldFont); //Set JTextField font using new created font
				panel.add(t);
				if (j==2)   {	//To make the borders biggers for the second row
					  Border oldBorder = t.getBorder();
					  Border blackBorder = BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK); //From https://stackoverflow.com/questions/11935188/is-there-any-way-to-get-one-sidei-e-right-bordered-line-of-the-jtextfield-co
					  Border newBorder = BorderFactory.createCompoundBorder(blackBorder, oldBorder);
					  t.setBorder(newBorder);
				}
				if (i%2==0)   {	//To make the borders biggers for the second column
					  Border oldBorder = t.getBorder();
					  Border blackBorder = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK);
					  Border newBorder = BorderFactory.createCompoundBorder(blackBorder, oldBorder);
					  t.setBorder(newBorder);
				}
			}
			}	
		f.add(panel, BorderLayout.CENTER); // Adding the panel at the center of the component
	    button.setFocusable(false);
	    button.addActionListener(this);
	    f.add(button, BorderLayout.SOUTH); // Añadir el botón al fondo del contenedor principal
        f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) { //The buttom do this
		f.dispose();
	}
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
	}
}  