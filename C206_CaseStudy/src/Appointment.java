public class Appointment {
	private String date;
	private String appointmentID;

	public Appointment(String appointmentID, String date) {
		// TODO Auto-generated constructor stub
		this.date = date;
		this.appointmentID = appointmentID;

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
}