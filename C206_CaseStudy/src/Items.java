public class Items {
	private String itemID;
	private String description;
	private double price;
	private boolean isAvailable;

	public Items(String itemID, String description, Double price, Boolean isAvailable) {
		this.itemID = itemID;
		this.description = description;
		this.price = 0.0;
		this.isAvailable = true;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
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

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getItemID() {
		return itemID;
	}

	public String getDescription() {
		return description;
	}

}