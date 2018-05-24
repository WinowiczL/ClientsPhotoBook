package pl.winowicz.fxmvc.controller;

import java.sql.SQLException;

import javafx.scene.control.TextField;

public class FindSessionController {

	public void findSession(TextField fillFirstName, TextField fillLastName, TextField fillDescription,
			TextField fillDateOfSession, TextField fillTypeOfSession, TextField fillPriceOfSession)
			throws ClassNotFoundException, SQLException, InterruptedException {

		String firstName = fillFirstName.getText();
		String lastName = fillLastName.getText();
		String description = fillDescription.getText();
		String dateOfSession = fillDateOfSession.getText();
		String typeOfSession = fillTypeOfSession.getText();
		String priceOfSession = fillPriceOfSession.getText();
		
		

	}

}
