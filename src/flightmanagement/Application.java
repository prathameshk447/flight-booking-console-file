package flightmanagement;
	import java.io.IOException;
	import java.util.Scanner;

import flight.flightmanagement;
import passengermanagement.passenger_management;
import searchflight.flightsearch;
    public class Application{
		public static void main(String[]args)throws IOException 
		{
			Scanner scanner = new Scanner(System.in);
		    boolean canIKeepRunningTheProgram = true;
			System.out.println("***welcome to flight management***");
			System.out.println("\n");
			
			System.out.println("enter passenger name");
			String loginName = scanner.nextLine();
			System.out.println("enter password");
			String password = scanner.nextLine();
			
			if(!passenger_management.validatepassengerandpassword(loginName,password)) 
           {
		     System.out.println("!!!!!login failed.colsing the application");
		     return;
	        }
			
			while (canIKeepRunningTheProgram == true)
			 {
				
				System.out.println("welcome to the flight login program:");
			    System.out.println("\n");
			    
			    System.out.println("what would you like to do");
				System.out.println("1.passengermanagement");
				System.out.println("2.searchflight");
				System.out.println("3.ticketbooking");
				System.out.println("4.QUIT");
				
				int optionSelectedBypassenger = scanner.nextInt();
				
				if (optionSelectedBypassenger==1) {
					
				passenger_management.passengermanagement();
				
				}
				else if(optionSelectedBypassenger==3) {
				flightmanagement.flight_management();
				}else if(optionSelectedBypassenger==2) {
				  flightsearch.flight_management();
					}
				
				else if (optionSelectedBypassenger==4) 
						break;
					
			 }
			
		}

	}



