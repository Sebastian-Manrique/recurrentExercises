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
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

public class Sudoku extends javax.swing.JFrame {

	JFrame f = new JFrame();
	JButton button = new JButton("End");

	public Sudoku() {
		screenMethod();
		Random rand = new Random();
		// Create font. Code from https://java2everyone.blogspot.com/2008/12/set-jtextfield-text-size.html
		Font roboto = new Font("Roboto", Font.PLAIN, 30);
		JPanel panel = new JPanel(new GridLayout(6, 6));
		JTextField t = new JTextField();
		ArrayList<ArrayList<Integer>> alreadyIn = new ArrayList<ArrayList<Integer>>();
		for (int number = 1; number <= 6; number++) { // Number
			ArrayList<Integer> intDestination = new ArrayList<Integer>();
			for (int row = 0; row < 6; row++) { // Rows
				t = new JTextField();
				t.setFont(roboto); // Set JTextField font using new created font
				boolean repeRows = false;
				boolean repeColumns = false;
				do {
					int col = rand.nextInt(1, 7);
					repeRows = isRepedRows(intDestination, number);
					repeColumns = isRepedColumns(alreadyIn, number, col);
					if (!repeRows && !repeColumns) { // If repe is false
						intDestination.add(col);
						t = new JTextField("" + col);
						t.setFont(roboto);
					}
				} while (repeRows || repeColumns);
				t.setEditable(false);
				// From https://stackoverflow.com/questions/11935188/is-there-any-way-to-get-one-sidei-e-right-bordered-line-of-the-jtextfield-co
				Border oldBorder = t.getBorder();
				Border grayBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray); 
				Border newBorder = BorderFactory.createCompoundBorder(grayBorder, oldBorder);
				t.setBorder(newBorder);
				panel.add(t);
				linesMethod(number, row, t);
			}
			alreadyIn.add(intDestination);
		}
		f.add(panel, BorderLayout.CENTER); // Adding the panel at the center of the component
		button.setFocusable(false);
		actionListenerMethod(button, t);
		f.add(button, BorderLayout.SOUTH); // Añadir el botón al fondo del contenedor principal
	}

	private void screenMethod() {
		GraphicsConfiguration config = f.getGraphicsConfiguration();
		Rectangle bounds = config.getBounds();
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
		int x = bounds.x + bounds.width - insets.right - f.getWidth();
		int y =  bounds.y + bounds.height - insets.top - f.getHeight(); // I just do that copying the int x and changing the values
		f.setLocation(x/3, y/3-100);
		ImageIcon img = new ImageIcon("imagesAndText/sudokuIcon.png");
		f.setIconImage(img.getImage());
		f.setTitle("Sudoku");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
		f.setSize(600, 650);
	}
	
	private boolean isRepedRows(ArrayList<Integer> intDestination, int number) { // This method has the random and the array to prove its not repeated
		for (int k = 0; k < intDestination.size(); k++) {
			if (intDestination.get(k) == number) {
				System.out.println("Repe rows " + number);
				return true;
			}
		}
		return false;
	}

	private boolean isRepedColumns(ArrayList<ArrayList<Integer>> intAlreadyIn, int number, int col) { // This method has the random and the array to prove its not repeated
		for (int k = 0; k < intAlreadyIn.size(); k++) {
			if (intAlreadyIn.get(k).get(col) == number) {
				System.out.println("Repe columns " + number);
				return true;
			}
		}
		return false;
	}
	private void linesMethod(int i, int j, JTextField t) {
		if (j == 2) { // To make the borders biggers for the second row
			Border oldBorder = t.getBorder();
			Border blackBorder = BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK); // From https://stackoverflow.com/questions/11935188/is-there-any-way-to-get-one-sidei-e-right-bordered-line-of-the-jtextfield-co
			Border newBorder = BorderFactory.createCompoundBorder(blackBorder, oldBorder);
			t.setBorder(newBorder);
		}
		if (i % 2 == 0) { // To make the borders biggers for the second column
			Border oldBorder = t.getBorder();
			Border blackBorder = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK);
			Border newBorder = BorderFactory.createCompoundBorder(blackBorder, oldBorder);
			t.setBorder(newBorder);
		}
	}

	private void actionListenerMethod(JButton button2, JTextField t) { // The buttom do this
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				String name = t.getText();
//				System.out.println(name);
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		Sudoku susuSudoku = new Sudoku();
		susuSudoku.f.setVisible(true);
	}
}