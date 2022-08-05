import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// adding of different lists
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		ArrayList<Bikepart> bikepartList = new ArrayList<Bikepart>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Register> registerList = new ArrayList<Register>();
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

		// adding of objects into lists
		bikeList.add(new Bike("F10001", "Honda", 20000.00, "Black", true)); // b1
		bikeList.add(new Bike("F10002", "Tesla", 45000.00, "White", true)); // b2
		bikepartList.add(new Bikepart("BP001", "ZONKIE 6/7/8 Speed Bike Chain", 50.0, true, "ZONKIE"));
		bikepartList.add(new Bikepart("BP002", "Shimano Deore M6100,brakes", 30.0, true, "Shimano"));
		bikepartList.add(new Bikepart("BP003", "CAMPER MATTERS 6/7/8 Speed Bike Chain", 50.0, true, "ZONKIE"));
		appointmentList.add(new Appointment("AP0011", "2022-07-07")); // a1
		appointmentList.add(new Appointment("AP0012", "2022-06-06")); // a2
		registerList.add(new Register("001", "Amm", 35));
		registerList.add(new Register("002", "Buu", 28));
		feedbackList.add(new Feedback("FB1", "12-11-2021", "Pending"));
		feedbackList.add(new Feedback("FB2", "12-12-2021", "Solved"));
		feedbackList.add(new Feedback("FB3", "13-12-2021", "Rejected"));

		int option = 0;
		while (option != 5) {
			mainmenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// display inventory
				setHeader("Manage Inventory");
				submenu1();
				int what_to_do = Helper.readInt("Enter an option on what action to take > ");
				if (what_to_do == 1) {
					inventorymenu();
					int view_inventory = Helper.readInt("Enter option to view from inventory > ");
					if (view_inventory == 1) {
						Bike newbike = inputBike();
						addBike(bikeList, newbike);
					} else if (view_inventory == 2) {
						Bikepart newBikePart = inputBikepart();
						addBikepart(bikepartList, newBikePart);
					}

				} else if (what_to_do == 2) {

					viewAllBike(bikeList);
					viewAllBikepart(bikepartList);

				} else if (what_to_do == 3) {
					inventorymenu();
					int delete_inventory = Helper.readInt("Enter option to delete from inventory > ");
					if (delete_inventory == 1) {
						viewAllBike(bikeList);
						deleteBike(bikeList);
					} else if (delete_inventory == 2) {
						viewAllBikepart(bikepartList);
						deleteBikePart(bikepartList);
					} else {
						System.out.println("Invalid option entered");
					}

				}
			} else if (option == 2) { // manage registration

			} else if (option == 3) { // manage appointment
				setHeader("Manage Appointments");
				submenu2();
				int appt_to_do = Helper.readInt("Enter the option to do with appointments > ");
				if (appt_to_do == 1) { // create appt
					Appointment newAppointment = inputAppointment();
					addAppointment(appointmentList, newAppointment);
				} else if (appt_to_do == 2) { // view appt
					viewAllAppointment(appointmentList);
				} else if (appt_to_do == 3) { // delete appt
					viewAllAppointment(appointmentList);
					deleteAppointment(appointmentList);
				} else {
					System.out.println("Invalid option entered");

				}
			} else if (option == 4) { // manage feedback
				setHeader("Manage Feedback");
				submenu3();
				int fb_option = Helper.readInt("Enter the option to do with feedbacks > ");
				if (fb_option == 1) {
					Feedback newfb = inputFeedback();
					addFeedback(feedbackList, newfb);
				} else if (fb_option == 2) {
					viewAllFeedback(feedbackList);
				} else if (fb_option == 3) {
					viewAllFeedback(feedbackList);
					deleteFeedback(feedbackList);
				}

			} else {
				System.out.println("Invalid option entered, Please Try Again.");
			}
		}

	}

	public static void setHeader(String header) {
		Helper.line(40, "=");
		System.out.println(header);
		Helper.line(40, "=");
	}

	// add bike into bike list =======
	public static Bike inputBike() {
		String itemid = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		double price = Helper.readDouble("Enter the price of the bike > ");
		String color = Helper.readString("Enter color of the bike > ");
		Boolean avail = Helper.readBoolean("Enter true or false on the availability status > ");

		Bike bb = new Bike(itemid, description, price, color, avail);
		return bb;

	}

	public static void addBike(ArrayList<Bike> bikeList, Bike bb) {

		bikeList.add(bb);
		System.out.println("Bike has been added successfully");
	}

	// view bike from bike list

	public static void viewAllBike(ArrayList<Bike> bikeList) {
		C206_CaseStudy.setHeader("BIKE LIST");
		String output = String.format("%-10s %-30s %-10s %-10s\n", "ITEM ID", "DESCRIPTION", "AVAILABLE", "COLOR");

		for (int i = 0; i < bikeList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-10s\n", bikeList.get(i).getItemID(),
					bikeList.get(i).getDescription(), showAvailability(bikeList.get(i).isAvailable()),
					bikeList.get(i).getbikecolor());
		}

		System.out.println(output);
	}

	// delete from bike list
	public static Bike deleteBike(ArrayList<Bike> bikeList) {
		String itemid = Helper.readString("Enter item id to delete from > ");
		boolean found = false;

		for (int i = 0; i < bikeList.size(); i++) {
			if (bikeList.get(i).getItemID().equals(itemid)) {
				found = true;
				String delete = Helper.readString("Do you want to delete: (Y/N) " + itemid);
				if (delete.equalsIgnoreCase("y")) {
					bikeList.remove(i);
					System.out.println("Bike has been deleted");
				}
			} else {
				System.out.println("Bike delete unsuccessful");
			}

		}
		return null;
	}

	// add bike parts to bike part list
	public static Bikepart inputBikepart() {
		String id = Helper.readString("Enter item id > ");
		String name = Helper.readString("Enter Name > ");
		double price = Helper.readDouble("Enter price > ");
		String brand = Helper.readString("Enter Brand > ");

		Bikepart newBikepart = new Bikepart(id, name, price, brand);
		return newBikepart;
	}

	public static void addBikepart(ArrayList<Bikepart> bikepartList, Bikepart newBikepart) {
		bikepartList.add(newBikepart);
		System.out.println("New bike part successfully added");
	}

	// view bike parts from bike part list
	public static String retrieveAllBikepart(ArrayList<Bikepart> bikepartList) {
		// TODO Auto-generated method stub
		// view bike from list
		String output = "";
		for (int i = 0; i < bikepartList.size(); i++) {
			output += String.format("%-5s %-25s %-10s %-11s %s\n", bikepartList.get(i).getItemID(),
					bikepartList.get(i).getDescription(), bikepartList.get(i).getPrice(),
					bikepartList.get(i).getBrand());
		}
		return output;
	}

	public static void viewAllBikepart(ArrayList<Bikepart> bikepartList) {
		C206_CaseStudy.setHeader("BIKE LIST");
		String output = String.format("%-10s %-30s %-10s %-10s\n", "ITEM ID", "DESCRIPTION", "PRICE", "BRAND");
		output += retrieveAllBikepart(bikepartList);
		System.out.println(output);
	}

	// delete from bike part list
	public static Bike deleteBikePart(ArrayList<Bikepart> bikepartList) {
		String id = Helper.readString("Enter item id to delete from > ");
		boolean found = false;

		for (int i = 0; i < bikepartList.size(); i++) {
			if (bikepartList.get(i).getItemID().equals(id)) {
				found = true;
				String delete = Helper.readString("Do you want to delete: (Y/N) " + id);
				if (delete.equalsIgnoreCase("y")) {
					bikepartList.remove(i);
					System.out.println("Bike has been deleted");
				}
			} else {
				System.out.println("Bike delete unsuccessfull");
			}

		}
		return null;
	}

	// add register
	public static Register inputRegister() {
		String iD = Helper.readString("Enter ID > ");
		String name = Helper.readString("Enter name > ");
		int phonenumber = Helper.readInt("Enter phonenumber > ");

		Register newRegister = new Register(iD, name, phonenumber);
		return newRegister;
	}

	public static void AddRegister(ArrayList<Register> registerList, Register newRegister) {
		// TODO Auto-generated method stub
		registerList.add(newRegister);
		System.out.println("New register successfully added");
	}

	// view register
	public static String retrieveAllRegister(ArrayList<Register> registerList) {

		String output = "";

		for (int i = 0; i < registerList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", registerList.get(i).getiD(), registerList.get(i).getName(),
					registerList.get(i).getphonenumber());
		}
		return output;
	}

	private static void viewAllRegister(ArrayList<Register> registerList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("REGISTER LIST");
		String output = String.format("%-10s %-30s %-10s\n", "ID", "NAME", "PHONENUMBER");
		output += retrieveAllRegister(registerList);
		System.out.println(output);
	}

	// delete register

	public static void deleteRegiser(ArrayList<Register> registerList) {
		// C206_CaseStudy.viewAllRegister(registerList);
		String iD = Helper.readString("Enter ID > ");
		Boolean isDeleted = deleteRegister(registerList, iD);

		if (isDeleted == false) {
			System.out.println("Invalid delete");
		} else {
			System.out.println(iD + " deleted. ");
		}
	}

	// add appointment
	public static Appointment inputAppointment() {
		String appointmentid = Helper.readString("Enter AppointmentID ");
		String date = Helper.readString("date ");

		Appointment ap = new Appointment(appointmentid, date);
		return ap;

	}

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment ap) {

		appointmentList.add(ap);

	}

	// view appt
	public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {
		String output = "";

		for (int i = 0; i < appointmentList.size(); i++) {

			output += String.format(("%-10s %-20s\n"), appointmentList.get(i).getAppointmentID(),
					appointmentList.get(i).getDate());
		}
		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {
		C206_CaseStudy.setHeader("APPOINTMENT LIST");
		String output = String.format("%-10s %-20s\n", "APPOINTMENTID", "DATE");
		output += retrieveAllAppointment(appointmentList);
		System.out.println(output);
	}

	// delete appt
	public static void deleteAppointment(ArrayList<Appointment> appointmentList) {
		String id = Helper.readString("Enter the appointment id to delete > ");

		boolean found = false;

		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID().equals(id)) {
				found = true;
				String delete = Helper.readString("Do you want to delete: " + id);
				if (delete.equalsIgnoreCase("yes")) {
					appointmentList.remove(i);
					System.out.println("Appointment " + id + " has been deleted");
				}
			} else {
				System.out.println("appointment deleted unsuccessful");
			}

		}

	}

	// add feedback
	public static Feedback inputFeedback() {
		String id = Helper.readString("Enter id > ");
		String description = Helper.readString("Enter feedback description > ");
		String status = Helper.readString("Enter feedback status > ");

		Feedback newfb = new Feedback(id, description, status);
		return newfb;
	}

	public static void addFeedback(ArrayList<Feedback> feedbackList, Feedback newfb) {
		feedbackList.add(newfb);
		System.out.println("New feedback successfully added.");
	}

	// view feedback
	public static String retrieveAllFeedback(ArrayList<Feedback> feedbackList) {
		String output = "";

		for (int i = 0; i < feedbackList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", feedbackList.get(i).getID(),
					feedbackList.get(i).getStatus());
		}
		return output;
	}

	public static void viewAllFeedback(ArrayList<Feedback> feedbackList) {
		C206_CaseStudy.setHeader("FEEDBACK LIST");
		String output = String.format("%-5s %-10s %-50s %s\n", "ID", "STATUS", "DESCRIPTION");

		for (int i = 0; i < feedbackList.size(); i++) {

			output += String.format("%-5s %-10s %-50s %s\n", feedbackList.get(i).getID(),
					feedbackList.get(i).getStatus(), feedbackList.get(i).getDescription());
		}
		System.out.println(output);
	}

	// delete feedback
	public static void deleteFeedback(ArrayList<Feedback> feedbackList) {

	}

	// main menu
	public static void mainmenu() {
		Helper.line(80, "-");
		C206_CaseStudy.setHeader("BLC APP ");
		Helper.line(80, "-");
		System.out.println("1. Manage Inventory");
		System.out.println("2. Manage Registration");
		System.out.println("3. Manage Appointments");
		System.out.println("4. Manage Feedback");
		System.out.println("5. QUIT");
		Helper.line(80, "-");
	}

	public static void inventorymenu() {
		System.out.println("1. Bike");
		System.out.println("2. Bike Parts");
	}

	// bike and bike part menu
	public static void submenu1() {
		System.out.println("1. Add Item");
		System.out.println("2. View Inventory");
		System.out.println("3. Delete Item ");
	}

	// appointment menu
	public static void submenu2() {
		System.out.println("1. Add Appointment");
		System.out.println("2. View Appointment");
		System.out.println("3. Delete Appointment");
	}

	// feedback menu
	public static void submenu3() {
		System.out.println("1. Add Feedback");
		System.out.println("2. View Feedback ");
		System.out.println("3. Delete Feedback");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

}
