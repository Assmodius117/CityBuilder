package builderMk1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CityTypeGen {
	/*
		How does population affect the type of city?
	 */
	public String cityPersonality(boolean costal, String terrian, int population) {
		String [] cityTypes = {"Merchant","Military","Academic","Religious","Mining","Arcarnic","Farming"};
		int numberOfCityTypes = cityTypes.length;
		HashMap<String,Integer> personalityRatio = new HashMap<String,Integer>();
		Random rand = new Random();
		for(int i = 0; i < numberOfCityTypes; i++) {
			personalityRatio.put(cityTypes[i], rand.nextInt(9) + 1);
		}

		if(costal) {
			personalityRatio.replace("Merchant", personalityRatio.get("Merchant") * 3);
		}
		HashMap<String,Integer>personalityRatio2 = terrianMulitpler(terrian, personalityRatio);
		String cityType = typeCalc(personalityRatio2);
		
		return cityType;
	}
	//{"Desert","Grasslands","Tundra","Snow","Plains","Jungles","Forests","Mountain"}
	private HashMap<String,Integer> terrianMulitpler(String terrian, HashMap<String,Integer> personalityRatio) {
		String [] terrianOptions = terrian.split(",");
		String startingTile = terrianOptions[0];
		if(startingTile.equals("Desert")) {
			personalityRatio.replace("Religious", personalityRatio.get("Religious") * 3);
			personalityRatio.replace("Arcarnic", personalityRatio.get("Arcarnic") * 2);
			personalityRatio.replace("Farming", personalityRatio.get("Farming") / 2);
		}
		if(startingTile.equals("Grasslands")) {
			personalityRatio.replace("Farming", personalityRatio.get("Farming") * 5);
			personalityRatio.replace("Military", personalityRatio.get("Military") * 2);
		}
		if(startingTile.equals("Tundra")) {
			personalityRatio.replace("Farming", personalityRatio.get("Farming") / 2);
		}
		if(startingTile.equals("Snow")) {
			personalityRatio.replace("Farming", personalityRatio.get("Farming") / 3);
		}
		if(startingTile.equals("Jungles")) {
			personalityRatio.replace("Merchant", personalityRatio.get("Merchant") * 2);
			personalityRatio.replace("Academic", personalityRatio.get("Academic") * 3);
		}
		if(startingTile.equals("Forests")) {

		}
		if(startingTile.equals("Mountain")) {
			personalityRatio.replace("Religious", personalityRatio.get("Religious") * 3);
			personalityRatio.replace("Mining", personalityRatio.get("Mining") * 4);
		}
		
		int amountFlat = 0;
		int amountHill = 0;
		for(String hillFLat : terrianOptions) {
			if(hillFLat.equals("flat")) {
				amountFlat++;
			}
			else if(hillFLat.equals("hill")) {
				amountHill++;
			}
		}
		if(amountFlat > amountHill) {
			personalityRatio.replace("Farming", personalityRatio.get("Farming") * amountFlat);
		}
		else {
			personalityRatio.replace("Mining", personalityRatio.get("Mining") * amountHill);
		}
		return personalityRatio;
	}
	
	private String typeCalc(HashMap<String,Integer> personalityRatio) {
		String currentTopType = null;
		int currentTopValue = Integer.MIN_VALUE;
		for(String type : personalityRatio.keySet()) {
			int value = personalityRatio.get(type);
			if(value > currentTopValue) {
				currentTopType = type;
				currentTopValue = value;
			}
		}
		String newCurrentTopType = null;
		personalityRatio.remove(currentTopType);
		currentTopValue = Integer.MIN_VALUE;
		for(String type : personalityRatio.keySet()) {
			int value = personalityRatio.get(type);
			if(value > currentTopValue) {
				newCurrentTopType = type;
				currentTopValue = value;
			}
		}
		String toReturn = currentTopType + ", " +newCurrentTopType;
		return toReturn;
	}
}
