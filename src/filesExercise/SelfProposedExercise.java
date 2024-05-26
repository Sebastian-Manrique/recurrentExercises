package filesExercise;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SelfProposedExercise {
	public static void main(String[] args) {
		 menu();
	}
	private static void menu() {
		Scanner sc = new Scanner(System.in);
		char anws;
		do {
			System.out.println("\nWhat you want to do:\n1.Create a file\n2.Test file\n3.Exit");
			anws = sc.next().charAt(0);
			switch (anws) {
			case '1': {
				createFile();
				break;
			}
			case '2': {
				testFile(); 
				break;
			}
			case '3': {
				System.exit(0);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + anws);
			}
		} while (anws!='3');
	}
	private static void createFile() {
		try {	//To create a new file
			Scanner sc = new Scanner(System.in);
			System.out.print("What name do you want:");
			String nameString = sc.nextLine();
	        System.out.println("Where do you want the file:");
	        String pathString = sc.nextLine();
	        File myFile = new File(pathString+"/"+nameString+".txt");
	        System.out.println("Path where is created "+myFile.getAbsoluteFile());
	        if (myFile.createNewFile()) {
	          System.out.println("File created: " + myFile.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      } 
	}
	private static void testFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tell me the directory off the file you want to test:");
		String pathString=sc.nextLine();
		// If is a directory or a file
		// If is a file, it should show the next data: name, size and reading permissions
	}
}
