package exerciseByMyOwn;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;  
public class sudoku {  
	public static void main(String[] args) {
	
		//Create font. Code from https://java2everyone.blogspot.com/2008/12/set-jtextfield-text-size.html
		//Font Name : Default text field font
		//Font Style : Default text field font style
		//Font Size : 60
		JTextField t=new JTextField("");
		Font newTextFieldFont=new Font(t.getFont().getName(),t.getFont().getStyle(),60);

		//Create a window using JFrame with no title (  )
		JFrame f= new JFrame();
		for (int i=0; i<6;i++) { //ROW
			for (int j = 0; j < 2; j++) { //Column
				t=new JTextField("");
				f.add(t);
				t.setFont(newTextFieldFont); //Set JTextField font using new created font
				t.setBounds(50*i,60*j, 50,60); //Left, Top, width text, height text
			}
			}
		//Set JFrame layout to FlowLayout
		f.setLayout(new FlowLayout());

		//Add created text field into JFrame
		f.setSize(400,400);  
		f.setLayout(null);
		f.setVisible(true);  
	}
}  