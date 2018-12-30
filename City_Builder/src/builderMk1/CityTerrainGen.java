package builderMk1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class CityTerrainGen {
	public String terrainPicker(String pathToFile) throws IOException {
		FileReader fr=new FileReader(pathToFile);    
		BufferedReader br=new BufferedReader(fr);    
		
		String terrain;
		Random rand  = new Random();
		int numb = rand.nextInt(9) + 1;
		int counter = 0;
		
		while ((terrain = br.readLine()) != null) {
			counter ++;
			if(counter == numb) {
				return terrain;
			}
		}
		
		return"Hills";
	}
}
