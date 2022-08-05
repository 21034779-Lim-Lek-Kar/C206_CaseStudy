public class Bikepart extends Items {
	private String brand;

	public Bikepart(String itemID, String description, double price, Boolean isAvailable, String brand) {
		super(itemID, description, price, isAvailable);
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

}