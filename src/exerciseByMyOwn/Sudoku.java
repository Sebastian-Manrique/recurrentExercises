package exerciseByMyOwn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.synth.Region;
public class Sudoku implements ActionListener{
	
	JFrame f= new JFrame();
	JButton button = new JButton("End");
	
	public Sudoku() {
//		Random rand = new Random();
//		int random = rand.nextInt(1,3);
//		System.out.println(random);
		GraphicsConfiguration config = f.getGraphicsConfiguration();
	    Rectangle bounds = config.getBounds();
	    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
		int x = bounds.x + bounds.width - insets.right - f.getWidth();
	    int y = bounds.y + insets.top;
	    f.setLocation(x-1000, y+170);
		ImageIcon img = new ImageIcon("images&Fonts/sudokuIcon.png");
		f.setIconImage(img.getImage());
		f.setTitle("Sudoku");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
		f.setSize(600, 650);
		Font newTextFieldFont = new Font("Roboto", Font.PLAIN, 30);// Create font. Code from https://java2everyone.blogspot.com/2008/12/set-jtextfield-text-size.html
		JPanel panel = new JPanel(new GridLayout(6, 6));
		for (int i = 0; i < 6; i++) { // Row
			for (int j = 0; j < 6; j++) { // Column
				JTextField t = new JTextField("i " + i + ", j " + j);
				t.setFont(newTextFieldFont); // Set JTextField font using new created font
				if (j < 3) {
					t = new JTextField("i " + i + ", j " + j);
					t.setEditable(false);
					Border oldBorder = t.getBorder();
					Border blackBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.PINK); // From https://stackoverflow.com/questions/11935188/is-there-any-way-to-get-one-sidei-e-right-bordered-line-of-the-jtextfield-co
					Border newBorder = BorderFactory.createCompoundBorder(blackBorder, oldBorder);
					t.setBorder(newBorder);
				} else if (j >= 3) {
					t = new JTextField("i " + i + ", j " + j);
					t.setEditable(false);
					Border oldBorder = t.getBorder();
					Border blackBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GREEN); // From https://stackoverflow.com/questions/11935188/is-there-any-way-to-get-one-sidei-e-right-bordered-line-of-the-jtextfield-co
					Border newBorder = BorderFactory.createCompoundBorder(blackBorder, oldBorder);
					t.setBorder(newBorder);
				}
//				if (j<5) {
//					t = new JTextField("2");
//					t.setEditable(false);
//				}
//				else {
//					t = new JTextField("i "+i+", j "+j);
//				}
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
        
	}
	@Override
	public void actionPerformed(ActionEvent e) { //The buttom do this
		f.dispose();
	}
	public static void main(String[] args) {
		Sudoku susuSudoku = new Sudoku();
		susuSudoku.f.setVisible(true);
//		Random rand = new Random();
//		int rand_dub = rand.nextInt(1,7);
//		for (int countForFillers = 0; countForFillers < rand_dub; countForFillers++) {
//			int rand_cells = rand.nextInt(1,7);
//			JLabel nonEditJLabel = new JLabel("jl: " + rand_cells);
//			System.out.println(rand_cells);
//			panel.add(nonEditJLabel);
	}
}  