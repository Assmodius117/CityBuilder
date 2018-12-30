package builderMk1;

import java.io.IOException;
import java.util.HashMap;

public class Setup {

	public static void main (String args[]) throws IOException {
		GameObject go = new GameObject();
		for(int i = 1; i < 3; i++) {
			CityGenerator cg = new CityGenerator();

			CityNameGen cng = new CityNameGen();
			cg.setName(cng.namePicker("C:\\Users\\brace\\eclipse-workspace\\City_Builder\\src\\builderMk1\\cityNames.csv"));

			cg.setPlayerNumber(Integer.toString(i));

			IsCityCostal icg = new IsCityCostal();
			cg.setCostal(icg.costal(cg.getName()));

			CityTerrainGen ctg = new CityTerrainGen();
			cg.setTerrain(ctg.terrainPicker(cg.isCostal()));
			
			CityAgeGen cag = new CityAgeGen();
			
			cg.setCityAge(cag.ageSet());

			CityPopulationGen cpg = new CityPopulationGen();
			cg.setPopulation(cpg.populationSetter(cg.getName(), cg.getCityAge()));

			CityTypeGen cty = new CityTypeGen();
			cg.setType(cty.cityPersonality(cg.isCostal(), cg.getTerrain(), cg.getPopulation()));

			CityDefenceGen cdg = new CityDefenceGen();
			cg.setDefenceRating(cdg.defenceSet(cg.getTerrain(), cg.getType()));

			System.out.println(cg.getName()+", "+cg.getDefenceRating()+", "+cg.getTerrain()+", "+cg.getCityAge() +" years" + ", " +cg.getPopulation() +", "+cg.isCostal() +", "+ cg.getType());
			
			if(i == 1) {
				go.setCity_one(cg);
			}else if(i == 2){
				go.setCity_two(cg);
			}
			
			
			/*
			MapGen mg = new MapGen();
			TreeMap<String,PointGen> genedMap = mg.map(9,9,"N",false);

			//Messy block to gen start point and set it as first owned tile for city
			Random rand = new Random();
			SinglePointGen spg = new SinglePointGen();
			cg.setStartingPoint(spg.getPoint(rand.nextInt(9),rand.nextInt(9),"1",true));
			String startPoint = cg.getStartingPoint().toString();
			HashSet<String> owndedTile = new HashSet<String>();
			ArrayList<String> tiles = new ArrayList<String>();
			tiles.add(cg.getStartingPoint());
			owndedTile.addAll(tiles);
			cg.setOwnedTiles(owndedTile);

			for(String key : genedMap.keySet()) {
				PointGen value = genedMap.get(key);
				if(key.equals(startPoint)) {
					value.setOwner(cg.getPlayerNumber());
					genedMap.put(startPoint, value);
				}
			}
			*/
			//Debug and map display
/*
			int currentKey = 0;
			for(String key:genedMap.keySet()) {
				PointGen point = genedMap.get(key);
				int x = Integer.parseInt(key.split(",")[0]);
				if(x == currentKey) {
					System.out.print(point.getOwner()+"¦");

				}else {
					currentKey++;
					System.out.println("");
				}
			}
			*/
			//Create game object with current city and map. ONLY WORKS WITH ONE CITY!
		//	go.setCity(cg);
		//	go.setMap(genedMap);
			//TurnHandler th = new TurnHandler();
		//	TurnHandler.setup(go);
		}
		System.out.println(go.getCity_one().getName());
		System.out.println(go.getCity_two().getName());
		HashMap<String,MapValues> map = new MapGen().map();
		go.setMap(map);
		TurnHandler2.setup(go);

	}

}
