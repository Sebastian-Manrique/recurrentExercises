package abstractClasses;

import java.util.Scanner;

public class AbstractClassesExercise {
	/* Write a Java program to create an abstract class Animal with abstract methods sound(), eat() and sleep().
	 * Create subclasses Lion, Tiger, and Deer that extend the Animal class and implement the sound(), eat() and sleep()
	 * methodsdifferently based on their specific behavior.*/

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		Scanner sc = new Scanner(System.in);
		Lion lion = new Lion();
		Tiger tiger = new Tiger();
		Deer deer = new Deer();
		char anws = 0;
		do {
			System.out.println("Wich animal info do you want to know?\n1.Lion info\n2.Tiger info\n3.Deer info\n4.Exit");
			anws = sc.nextLine().charAt(0);
			String selection ="";
			switch (anws) {
			case '1': {
				selection="lion";
				moreInfo(lion, tiger, deer, selection);
				break;
			}
			case '2': {
				selection="tiger";
				moreInfo(lion, tiger, deer,selection);
				break;
			}
			case '3': {
				selection="deer";
				moreInfo(lion, tiger, deer,selection);
				break;
			}
			case '4': {
				System.out.println("Exiting. . .");
				break;
			}
			default:{
				throw new IllegalArgumentException("Unexpected value: " + anws);
			}
		  }
		} while (anws!='4');
	}

	private static void moreInfo(Lion lion, Tiger tiger, Deer deer, String selection) {
		Scanner sc = new Scanner(System.in);
		char anws=0;
		do {
			System.out.println("Which info do you want to know?\n1.The sound\n2.What they eat\n3.How much they sleep\n4.Go back");
			anws =sc.nextLine().charAt(0);
			switch (anws){
			case '1': {
				if (selection.equals("lion")) {
					lion.sound();
				}
				else if (selection.equals("tiger")) {
					tiger.sound();
				}
				else {
					deer.sound();
				}
				break;
			}
			case '2': {
				if (selection.equals("lion")) {
				lion.eat();
				}
				else if (selection.equals("tiger")) {
				tiger.eat();
				}
				else {
				deer.eat();
				}
				break;
			}
			case '3': {
				if (selection.equals("lion")) {
					lion.sleep();
				}
				else if (selection.equals("tiger")) {
					tiger.sleep();
				}
				else {
					deer.sleep();
				}
				break;
			}
			case '4': {
				System.out.println("Going back. . .");
				menu();
                break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + anws);
			}
		} while (anws!='4');
	}
}
