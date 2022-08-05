public class Bike extends Items {
	private String bikecolor;

	public Bike(String itemID, String description, double price, String bikecolor, boolean isAvailable) {
		super(itemID, description, price, isAvailable);
		this.bikecolor = bikecolor;

	}

	public String getbikecolor() {
		return bikecolor;
	}

}
