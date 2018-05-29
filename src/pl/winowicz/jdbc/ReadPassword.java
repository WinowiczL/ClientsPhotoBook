package pl.winowicz.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadPassword {
	
	 
	
	public String readPass() throws FileNotFoundException {
		
		String fileName = "src/pl/winowicz/data/pass.txt";
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        String pass = null;
       
        while(scan.hasNextLine()) {
             pass = scan.nextLine();
        }
        
        scan.close();
        return pass;
	}

}
