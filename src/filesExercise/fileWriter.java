package filesExercise;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileWriter {
	public static void main(String[] args) {
	    menu();
	}

	private static void menu() {
		Scanner sc = new Scanner(System.in);
		char anws;
		ArrayList<File> filesArrayList = new ArrayList<File>();
		do {
			System.out.println("\nWhat you want to do:\n1.Create a file\n2.Read a file\n3.Write a file\n4.Show files\n5.Exit");
			anws = sc.next().charAt(0);
			switch (anws) {
			case '1': {
				createFile(filesArrayList);
				break;
			}
			case '2': {
				ReadFile(filesArrayList);
				break;
			}
			case '3': {
				writeFile(filesArrayList);
				break;
			}
			case '4': {
				showFiles(filesArrayList);
				break;
			}
			case '5': {
				System.exit(0);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + anws);
			}
		} while (anws!='5');
	}
	private static void createFile(ArrayList<File> filesArrayList) {
		try {	//To create a new file
			Scanner sc = new Scanner(System.in);
			System.out.print("What name do you want:");
			String nameString = sc.nextLine();
	        File myFile = new File(nameString+".txt");
	        if (myFile.createNewFile()) {
	          System.out.println("File created: " + myFile.getName());
	          filesArrayList.add(myFile);	//add the file to a arraylist of files
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      } 
	}
	private static void ReadFile(ArrayList<File> filesArrayList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWhich file do you want to read");
		String nameString = sc.nextLine();
		for (File filesF : filesArrayList) {		//Search for the file
			if (filesF.getName().equalsIgnoreCase(nameString+".txt")) {
                System.out.println("File founded! : "+filesF.getName());
                //Read file method goes here
			}
		}
		 try {
			  FileReader fr = new FileReader(nameString+".txt");
			  BufferedReader br = new BufferedReader(fr);
			  while ((nameString = br.readLine()) != null) {
				System.out.println(nameString);
			}
			  br.close();
			  fr.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	private static void writeFile(ArrayList<File> filesArrayList) {
		Scanner sc = new Scanner(System.in);
		 try {
			 System.out.println("Which file do you want to read:");
				String nameString = sc.nextLine();
				for (File filesF : filesArrayList) {		//Search for the file
					if (filesF.getName().equalsIgnoreCase(nameString+".txt")) {
		                System.out.println("File founded! : "+filesF.getName());
					}
				}
		      FileWriter myWrite = new FileWriter(nameString+".txt");
		      System.out.println("What do you want to write"); //The text that is going to be on the file
		      String textString =sc.nextLine();
		      myWrite.write(textString);
		      myWrite.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	private static void showFiles(ArrayList<File> filesArrayList) {
		System.out.println("These are the files avaliables:");
		for (File filesF : filesArrayList) {
			System.out.println("----------------------");
			System.out.println(filesF.getName()+"\n");
		}
	}
}
