package builderMk1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class TurnHandler {
	public static void setup(GameObject go) {
		
		CityGenerator city_one = go.getCity_one();
		CityGenerator city_two = go.getCity_two();
		HashMap<String,MapValues> map = go.getMap();
		
		//nextTurn(numberOfPlayers, numberOfTurns, city, map, tiles);

	}
	private static void nextTurn(int numberOfPlayers, int numberOfTurns, CityGenerator city, TreeMap<String,PointGen> map, HashSet<String> tiles) {
		//Number of players doesn't make any difference right now due to testing
		for(int i = 0; i < numberOfTurns; i++) {
			HashSet<String> availableTiles = neighbourTiles(tiles, map);
			if(availableTiles.isEmpty()) {
				continue;
			}else {
				String highestWorthTile = "";
				int currentHighestWorth = 0;
				for(String pointFromAvailable : availableTiles) {
					if(map.get(pointFromAvailable).getWorth() > currentHighestWorth) {
						highestWorthTile = pointFromAvailable;
					}
				}
				System.out.println(highestWorthTile);
				map.get(highestWorthTile).setOwner("1");
			}
			//Print out the current map
			int currentKey = 0;
			for(String key:map.keySet()) {
				PointGen point = map.get(key);
				int x = Integer.parseInt(key.split(",")[0]);
				if(x == currentKey) {
					System.out.print(point.getOwner()+"¦");

				}else {
					currentKey++;
					System.out.println("");
				}
			}
			System.out.println("");
			System.out.println("----------------------------------------------------");
		}
	}
	private static HashSet<String> neighbourTiles(HashSet<String> ownedTiles,TreeMap<String,PointGen> map){//could this function sit with the tile/point gen??
		HashSet<String> neighbours = new HashSet<String>();
		for(String tile : ownedTiles) {
			String [] explodedTile = tile.split(",");

			String plusLat = (Integer.parseInt(explodedTile[0] )+ 1) + "," + (Integer.parseInt(explodedTile[1]) + 0);
			String plusLong = (Integer.parseInt(explodedTile[0] )+ 0) + "," + (Integer.parseInt(explodedTile[1]) + 1);
			String minusLat = (Integer.parseInt(explodedTile[0] )- 1) + "," + (Integer.parseInt(explodedTile[1]) + 0);
			String minusLong = (Integer.parseInt(explodedTile[0] )- 0) + "," + (Integer.parseInt(explodedTile[1]) - 1);

			neighbours.add(plusLat);
			neighbours.add(plusLong);
			neighbours.add(minusLat);
			neighbours.add(minusLong);
		}

		HashSet<String> finalNeighbours = new HashSet<String>();
		for(String point : neighbours) {
			if(map.containsKey(point)) {
				System.out.println(point);
				finalNeighbours.add(point);
			}
		}

		return finalNeighbours;
	}
}
