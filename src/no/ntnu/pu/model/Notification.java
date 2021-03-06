package no.ntnu.pu.model;

/**
 * Created by Bakkan on 12.03.14.
 */

public abstract class Notification {
	public int id;
	public Appointment appointment;
	public Person recipient;

	public Notification(Person recipient, Appointment appointment) {
		this.appointment = appointment;
		this.recipient = recipient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Person getRecipient() {
		return recipient;
	}

	public void setRecipient(Person recipient) {
		this.recipient = recipient;
	}
}
