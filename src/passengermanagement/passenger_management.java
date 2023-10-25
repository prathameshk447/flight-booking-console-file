package passengermanagement;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class passenger_management{
	
	
	static ArrayList<passenger> al = new ArrayList();
	static {
		try {
			loadDataFromFileToArrayList();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    public static void passengermanagement() throws IOException {
	Scanner Sc= new Scanner(System.in);
	boolean canIKeepRunningTheProgram = true;
	while (canIKeepRunningTheProgram == true)
	 {
		
		
		System.out.println("welcome to the passenger management program:");
	    System.out.println("\n");
	    System.out.println("what would you like to do");
		System.out.println("1. Add passenger");
		System.out.println("2. Edit passenger");
		System.out.println("3. Delete passenger");
		System.out.println("4. Search passenger");
		System.out.println("5. Quit");
		
		int optionSelectedBypassenger = Sc.nextInt();
		if (optionSelectedBypassenger==passengeroptions.QUIT) {
			File file= new File
					(
				"\\Users\\user\\eclipse-workspace\\FlightManagement\\src\\passengermanagement\\passengerdb.txt");
			FileWriter fileWriter = new FileWriter(file,false);
			BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
			for (passenger passenger :al) {
				bufferedWriter.write(
						passenger.LoginName+ ","+ passenger.Password +"," +passenger.passengerName+","+ passenger.passengerRole+"\n");
				}
			bufferedWriter.close();
			fileWriter.close();
			file=null;
			
		System.out.println("!!! program closed!!");
		
		canIKeepRunningTheProgram  = false;
		}
	
    else if (optionSelectedBypassenger==passengeroptions.ADD_PASSENGER){
			addpassenger();
			System.out.println("\n");
			
			}else if (optionSelectedBypassenger ==passengeroptions.SEARCH_PASSENGER ) {
				System.out.println("Enter passenger Name to Search");
				Sc.nextLine();
				String sn = Sc.nextLine();
				searchpassenger(sn);
				System.out.println("\n");
				
			}else if (optionSelectedBypassenger ==passengeroptions.DELETE_PASSENGER ) {
				System.out.println("Enter passenger Name to delete");
				Sc.nextLine();
				String deletepassengerName = Sc.nextLine();
				deletepassenger(deletepassengerName);
				System.out.println("\n");
				
			}
			else if (optionSelectedBypassenger ==passengeroptions.EDIT_PASSENGER) {
				System.out.println("Enter passenger Name to edit");
				Sc.nextLine();
				String editpassengerName = Sc.nextLine();
				editpassenger(editpassengerName);
				System.out.println("\n");
			}
	 }
	System.out.println("\n");
	System.out.println("****after while loop");
	

	for(passenger p:al) {
		System.out.println(p.passengerName);
		System.out.println(p.LoginName);
		System.out.println(p.Password);
		System.out.println(p.confirmPassword);
		System.out.println(p.passengerRole);
		
	}
    }
       public static void addpassenger()
{
    	   
	Scanner Sc= new Scanner(System.in);
	passenger passengerobj=new passenger();
	System.out.println("passenger Name:");
	passengerobj.passengerName = Sc.nextLine();
	
	System.out.println("Login Name:");
	passengerobj.LoginName = Sc.nextLine();
	
	System.out.println("Password:");
	passengerobj.Password = Sc.nextLine();
	
	System.out.println("confirmPassword:");
	passengerobj.confirmPassword = Sc.nextLine();
    
	System.out.println("passenger Role:");
	passengerobj.passengerRole = Sc.nextLine();
	
	System.out.println("passenger Name:"+ passengerobj.passengerName);
	System.out.println("Login Name:"+ passengerobj.LoginName);
	System.out.println("Password:"+ passengerobj.Password);
	System.out.println("confirm Password:"+ passengerobj.confirmPassword);
	System.out.println("passenger Role:"+ passengerobj.passengerRole);
	al.add(passengerobj);

}
       public static void searchpassenger(String passengerName) {
    	   for (passenger passenger:al) {
    		   if (passenger.passengerName.equalsIgnoreCase(passengerName)) {
    			   System.out.println("passenger Name:"+ passenger.passengerName);
    				System.out.println("Login Name:"+ passenger.LoginName);
    				System.out.println("Password:"+ passenger.Password);
    				System.out.println("confirm Password:"+ passenger.confirmPassword);
    				System.out.println("passenger Role:"+ passenger.passengerRole);
    			    return;
    		   }
    	   }
    	   System.out.println("passenger not found");
       }
       public static void deletepassenger(String passengerName) {
    	   Iterator<passenger> passengerIterator = al.iterator();
    	   while (passengerIterator.hasNext()) {
    		   passenger passenger = passengerIterator.next();
    		   if (passenger.passengerName.equalsIgnoreCase(passengerName)) {
    			   passengerIterator.remove();
    			   System.out.println("passenger"+passenger.passengerName+" has been deleted.");
    			   break;
    			   
    			   
    		   }
    	   }
    	   
       }
       
       
       public static void editpassenger(String passengerName) {
    	   for (passenger passenger:al) {
    		   if (passenger.passengerName.equalsIgnoreCase(passengerName)) {
    			   Scanner Sc= new Scanner(System.in);
    			   System.out.println("editting passenger:" + passenger.passengerName);

    			   System.out.println("New passenger Name:");
    			   passenger.passengerName = Sc.nextLine();
    				System.out.println("New Login Name:");
    				passenger.LoginName = Sc.nextLine();
    				System.out.println("New Password:");
    				passenger.Password = Sc.nextLine();
    				System.out.println("New confirmPassword:");
    				passenger.confirmPassword = Sc.nextLine();
    				System.out.println("New passenger Role:");
    				passenger.passengerRole = Sc.nextLine();
    				System.out.println("passenger information updated.");
    				return;
    		   }
    			   
    		   }
    	   System.out.println("passenger not found.");
    	   }

public static void loadDataFromFileToArrayList() throws IOException
{
	File file = new File("\\Users\\user\\eclipse-workspace\\FlightManagement\\src\\passengermanagement\\passengerdb.txt");
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String line="";
	while((line=br.readLine())!=null)
	{
		passenger passenger = new passenger();
		String[] passengerDataArray = line.split(",");
		if(passengerDataArray.length>3 ) {
			passenger.LoginName = passengerDataArray[0];
			passenger.Password = passengerDataArray[1];
			passenger.passengerName = passengerDataArray[2];
			passenger.passengerRole = passengerDataArray[3];
			al.add(passenger);
		}
		
		}
		br.close();
		fr.close();
		file = null;
	}
public static boolean validatepassengerandpassword(String loginName,String password)throws IOException{
	Iterator<passenger>passengerIterator=al.iterator();
	while(passengerIterator.hasNext()) {
		passenger passenger= passengerIterator.next();
		if(passenger.LoginName.equalsIgnoreCase(loginName)&&passenger.Password.equalsIgnoreCase(password))
			return true;
	}
	return false;

	}
	}	



