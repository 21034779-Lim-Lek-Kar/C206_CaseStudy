
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AppMain {
	public static void main(String[] args) {

		// TODO: Add RegEx for appointment date

		// Initialize Array List
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		ArrayList<BikePart> bikePartList = new ArrayList<BikePart>();
		ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

		// Sample Data
		bikeList.add(new Bike("B001", "eXtreme Mountain Bike", 229.99, "Carbon Fiber"));
		bikeList.add(new Bike("B002", "SAVA Road Bike", 159.99, "Steel"));
		bikeList.add(new Bike("B003", "BMC Sports Trail Bike", 200.00, "Titanium"));
		bikeList.add(new Bike("B004", "Cannondale Leisure Bike", 129.99, "Aluminium"));

		bikePartList.add(new BikePart("P001", "Carbonite Lightweight Frame", 99.99, "Bike Frame"));
		bikePartList.add(new BikePart("P002", "Memory Foam Saddle", 159.99, "Seat Saddle"));
		bikePartList.add(new BikePart("P003", "'I love my bike' Bell", 200.00, "Bicycle Bell"));
		bikePartList.add(new BikePart("P004", "Tsunami Aluminium Frame", 129.99, "Bike Frame"));

		buyerList.add(new Buyer("B001", "Tom", 99991111));
		buyerList.add(new Buyer("B002", "Amy", 22223333));
		buyerList.add(new Buyer("B003", "Mark", 33332222));
		buyerList.add(new Buyer("B004", "Jerry", 11119999));

		feedbackList.add(new Feedback("F001", "the order was very slow, i waited for 3 weeks"));
		feedbackList.add(new Feedback("F002", "hello something is missing from my box"));
		feedbackList.add(new Feedback("F003", "product received from the seller very quickly"));
		feedbackList.add(new Feedback("F004", "hi, is P004 still available?"));

		appointmentList.add(new Appointment("A001", LocalDate.of(2022, 8, 8))); // year, month, day
		appointmentList.add(new Appointment("A002", LocalDate.of(2022, 10, 23)));
		appointmentList.add(new Appointment("A003", LocalDate.of(2022, 12, 22)));
		appointmentList.add(new Appointment("A004", LocalDate.of(2023, 1, 3)));

		int option = 0;
		while (option != 5) {
			mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) { //////////////////// Manage Inventory (Unverified: Update BikePartList)
				setHeader("Manage Inventory");
				System.out.println("1. View Inventory");
				System.out.println("2. Add Item");
				System.out.println("3. Update Item Information");
				System.out.println("4. Delete Item");
				int suboption = Helper.readInt("Enter an option > ");

				if (suboption == 1) { // Verified
					viewAllBikes(bikeList);
					viewAllBikeParts(bikePartList);
				} else if (suboption == 2) {
					int itemoption = itemSelect();

					if (itemoption == 1) { // Verified
						Bike newBike = inputBike();
						addBike(bikeList, newBike);
					} else if (itemoption == 2) { // Verified
						BikePart newBikePart = inputBikePart();
						addBikePart(bikePartList, newBikePart);
					} else {
						System.out.println("Invalid selection. Returning to main menu...");
					}
				} else if (suboption == 3) {
					int itemoption = itemSelect();

					if (itemoption == 1) { // Verified
						viewAllBikes(bikeList);
						updateBike(bikeList);
					} else if (itemoption == 2) {
						viewAllBikeParts(bikePartList);
						updateBikePart(bikePartList);
					} else {
						System.out.println("Invalid selection. Returning to main menu...");
					}
				} else if (suboption == 4) {
					int itemoption = itemSelect();

					if (itemoption == 1) { // Verified
						viewAllBikes(bikeList);
						deleteBike(bikeList);
					} else if (itemoption == 2) { // Verified
						viewAllBikeParts(bikePartList);
						deleteBikePart(bikePartList);
					}
				} else {
					System.out.println("Invalid selection. Returning to main menu...");
				}
			} else if (option == 2) { //////////////////// Manage Buyer Profiles (Unverified: Update Buyer
										//////////////////// Information)
				setHeader("Manage Buyer Profiles");
				System.out.println("1. View Buyer Information");
				System.out.println("2. Register Buyer");
				System.out.println("3. Update Buyer Information");
				System.out.println("4. Search Buyer by ID");
				System.out.println("5. Search Buyer by Name");
				System.out.println("6. Search Buyer by Phone No");
				int suboption = Helper.readInt("Enter an option > ");

				if (suboption == 1) { // Verified
					viewAllBuyers(buyerList);
				} else if (suboption == 2) { // Verified
					Buyer newBuyer = inputBuyer();
					addBuyer(buyerList, newBuyer);
				} else if (suboption == 3) {
					viewAllBuyers(buyerList);
					updateBuyer(buyerList);
				} else if (suboption == 4) { // Verified
					searchBuyerById(buyerList);
				} else if (suboption == 5) { // Verified
					searchBuyerByName(buyerList);
				} else if (suboption == 6) { // Verified
					searchBuyerByPhoneNo(buyerList);
				} else {
					System.out.println("Invalid selection. Returning to main menu...");
				}
			} else if (option == 3) { //////////////////// Manage Appointments
				setHeader("Manage Appointments");
				System.out.println("1. View Appointments");
				System.out.println("2. Create Appointment");
				System.out.println("3. Update Appointment Information");
				System.out.println("4. Delete Appointment");
				System.out.println("5. Search Appointment by Date");
				System.out.println("6. Search Appointment by Buyer's ID");
				int suboption = Helper.readInt("Enter an option > ");

				if (suboption == 1) { // Verified
					viewAllAppointments(appointmentList);
				} else if (suboption == 2) { // Verified
					Appointment newAppointment = inputAppointment();
					addAppointment(appointmentList, newAppointment);
				} else if (suboption == 3) {
					System.out.println("## Not Coded ##");
					// TODO
				} else if (suboption == 4) {
					System.out.println("## Not Coded ##");
					// TODO
				} else if (suboption == 5) {
					searchAppointmentByDate(appointmentList);
				} else if (suboption == 6) {
					searchAppointmentByID(appointmentList);
				} else {
					System.out.println("Invalid selection. Returning to main menu...");
				}
			} else if (option == 4) { //////////////////// Manage Feedback
				setHeader("Manage Feedback");
				System.out.println("1. View Feedback");
				System.out.println("2. Record Feedback");
				System.out.println("3. Respond to Feedback");
				System.out.println("4. Update Feedback Status");
				System.out.println("5. Delete Feedback");
				int suboption = Helper.readInt("Enter an option > ");

				if (suboption == 1) { // Verified
					viewAllFeedback(feedbackList);
				} else if (suboption == 2) { // Verified
					Feedback newFeedback = inputFeedback();
					addFeedback(feedbackList, newFeedback);
				} else if (suboption == 3) {
					System.out.println("## Not Coded ##");
					// TODO
				} else if (suboption == 4) { // Verified
					viewAllFeedback(feedbackList);
					updateFeedbackStatus(feedbackList);
				} else if (suboption == 5) {
					System.out.println("## Not Coded ##");
					// TODO
				} else {

					System.out.println("Invalid selection. Returning to main menu...");
				}
			} else if (option == 5) { // Quit
				System.out.println("Thank you for using Biker's Portal.");
			} else {
				System.out.println("Invalid selection. Returning to main menu...");
			}
		}
	}

	/*
	 * ############################ End of Code
	 * 
	 * Method Implementations below ############################
	 */

	// ================================ (Create) Bike & Bike Parts
	// ================================
	public static Bike inputBike() {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		String frameMaterial = Helper.readString("Enter frame material > ");

		Bike newBike = new Bike(id, name, price, frameMaterial);
		return newBike;
	}

	public static void addBike(ArrayList<Bike> bikeList, Bike newBike) {
		bikeList.add(newBike);
		System.out.println("New bike sucessfully added.");
	}

	public static BikePart inputBikePart() {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		String category = Helper.readString("Enter category > ");

		BikePart newBikePart = new BikePart(id, name, price, category);
		return newBikePart;
	}

	public static void addBikePart(ArrayList<BikePart> bikePartList, BikePart newBikePart) {
		bikePartList.add(newBikePart);
		System.out.println("New bike part sucessfully added.");
	}

	// ================================ (Read) Bike & Bike Parts
	// ==================================
	public static void viewAllBikes(ArrayList<Bike> bikeList) {
		setHeader(">> BIKE LIST");
		String output = String.format("%-5s %-25s %-10s %-11s %s\n", "ID", "NAME", "PRICE", "AVAILABLE",
				"FRAME MATERIAL");

		for (int i = 0; i < bikeList.size(); i++) {

			output += String.format("%-5s %-25s %-10s %-11s %s\n", bikeList.get(i).getId(), bikeList.get(i).getName(),
					bikeList.get(i).getPrice(), showAvailability(bikeList.get(i).getIsAvailable()),
					bikeList.get(i).getFrameMaterial());
		}
		System.out.println(output);
	}

	public static void viewAllBikeParts(ArrayList<BikePart> bikePartList) {
		setHeader(">> BIKE PART LIST");
		String output = String.format("%-5s %-30s %-10s %-11s %s\n", "ID", "NAME", "PRICE", "AVAILABLE", "CATEGORY");

		for (int i = 0; i < bikePartList.size(); i++) {

			output += String.format("%-5s %-30s %-10s %-11s %s\n", bikePartList.get(i).getId(),
					bikePartList.get(i).getName(), bikePartList.get(i).getPrice(),
					showAvailability(bikePartList.get(i).getIsAvailable()), bikePartList.get(i).getCategory());
		}
		System.out.println(output);
	}

	// ================================ (Update) Bike & Bike Parts
	// ================================
	public static void updateBike(ArrayList<Bike> bikeList) {
		String id = Helper.readString("Enter id to update > ");

		boolean noResult = true; // Search if id exists first
		for (int i = 0; i < bikeList.size(); i++) {
			if (bikeList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}

		if (noResult == false) { // If id found...
			String name = Helper.readString("Enter name to update > ");
			double price = Helper.readDouble("Enter price to update > ");
			char availability = Helper.readChar("Enter availability > (y/n) ");
			String frameMaterial = Helper.readString("Enter frame material > ");

			for (int i = 0; i < bikeList.size(); i++) {
				if (bikeList.get(i).getId().equals(id)) {
					bikeList.get(i).setName(name);
					bikeList.get(i).setPrice(price);
					if (Character.toLowerCase(availability) == 'y') {
						bikeList.get(i).setIsAvailable(true);
					} else {
						if (Character.toLowerCase(availability) == 'n') {
							bikeList.get(i).setIsAvailable(false);
						}
					}
					bikeList.get(i).setFrameMaterial(frameMaterial);
				}
			}
			System.out.println("Bike List has been updated!");
		} else { // if id not found...
			System.out.println("ID entered was not found in the records.");
		}
	}

	public static void updateBikePart(ArrayList<BikePart> bikePartList) {
		String id = Helper.readString("enter id to update > ");

		boolean noResult = true; // Search if id exists first
		for (int i = 0; i < bikePartList.size(); i++) {
			if (bikePartList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}

		if (noResult == false) { // If id found...
			String name = Helper.readString("enter name to update > ");
			double price = Helper.readDouble("enter price to update > ");
			char availability = Helper.readChar("enter availability > (y/n) ");
			String category = Helper.readString("enter category > ");

			for (int i = 0; i < bikePartList.size(); i++) {
				if (bikePartList.get(i).getId().equals(id)) {
					bikePartList.get(i).setName(name);
					bikePartList.get(i).setPrice(price);
					if (Character.toLowerCase(availability) == 'y') {
						bikePartList.get(i).setIsAvailable(true);
					} else {
						if (Character.toLowerCase(availability) == 'n') {
							bikePartList.get(i).setIsAvailable(false);
						}
					}
					bikePartList.get(i).setCategory(category);
				}
			}
			System.out.println("Bike Part List has been updated!");
		} else { // if id not found...
			System.out.println("ID entered was not found in the records.");
		}
	}

	// ================================ (Delete) Bike & Bike Parts
	// ================================
	public static void deleteBike(ArrayList<Bike> bikeList) {
		String id = Helper.readString("Enter id to delete > ");

		boolean noResult = true; // Search if id exists first
		for (int i = 0; i < bikeList.size(); i++) {
			if (bikeList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}

		if (noResult == false) { // if id found...
			for (int i = 0; i < bikeList.size(); i++) {
				if (bikeList.get(i).getId().equals(id)) {
					char confirm = Helper.readChar("Are you sure you want to delete record " + id + " (y/n) > ");
					if (Character.toLowerCase(confirm) == 'y') {
						bikeList.remove(i);
						System.out.println("Record " + id + " has been deleted.");
					} else {

						System.out.println("User has cancelled deletion.");
					}
				}
			}
		} else { // if id not found...
			System.out.println("ID entered was not found in the records.");
		}
	}

	public static void deleteBikePart(ArrayList<BikePart> bikePartList) {
		String id = Helper.readString("Enter id to delete > ");

		boolean noResult = true; // Search if id exists first
		for (int i = 0; i < bikePartList.size(); i++) {
			if (bikePartList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}

		if (noResult == false) { // if id found...
			for (int i = 0; i < bikePartList.size(); i++) {
				if (bikePartList.get(i).getId().equals(id)) {
					char confirm = Helper.readChar("Are you sure you want to delete record " + id + " (y/n) > ");
					if (Character.toLowerCase(confirm) == 'y') {
						bikePartList.remove(i);
						System.out.println("Record " + id + " has been deleted.");
					} else {
						System.out.println("User has cancelled deletion.");
					}
				}
			}
		} else { // if id not found...
			System.out.println("ID entered was not found in the records.");
		}
	}

	// ================================ (Search) Bike & Bike Parts
	// ================================

	// ================================ (Create) Buyer Profiles
	// ===================================
	public static Buyer inputBuyer() {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		int phoneNo = Helper.readInt("Enter phone number > ");

		Buyer newBuyer = new Buyer(id, name, phoneNo);
		return newBuyer;
	}

	public static void addBuyer(ArrayList<Buyer> buyerList, Buyer newBuyer) {
		buyerList.add(newBuyer);
		System.out.println("New buyer sucessfully added.");
	}

	// ================================ (Read) Buyer Profiles
	// =====================================
	public static void viewAllBuyers(ArrayList<Buyer> buyerList) {
		setHeader(">> BUYER PROFILES");
		String output = String.format("%-6s %-7s %s\n", "ID", "NAME", "PHONE NO.");

		for (int i = 0; i < buyerList.size(); i++) {

			output += String.format("%-6s %-7s %s\n", buyerList.get(i).getId(), buyerList.get(i).getName(),
					buyerList.get(i).getPhoneNo());
		}
		System.out.println(output);
	}

	// ================================ (Update) Buyer Profiles
	// ===================================
	public static void updateBuyer(ArrayList<Buyer> buyerList) {
		String id = Helper.readString("Enter id to update > ");

		boolean noResult = true; // Search if id exists
		for (int i = 0; i < buyerList.size(); i++) {
			if (buyerList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}

		if (noResult == false) { // If id found
			String name = Helper.readString("Enter name to update > ");
			int phoneNo = Helper.readInt("Enter phone number to update > ");

			for (int i = 0; i < buyerList.size(); i++) {
				if (buyerList.get(i).getId().equals(id)) {
					buyerList.get(i).setName(name);
					buyerList.get(i).setPhoneNo(phoneNo);
				}
			}
			System.out.println("Buyer profile has been updated!");
		} else { // if id not found
			System.out.println("ID entered was not found in the records.");
		}
	}

	// ================================ (Search) Buyer Profiles
	// ===================================
	public static void searchBuyerById(ArrayList<Buyer> buyerList) {

		String id = Helper.readString("Enter id to search > ");

		boolean noResult = true; // Search if id exists first
		for (int i = 0; i < buyerList.size(); i++) {
			if (buyerList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}

		if (noResult == false) { // if name found...
			for (int i = 0; i < buyerList.size(); i++) {
				if (buyerList.get(i).getId().equals(id)) {
					setHeader(">> BUYER PROFILES");
					String output = String.format("%-6s %-7s %s\n", "ID", "NAME", "PHONE NO.");
					output += String.format("%-6s %-7s %s\n", buyerList.get(i).getId(), buyerList.get(i).getName(),
							buyerList.get(i).getPhoneNo());
					System.out.println(output);
				}
			}
		} else { // if id not found...
			System.out.println("ID entered was not found in the records.");
		}
	}

	public static void searchBuyerByName(ArrayList<Buyer> buyerList) {

		String name = Helper.readString("Enter name to search > ");

		boolean noResult = true; // Search if name exists first
		for (int i = 0; i < buyerList.size(); i++) {
			if (buyerList.get(i).getName().equals(name)) {
				noResult = false;
			}
		}

		if (noResult == false) { // if name found...
			for (int i = 0; i < buyerList.size(); i++) {
				if (buyerList.get(i).getName().equals(name)) {
					setHeader(">> BUYER PROFILES");
					String output = String.format("%-6s %-7s %s\n", "ID", "NAME", "PHONE NO.");
					output += String.format("%-6s %-7s %s\n", buyerList.get(i).getId(), buyerList.get(i).getName(),
							buyerList.get(i).getPhoneNo());
					System.out.println(output);
				}
			}
		} else { // if name not found...
			System.out.println("Name entered was not found in the records.");
		}
	}

	public static void searchBuyerByPhoneNo(ArrayList<Buyer> buyerList) {

		int phoneNo = Helper.readInt("Enter phone number to search > ");

		boolean noResult = true; // Search if phone no. exists first
		for (int i = 0; i < buyerList.size(); i++) {
			if (buyerList.get(i).getPhoneNo() == (phoneNo)) {
				noResult = false;
			}
		}

		if (noResult == false) { // if phone no. found...
			for (int i = 0; i < buyerList.size(); i++) {
				if (buyerList.get(i).getPhoneNo() == (phoneNo)) {
					setHeader(">> BUYER PROFILES");
					String output = String.format("%-6s %-7s %s\n", "ID", "NAME", "PHONE NO.");
					output += String.format("%-6s %-7s %s\n", buyerList.get(i).getId(), buyerList.get(i).getName(),
							buyerList.get(i).getPhoneNo());
					System.out.println(output);
				}
			}
		} else { // if phone no. not found...
			System.out.println("Phone number entered was not found in the records.");
		}
	}

	// ================================ (Create) Appointment
	// =======================================
	public static Appointment inputAppointment() {
		String id = Helper.readString("Enter id > ");
		String apptDate = Helper.readString("Enter appointment date (yyyy-MM-dd) > ");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate apptDateLD = LocalDate.parse(apptDate, dtf);

		Appointment newAppointment = new Appointment(id, apptDateLD);
		return newAppointment;
	}

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment newAppointment) {
		appointmentList.add(newAppointment);
		System.out.println("New appointment sucessfully added.");
	}

	// ================================ (Read) Appointment
	// =========================================
	public static void viewAllAppointments(ArrayList<Appointment> appointmentList) {
		setHeader(">> APPOINTMENTS");
		String output = String.format("%-5s %s\n", "ID", "APPOINTMENT DATE");

		for (int i = 0; i < appointmentList.size(); i++) {

			output += String.format("%-5s %s\n", appointmentList.get(i).getId(), appointmentList.get(i).getApptDate());
		}
		System.out.println(output);
	}

	// ================================ (Update) Appointment
	// =======================================
	// ================================ (Delete) Appointment
	// =======================================
	// ================================ (Search) Appointment
	// =======================================
	public static void searchAppointmentByID(ArrayList<Appointment> appointmentList) {

		String id = Helper.readString("Enter id to search > ");

		boolean noResult = true;
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}
		if (noResult == false) {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (appointmentList.get(i).getId().equals(id)) {
					setHeader(">> ID APPOINTMENT");
					String output = String.format("%-6s %-7s\n", "ID", "APPOINTMENT DATE");
					output += String.format("%-6s %-7s\n", appointmentList.get(i).getId(),
							appointmentList.get(i).getApptDate());
					System.out.println(output);
				}
			}
		}
		System.out.println("Name entered was not found in the records.");
	}

	public static void searchAppointmentByDate(ArrayList<Appointment> appointmentList) {

		String date = Helper.readString("Enter date to search > ");

		boolean noResult = true;
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getApptDate().equals(date)) {
				noResult = false;
			}
		}
		if (noResult == false) {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (appointmentList.get(i).getApptDate().equals(date)) {
					setHeader(">> DATE APPOINTMENT");
					String output = String.format("%-6s %-7s\n", "ID", "APPOINTMENT DATE");
					output += String.format("%-6s %-7s\n", appointmentList.get(i).getId(),
							appointmentList.get(i).getApptDate());
					System.out.println(output);
				}
			}
		}
		System.out.println("Date entered was not found in the records.");
	}

	// ================================ (Create) Feedback
	// =========================================
	public static Feedback inputFeedback() {
		String id = Helper.readString("Enter id > ");
		String description = Helper.readString("Enter feedback > ");

		Feedback newFeedback = new Feedback(id, description, date);
		return newFeedback;
	}

	public static void addFeedback(ArrayList<Feedback> feedbackList, Feedback newFeedback) {
		feedbackList.add(newFeedback);
		System.out.println("New feedback successfully added.");
	}

	// ================================ (Read) Feedback
	// ===========================================
	public static void viewAllFeedback(ArrayList<Feedback> feedbackList) {
		setHeader(">> FEEDBACK LIST");
		String output = String.format("%-5s %-10s %-50s %s\n", "ID", "STATUS", "FEEDBACK", "RESPONSE");

		for (int i = 0; i < feedbackList.size(); i++) {

			output += String.format("%-5s %-10s %-50s %s\n", feedbackList.get(i).getId(),
					feedbackList.get(i).getStatus(), feedbackList.get(i).getDescription(),
					feedbackList.get(i).getResponse());
		}
		System.out.println(output);
	}

	// ================================ (Update) Feedback
	// =========================================
	public static void updateFeedbackStatus(ArrayList<Feedback> feedbackList) {
		String id = Helper.readString("Enter id to update > ");

		boolean noResult = true; //
		for (int i = 0; i < feedbackList.size(); i++) {
			if (feedbackList.get(i).getId().equals(id)) {
				noResult = false;
			}
		}

		if (noResult == false) { //
			char status = Helper.readChar("Enter new status (p = Pending/s = Solved) > ");

			for (int i = 0; i < feedbackList.size(); i++) {

				if (feedbackList.get(i).getId().equals(id)) {

					if (Character.toLowerCase(status) == 's') {
						feedbackList.get(i).setStatus("Solved");
					} else {
						feedbackList.get(i).setStatus("Pending");
					}
				}
			}
			System.out.println("Feedback List has been updated!");
		} else { //
			System.out.println("ID entered was not found in the records.");
		}
	}

	// ================================ (Delete) Feedback
	// =========================================
	// ================================ Check Availability
	// ========================================
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// ================================ User Interface Methods
	// ====================================
	private static void mainMenu() {
		Helper.line(80, "-");
		System.out.println("BIKER'S PORTAL");
		Helper.line(80, "-");
		System.out.println("1. Manage Inventory");
		System.out.println("2. Manage Buyer Profiles");
		System.out.println("3. Manage Appointments");
		System.out.println("4. Manage Feedback");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static int itemSelect() {
		setHeader("Choose item: ");
		System.out.println("1. Bike");
		System.out.println("2. Bike Part");
		int itemoption = Helper.readInt("Enter option to select item type > ");
		return itemoption;
	}
}