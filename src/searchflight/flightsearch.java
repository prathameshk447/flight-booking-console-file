package searchflight;



import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import flight.flight;

import java.util.ArrayList;
import java.util.Iterator;


public class flightsearch{
	
	
	static ArrayList<flight> al = new ArrayList();
	
    public static void flight_management() throws IOException {
	Scanner Sc= new Scanner(System.in);
	boolean canIKeepRunningTheProgram = true;
	while (canIKeepRunningTheProgram == true)
	{
		
		
		System.out.println("welcome to the flight management program:");
	    System.out.println("\n");
	    System.out.println("what would you like to do");
		System.out.println("1. Add flight");
		System.out.println("2. Search flight");
		
		System.out.println("3. Quit");
		
		int optionSelectedByflight = Sc.nextInt();
		if (optionSelectedByflight==flightoptions1.QUIT) {
			
			File file= new File
					(
				"\\Users\\user\\eclipse-workspace\\FlightManagement\\src\\searchflight\\searchdb.txt");
			FileWriter fileWriter = new FileWriter(file,false);
			BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
			for (flight flight :al) {
				bufferedWriter.write(
						flight.DestinationName+ ","+ flight.Airport +"," +flight.Airline+","+ flight.Time+"\n");
				}
			bufferedWriter.close();
			fileWriter.close();
			file=null;
			
		System.out.println("!!! program closed!!");
		
		canIKeepRunningTheProgram  = false;
		}
	
    else if (optionSelectedByflight==flightoptions1.ADD_FLIGHT){
    	addflight();
    	
			System.out.println("\n");
			
			}else if (optionSelectedByflight ==flightoptions1.SEARCH_FLIGHT ) {
				System.out.println("Enter destination Name to Search");
				Sc.nextLine();
				String sn = Sc.nextLine();
				searchflight(sn);
				System.out.println("\n");
			}
			
		
		
			
	 }
	System.out.println("\n");
	System.out.println("****after while loop");
	

	for(flight f:al) {
		
		
		
		
		System.out.println(f.DestinationName);
		System.out.println(f.Airport);
		System.out.println(f.Airline);
		System.out.println(f.Time);
		System.out.println(f.capacity);
		System.out.println(f.availableSeats);
		
		
		
		
	}
    }
       public static void addflight()
{
    	   
	Scanner sc= new Scanner(System.in);
	flight flightobj=new flight();
	System.out.println("Airport_name");
	flightobj.Airport = sc.nextLine();
    
	System.out.println("Enter destination_name:");
	flightobj.DestinationName = sc.nextLine();
	System.out.println("Travel time:");
	flightobj.Time = sc.nextLine();
	System.out.println("Airline");
	flightobj.Airline = sc.nextLine();
	System.out.println("capacity");
	flightobj.capacity = sc.nextInt();
	System.out.println("Available Seats");
	flightobj.availableSeats = sc.nextInt();
	

	System.out.println("The Airport Name is:"+flightobj.Airport);
	System.out.println("The Destination Name is:"+ flightobj.DestinationName);
	System.out.println("time requird is:"+flightobj.Time);
	System.out.println("the airline name is:"+ flightobj.Airline);
	System.out.println("the capacity is:"+ flightobj.capacity);
	System.out.println("the available seats are:"+ flightobj.availableSeats);
	

	
	al.add(flightobj);

}
       public static void searchflight (String DestinationName) 
       {
    	   for (flight flight:al) {
    		   if (flight.DestinationName.equalsIgnoreCase(DestinationName))
    		   {
    			   System.out.println("The Airport Name is:"+flight.Airport);
    				System.out.println("The Destination Name is:"+ flight.DestinationName);
    				System.out.println("time requird is:"+flight.Time);
    				System.out.println("the airline name is:"+ flight.Airline);
    				System.out.println("the capacity is:"+ flight.capacity);
    				System.out.println("the available seats are:"+ flight.availableSeats);
    				

    			   
    			    return;
    		   }
    	   }
    	   System.out.println("flight not found");
       }
       
       public static void loadDataFromFileToArrayList() throws IOException
       {
       	File file = new File("\\Users\\user\\eclipse-workspace\\FlightManagement\\src\\searchflight\\searchdb.txt");
       	FileReader fr = new FileReader(file);
       	BufferedReader br = new BufferedReader(fr);
       	String line="";
       	while((line=br.readLine())!=null)
       	{
       		flight flight = new flight();
       		String[] flightDataArray = line.split(",");
       		if(flightDataArray.length>3 ) {
       			flight.DestinationName = flightDataArray[0];
       			flight.Airport = flightDataArray[1];
       			flight.Time = flightDataArray[2];
       			flight.Airline = flightDataArray[3];
       			
       			al.add(flight);
       		}
       		
       		}
       		br.close();
       		fr.close();
       		file = null;
       	}
       
       
     
     
     
       }
       
       
       







