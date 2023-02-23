package practice;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

public class ProjectOne {

	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int option;
		int suboption;
		System.out.println("Application Developer : Deepti");
		System.out.println("File Menu Related Application");


		do
		{
			System.out.println("Main Menu");
			System.out.println("Choose your option");
			System.out.println("1 - Display the Current File Name");
			System.out.println("2 - Display the user interface");
			System.out.println("3 - Exit");
			option=sc.nextInt();
			switch(option)
			{
			case 1: 
				// current file name 
				System.out.println("Current Directory");
				Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
				for (Path name: dirs) {
					System.err.println(name);
					File f=name.toFile();
					String[] arr=  f.list();
					for(String element:arr) {
						System.out.println(element);
					}
				}
				/*	File f=new File(System.getProperty("user.dir"));
				String[] arr=  f.list();
				for(String element:arr) {
					System.out.println(element);
				}*/
				break;
			case 2: 
				//interface to perform various operations of file
				System.out.println("User Interface");
				System.out.println("Choose the operation to do...");
				System.out.println("11 - Add File");
				System.out.println("12 - Delete File");
				System.out.println("13 - Search File");
				System.out.println("14 - Back to Main Menu");
				suboption=sc.nextInt();
				switch(suboption)
				{
				case 11:
					System.out.println("Enter the name of the file you want to add");
					String first=	sc.next();
					try {
						File myObj = new File("D:\\"+first);
						if (myObj.createNewFile()) {
							System.out.println("File created: " + myObj.getName());
						} else {
							System.out.println(myObj.getName()+" File already exists");
						}
					} catch (IOException e) {
					    System.out.println("An error occurred while creating the file"); 
					}
					
			
					break;
				case 12:
					System.out.println("Enter the name of the file you want to delete");
					String second=	sc.next();
					File myObj2 = new File("D:\\"+second);
					if (myObj2.delete()) {
						System.out.println("File deleted: " + myObj2.getName());
					}
					else {
						System.out.println("File could not be deleted");
					}
					break;
				case 13: 
					System.out.println("Enter the name of the file you want to search");
					String filename=sc.next();
					Iterable<Path> dirs2 = FileSystems.getDefault().getRootDirectories();
					boolean found=false;
					for (Path name: dirs2) {
						File f=name.toFile();
						String[] arr=  f.list();
						for(String element:arr) {
							if(element.equals(filename)) {
								found=true;
								break;
							}
						}
					}
					if(found==true) {
						System.out.println("File found "+filename);
					}
					else { 
						System.out.println("File "+filename+" not found"); 
					}
					
					
				case 14:
					// return to main menu
				}
				break;
			case 3: 
				System.out.println("You have exited the application");
				return;

			}

		}while(true);
	}


}