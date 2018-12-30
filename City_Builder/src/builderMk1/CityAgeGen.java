package builderMk1;

import java.io.IOException;
import java.util.Random;

public class CityAgeGen {
	public int ageSet() throws IOException {
		String [] ageGroups = {"0-10","11-50","51-100","101-500","501-12000"};
		Random rand  = new Random();
		int randNum = rand.nextInt(ageGroups.length);
		String group = ageGroups[randNum];
		
		String [] groupSplit = group.split("-");
		int age = rand.nextInt(Integer.parseInt(groupSplit[1]) - Integer.parseInt(groupSplit[0])) + Integer.parseInt(groupSplit[0]);
		return age;
	}
}
