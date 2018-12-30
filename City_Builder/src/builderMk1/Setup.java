package builderMk1;

import java.io.IOException;

public class Setup {

	public static void main (String args[]) throws IOException {
		CityGenerator cg = new CityGenerator();
		
		CityNameGen cng = new CityNameGen();
		cg.setName(cng.namePicker("C:\\Users\\brace\\eclipse-workspace\\City_Builder\\src\\builderMk1\\cityNames.csv"));
		
		CityTerrainGen ctg = new CityTerrainGen();
		cg.setTerrain(ctg.terrainPicker("C:\\Users\\brace\\eclipse-workspace\\City_Builder\\src\\builderMk1\\cityTerrain.csv"));
		
		CityAgeGen cag = new CityAgeGen();
		cg.setCityAge(cag.ageSet());
		
		System.out.println(cg.getName()+", "+cg.getTerrain()+", "+cg.getCityAge());
	}
}
