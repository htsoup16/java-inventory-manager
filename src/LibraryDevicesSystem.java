//	Miriam Rose, mrose16, CIS 340, MP2

import java.util.Scanner;

public class LibraryDevicesSystem {
	
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Utilities.populateDevices();
		showMenu();
	}

	// method for showing user the menu and asks for input
	private static void showMenu() { 
	
		int input = 0;
		
		// loop that prints out menu system
		do { 
			System.out.println("\t\tLibrary Device Checkout System\n\n"
					+ "1. List Devices by Title\n"
					+ "2. Add New Devices\n"
					+ "3. Edit Device Information\n"
					+ "4. Search by Device\n"
					+ "5. Check Out Devices\n"
					+ "6. Check In Devices\n"
					+ "7. Exit");
			String question = "\n\nSelect menu options 1-7: ";
			System.out.print(question);
			input = Utilities.verifyInput(scnr.nextLine(), question);
			
			// switch to call the correct method based off user input from menu
			switch ( input ) {
			
			case 1: 
				Utilities.displayDevicesList();
				break;
			case 2:
				Utilities.addNewDevices();
				break;
			case 3:
				Utilities.editDevices();
				break;
			case 4:
				Utilities.deviceSearch();
				break;
			case 5:
				Utilities.checkDevice(true);
				break;
			case 6:
				Utilities.checkDevice(false);
				break;	
			case 7:
				break;
			default:
				System.out.println("Not a valid menu option.");
			}
			
			System.out.println();
			// closes the program when user enters 7
		} while (input != 7);
		Utilities.sysExit();
	}
}
