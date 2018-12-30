package builderMk1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Generate different sets of tiles depending on the centraltile
 * desert should be surrounded by more desert/mountains for example
 * is tile a hill or a flat?
 */

public class CityTerrainGen {
	public String terrainPicker(boolean costal) throws IOException {
		String [] terrianOptions = {"Desert","Grasslands","Tundra","Snow","Plains","Jungles","Forests","Mountain"};
		String centralTile = null;
		Random rand = new Random();
		final int terrianLength = terrianOptions.length;
		int tileFromArray = rand.nextInt(terrianLength);
		centralTile = terrianOptions[tileFromArray];
		
		String hillOrFlat = "flat";
		String toReturn = centralTile;
		for(int i = 0; i<7; i++) {
			int number = rand.nextInt();
			if (number % 2 == 0 ) {
				hillOrFlat = "flat";
			}
			else {
				hillOrFlat = "hill";
			}
			toReturn = toReturn + ", " + hillOrFlat;
		}
		return toReturn;
	}
}
