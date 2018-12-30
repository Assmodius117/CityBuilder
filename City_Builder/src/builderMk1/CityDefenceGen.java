package builderMk1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CityDefenceGen {
	public int defenceSet(String terrian, String type) throws IOException {
		int baseDefence = 100;
		int terrianModdedDefence = terrianModi(baseDefence, terrian);
		
		return terrianModdedDefence;
	}
	public int terrianModi(int base,String terrian) {
		Map<String,Integer> terrianMods = new HashMap<String,Integer>();
		terrianMods.put("Desert",100);
		terrianMods.put("Grasslands",0);
		terrianMods.put("Tundra",0);
		terrianMods.put("Snow",100);
		terrianMods.put("Plains",0);
		terrianMods.put("Jungles",500);
		terrianMods.put("Forests",300);
		terrianMods.put("Mountain",700);
		String [] terrianSplit = terrian.split(", ");
		base += terrianMods.get(terrianSplit[0]);

		int amountHill = 0;
		boolean firstPass = true;
		for(String hillFLat : terrianSplit) {
			if(!firstPass) {
				if(hillFLat.equals("hill")) {
					amountHill++;
				}
			}
			firstPass = false;
		}
		int hillMods = 100 * amountHill;
		base += hillMods;
		
		return base;
	}
}
