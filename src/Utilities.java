//	Miriam Rose, mrose16, CIS 340, MP2

import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {

	static Scanner scnr = new Scanner(System.in);
	static ArrayList<Device> devices = new ArrayList<>();
	
	// method to populate an array list of devices
	public static ArrayList<Device> populateDevices() {
		
		
		// adding 5 sample devices into array
		devices.add(populateDevice("6757A", "Apple 9.7-ince iPad Pro"));
		devices.add(populateDevice("693P51B", "Amazon Kindle Fire Kids Edition"));
		devices.add(populateDevice("10N8C", "LeapFrog Epic Learning Tablet"));
		devices.add(populateDevice("85U2O", "Amazon Kindle Fire HD 8"));
		devices.add(populateDevice("91H2D", "HP Envy 8 Note"));
	
		return devices;
	}
	
	// method to populate a single Device object
	public static Device populateDevice(String sku, String name) {
		
		Device d = new Device();
		
		d.setSKU(sku);
		d.setName(name);
		d.setStatus(true);
		
		return d;
		
	}
	
	// method that displays the list of devices
	public static void displayDevicesList() {
		
		String status = "";
		int number = 1;
		
		System.out.printf("\n%-3s%-12s%-40s%s", "#", "SKU", "Name", "Status");
		
		// loop through the array list 
		for (Device d : devices) {
			
			// if statements sets the status of the device
			if (d.getStatus()) {
				status = "Available";
			}
			else {
				status = "Checked Out";
			}
			
			System.out.printf("\n%-3d%-12s%-40s%s", number++, d.getSKU(), d.getName(), status);
		}
		System.out.println();
	}
	
	// method to add new devices to the list
	public static void addNewDevices() {
		
		Device d = new Device(); 
		d = inputDevice();
		devices.add(d);
		System.out.printf("\nAdded %s to Catalog.\n", d.getName());
		
	}

	// method to change SKU and name of a device in the list
	public static void editDevices() {
		
		int input = 0;
		boolean repeatInput = true;
		
		Device d = new Device(); 
		displayDevicesList();
		
		// loop to ask user which device to edit and handles invalid input error
		do {
			String question = "\nEnter Device number to edit (1-" + devices.size() +"): ";
			System.out.print(question);
			input = verifyInput(scnr.nextLine(), question);
			
			if (input < 1 || input > devices.size()) {
				System.out.println("Device number is not valid. Try again.");
			}
			else {
				repeatInput = false;
			}
		
		} while (repeatInput);
		
		d = inputDevice();
		devices.set(input - 1, d);
		System.out.println("\nDevice Information Updated");
		
	}
	
	// method that searches for devices using inputed keyword
	public static void deviceSearch() {
		
		int number = 1;
		int searchOutput = 0;
		System.out.print("\nEnter Device to search for: ");
		String keyword = scnr.nextLine().toLowerCase();
		
		System.out.printf("\nListings for '%s'", keyword);
		System.out.printf("\n%-3s%-12s%-40s", "#", "SKU", "Name");
		
		// loop through the array list and prints out devices that match keyword
		for ( Device d : devices ) {
			
			if ( d.getName().toLowerCase().contains(keyword)) {
				System.out.printf("\n%-3d%-12s%-40s", number, d.getSKU(), d.getName());
				searchOutput++;
			}
			number++;	
		}
		// message that prints out if no search result was found in the list
		if ( searchOutput < 1 ) {
			System.out.println("\nNo results found.");
		}
		System.out.println();
	}
	
	// method that checks in and checks out devices
	public static void checkDevice(boolean type) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		if (type) {
			System.out.println("\nAvailable Devices\n");
		}
		else {
			System.out.println("\nChecked Out Devices\n");
		}
		String status = "";
		int number = 1;
		System.out.printf("%-3s%-12s%-40s", "#", "SKU", "Name");
		
		// loop that prints out devices that can be checked in or out
		for (Device d : devices) {
			
			if (d.getStatus() == type) {
				
				if (type) {
					status = "Available";
				}
				else {
					status = "Checked Out";
				}
				System.out.printf("\n%-3d%-12s%-40s", number, d.getSKU(), d.getName());
				numbers.add(number);
			}
			number++;
		}
		String question = "\n\nEnter device number: ";
		System.out.print(question);
		int input = verifyInput(scnr.nextLine(), question);
		
		// error handling for invalid input
		if (!numbers.contains(input)) {
			System.out.println("The device selected is not in the list.");
		}
		else {
			devices.get(input - 1).setStatus(!type);	
			if (type) {
				System.out.print("\nDevice Checked Out\n");
			}
			else {
				System.out.print("\nDevice Checked In\n");
			}
		}
	}
	
	// method that prints closing message and exits application
	public static void sysExit() {
		
		System.out.print("Good Bye!");
		System.exit(0);
	}
	
	// method that validates user input
	public static int verifyInput(String input, String question) {
		
		int numberOfErrors = 0;
		int theNumber = 0;
		boolean repeatInput = false;
		
		do {
			try 
			{
				theNumber = Integer.parseInt(input);
				repeatInput = false;
			}
			catch ( NumberFormatException err )
			{
				// if statement that kicks user out of the program after 3 incorrect entries
				if (numberOfErrors == 2) {
					
					System.out.println("\nInput is invalid. Press any key to exit.");
					scnr.nextLine();
					System.exit(0);
				}
				// asks user the same question for new input
				System.out.println("\nInput must be a valid integer. Try again.");
				System.out.println(question);
				input = scnr.nextLine();
				repeatInput = true;
				numberOfErrors++;
			}
		} while (repeatInput);
		
		return theNumber;
		
	}
	
	// method that inputs information into new Device object
	private static Device inputDevice() {
		
		Device d = new Device();
		System.out.print("\nSku: ");
		d.setSKU(scnr.nextLine().toUpperCase());
		System.out.print("Name: ");
		d.setName(scnr.nextLine());
		d.setStatus(true);
		return d;
	}
}
