public class Feedback {

	private String id;
	private String description;
	private String status;

	public Feedback(String id, String description, String status) {
		this.id = id;
		this.description = description;
		this.status = status;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}