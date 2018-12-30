package builderMk1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class CityNameGen {
	public String namePicker(String pathToFile) throws IOException {
		FileReader fr=new FileReader(pathToFile);    
		BufferedReader br=new BufferedReader(fr);    
		
		String name;
		Random rand  = new Random();
		int numb = rand.nextInt(159);
		int counter = 0;
		
		while ((name = br.readLine()) != null) {
			counter ++;
			if(counter == numb) {
				return name;
			}
		}
		return "Roma";    
	}
}
