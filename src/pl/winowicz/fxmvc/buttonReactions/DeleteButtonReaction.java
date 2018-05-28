package pl.winowicz.fxmvc.buttonReactions;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DeleteButtonReaction {

	public void deleteRecord(javafx.scene.control.TextField fillDelete) throws ClassNotFoundException, SQLException, InterruptedException {

		String value = fillDelete.getText();

		final String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);

		final String dbPath = "jdbc:mysql://localhost:3306/sys";
		Connection conn = (Connection) DriverManager.getConnection(dbPath, "root", "qwerty123");

		Statement statement = conn.createStatement();
		
		String queryInsert = "DELETE FROM sessions WHERE id = '" + value + "';";
		final String sqlQueryInsert = queryInsert;
		statement.executeUpdate(sqlQueryInsert);

		if (statement != null) {
			statement.close();
		}
	
		if (conn != null) {
			conn.close();
		}

		fillDelete.setText(null);
	}
}
