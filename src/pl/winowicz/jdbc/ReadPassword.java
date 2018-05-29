package pl.winowicz.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadPassword {

	public List<String> readPass() throws FileNotFoundException {

		String fileName = "src/pl/winowicz/data/pass.txt";
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		String login = null;
		String pass = null;

		while (scan.hasNextLine()) {
			login = scan.nextLine();
			pass = scan.nextLine();
		}

		scan.close();

		List<String> list = new ArrayList<>();
		list.add(login);
		list.add(pass);
		
		return list;
	}

}
