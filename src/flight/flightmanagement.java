package flight;


import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Iterator;


public class flightmanagement{
	
	
	static ArrayList<flight> al = new ArrayList();
	
    public static void flight_management() throws IOException {
	Scanner Sc= new Scanner(System.in);
	boolean canIKeepRunningTheProgram = true;
	while (canIKeepRunningTheProgram == true)
	{
		
		
		System.out.println("welcome to the flight management program:");
	    System.out.println("\n");
	    System.out.println("what would you like to do");
		
		System.out.println("1. Add booking");
		System.out.println("2. Search booking");
		System.out.println("3. Edit booking");
		System.out.println("4. Delete booking");
		System.out.println("5. Quit");
		
		int optionSelectedByflight = Sc.nextInt();
		if (optionSelectedByflight==flightoptions.QUIT) {
			File file= new File
					(
				"\\Users\\user\\eclipse-workspace\\FlightManagement\\src\\flight\\flightdb.txt");
			FileWriter fileWriter = new FileWriter(file,false);
			BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
			for (flight flight :al) {
				bufferedWriter.write(
						flight.PassengerName+ ","+ flight.PassportId+"," +flight.FlightClass+","+ flight.PaymentMethod+"\n");
				}
			bufferedWriter.close();
			fileWriter.close();
			file=null;
			
			
		System.out.println("!!! program closed!!");
		
		canIKeepRunningTheProgram  = false;
		}
	
    
			else if (optionSelectedByflight==flightoptions.ADD_BOOKING){
		    	addbooking();
		    	
					System.out.println("\n");
					
					}else if (optionSelectedByflight ==flightoptions.SEARCH_BOOKING ) {
						System.out.println("Enter passenger Name to Search");
						Sc.nextLine();
						String sd = Sc.nextLine();
						searchbooking(sd);
						System.out.println("\n");
					}
				
		
		
			else if (optionSelectedByflight ==flightoptions.DELETE_BOOKING ) 
			{
				System.out.println("Enter destination Name to delete");
				Sc.nextLine();
				String deletePassengerName = Sc.nextLine();
				deletebooking(deletePassengerName);
				System.out.println("\n");
				
			}
			else if (optionSelectedByflight ==flightoptions.EDIT_BOOKING) {
				System.out.println("Enter passenger Name to edit");
				Sc.nextLine();
				String editPassengerName = Sc.nextLine();
				editbooking (editPassengerName);
				System.out.println("\n");
			}
	 }
	System.out.println("\n");
	System.out.println("****after while loop");
	

	for(flight f:al) {
		
		
		
		
		
		System.out.println(f.PassengerName);
		System.out.println(f.PassportId);
		System.out.println(f.FlightClass);
		System.out.println(f.PaymentMethod);
		System.out.println(f.capacity);
		
		
		
	}
    }
      
       public static void addbooking()
       {
           	   
       	Scanner sc= new Scanner(System.in);
       	flight flightobj=new flight();
       	System.out.println("enter the passenger name");
       	flightobj.PassengerName = sc.nextLine();
       	System.out.println("passport id:");
       	flightobj.PassportId = sc.nextLine();
       	System.out.println("flight class");
       	flightobj.FlightClass = sc.nextLine();

       	System.out.println("payment method:");
       	flightobj.PaymentMethod = sc.nextLine();
       	
       	
       	System.out.println("seats to be reserved :");
       	flightobj.capacity = sc.nextInt();
       	
       	System.out.println("enter the passenger name"+flightobj.PassengerName);
       	System.out.println("passport id:"+ flightobj.PassportId);
       	System.out.println("flight class"+flightobj.FlightClass);
       	System.out.println("payment method:"+ flightobj.PaymentMethod);
       	System.out.println("seats to be reserved :"+ flightobj.capacity);
       	
       	System.out.println("Your Tickets Are Booked");
       	
       	
       	
       	
       	al.add(flightobj);

       }
       
       public static void searchbooking (String PassengerName) 
       {
    	   for (flight flight:al) {
    		   if (flight.PassengerName.equalsIgnoreCase(PassengerName))
    		   {	System.out.println("enter the passenger name"+flight.PassengerName);
    	       	System.out.println("passport id:"+ flight.PassportId);
    	       	System.out.println("flight class"+flight.FlightClass);
    	       	System.out.println("payment method:"+ flight.PaymentMethod);
    	       	System.out.println("seats to be reserved :"+ flight.capacity);
    	       	System.out.println("Your Tickets Are Booked");
    			   
    			    return;
    		   }
    	   }
    	   System.out.println(" booking  not found");
       }
       
       public static void editbooking(String PassengerName) {
    	   for (flight flight:al) {
    		   if (flight.PassengerName.equalsIgnoreCase(PassengerName)) {
    			   Scanner sc= new Scanner(System.in);
    			   System.out.println("editting ticket booking for :" + flight.PassengerName);
    			   
    			   System.out.println("enter new the passenger name");
    		       	flight.PassengerName = sc.nextLine();
    		       	System.out.println(" new passport id:");
    		       	flight.PassportId = sc.nextLine();
    		       	System.out.println(" new flight class");
    		       	flight.FlightClass = sc.nextLine();

    		       	System.out.println(" new payment method:");
    		       	flight.PaymentMethod = sc.nextLine();
    		       	
    		       	
    		       	System.out.println(" new seats to be reserved :");
    		       	flight.capacity = sc.nextInt();
    			   
                   
    			   System.out.println("enter new  the passenger name"+flight.PassengerName);
       	       	System.out.println(" new passport id:"+ flight.PassportId);
       	       	System.out.println(" new flight class"+flight.FlightClass);
       	       	System.out.println(" new payment method:"+ flight.PaymentMethod);
       	       	System.out.println(" new seats to be reserved :"+ flight.capacity);
       	       	System.out.println("  Your Tickets Are Booked");
    			   
    				return;
    		   }
    			   
    		   }
    	   System.out.println("booking not found.");
    	   }
     
       public static void deletebooking(String PassengerName) {
    	   Iterator<flight> flightIterator = al.iterator();
    	   while (flightIterator.hasNext()) {
    		   flight flight = flightIterator.next();
    		   if (flight.PassengerName.equalsIgnoreCase(PassengerName)) {
    			   flightIterator.remove();
    			   System.out.println("booking for"+flight.PassengerName+" has been deleted.");
    			   break;
    			   
    			   
    		   }
    		   System.out.println("booking  not found");
    	   }
    	   
       }
       
       public static void loadDataFromFileToArrayList() throws IOException
       {
       	File file = new File("\\Users\\user\\eclipse-workspace\\FlightManagement\\src\\flight\\flightdb.txt");
       	FileReader fr = new FileReader(file);
       	BufferedReader br = new BufferedReader(fr);
       	String line="";
       	while((line=br.readLine())!=null)
       	{
       		flight flight = new flight();
       		String[] flightDataArray = line.split(",");
       		if(flightDataArray.length>3 ) {
       			flight.PassengerName = flightDataArray[0];
       			flight.PassportId = flightDataArray[1];
       			flight.FlightClass = flightDataArray[2];
       			flight.PaymentMethod = flightDataArray[3];
       			
       			
       			al.add(flight);
       		}
       		
       		}
       		br.close();
       		fr.close();
       		file = null;
       	}
     
     
     
     
     
       }
       
       
       







