package pl.winowicz.fxmvc.buttonReactions;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import pl.winowicz.jdbc.JdbcMain;

public class DeleteButtonReaction {
	
	JdbcMain jdbcMain = new JdbcMain();

	public void deleteRecord(javafx.scene.control.TextField fillDelete) throws ClassNotFoundException, SQLException, FileNotFoundException {

		String value = fillDelete.getText();
		
		String queryDelete = "DELETE FROM sessions WHERE id = '" + value + "';";

		jdbcMain.jdbcUpdate(queryDelete);

		fillDelete.setText(null);
	}
}
