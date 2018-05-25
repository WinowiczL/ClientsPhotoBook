package pl.winowicz.data;

import javafx.beans.property.SimpleStringProperty;

public class Client {

	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty description;
	private SimpleStringProperty dateOfSession;
	private SimpleStringProperty typeOfSession;
	private SimpleStringProperty priceOfSession;

	public Client(String firstName, String lastName, String description, String dateOfSession, String typeOfSession,
			String priceOfSession) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.description = new SimpleStringProperty(description);
		this.dateOfSession = new SimpleStringProperty(dateOfSession);
		this.typeOfSession = new SimpleStringProperty(typeOfSession);
		this.priceOfSession = new SimpleStringProperty(priceOfSession);
	}

	public Client() {

	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public String getDateOfSession() {
		return dateOfSession.get();
	}

	public void setDateOfSession(String dateOfSession) {
		this.dateOfSession.set(dateOfSession);
	}

	public String getTypeOfSession() {
		return typeOfSession.get();
	}

	public void setTypeOfSession(String typeOfSession) {
		this.typeOfSession.set(typeOfSession);
	}

	public String getPriceOfSession() {
		return priceOfSession.get();
	}

	public void setPriceOfSession(String priceOfSession) {
		this.priceOfSession.set(priceOfSession);
	}

	@Override
	public String toString() {
		return ("Name of Client: " + firstName + "\nSurname of Client: " + lastName + "\nDescription: " + description
				+ "\nDate of Session: " + dateOfSession + "\nType of Session: " + typeOfSession + "\nPrice of Session: "
				+ priceOfSession + "\n");
	}
}
