/*
 * TODO
 *.
 *
 */
package builderMk1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class TurnHandler2 {
	public static void setup(GameObject go) {

		CityGenerator city_one = go.getCity_one();
		CityGenerator city_two = go.getCity_two();
		HashMap<String,MapValues> map2 = go.getMap();

		TreeMap<String,MapValues> map = new TreeMap<String,MapValues>();
		map.putAll(map2);


		HashSet<String> city_one_tiles = new HashSet<String>();
		HashSet<String> city_two_tiles = new HashSet<String>();


		System.out.println("\nGenerating Map...");

		for(String key: map.keySet()) {
			if(map.get(key).getOwner().equals("1")) {
				city_one_tiles.add(key);
			}else if(map.get(key).getOwner().equals("2")) {
				city_two_tiles.add(key);
			}
//			if(map.get(key).getOwner().equals("1") || map.get(key).getOwner().equals("2")) {
//				System.out.println(key+" : " + map.get(key).getOwner());
//			}
			city_one.setOwnedTiles(city_one_tiles);
			city_two.setOwnedTiles(city_two_tiles);
		}
		for(int i = 0; i < 10; i++) {
			TreeMap<String,MapValues>updatedMap = nextTurn(city_one,city_two,map,2);
			System.out.println("\n\nLoading new Map...");

			for(String key: updatedMap.keySet()) {
				if(updatedMap.get(key).getOwner().equals("1")) {
					city_one_tiles.add(key);
				}else if(updatedMap.get(key).getOwner().equals("2")) {
					city_two_tiles.add(key);
				}
//				if(updatedMap.get(key).getOwner().equals("1") || updatedMap.get(key).getOwner().equals("2")) {
//					System.out.println(key+" : " + updatedMap.get(key).getOwner());
//				}
				city_one.setOwnedTiles(city_one_tiles);
				city_two.setOwnedTiles(city_two_tiles);
			}
			map = updatedMap;
			//display map
			int currentKey = 0;
			for(String key:map.keySet()) {
				int x = Integer.parseInt(key.split(",")[0]);
				if(x == currentKey) {
					System.out.print(map.get(key).getOwner()+"¦");

				}else {
					currentKey++;
					System.out.println("");
				}
			}
		}
	}

	private static TreeMap<String, MapValues> nextTurn(CityGenerator city_one, CityGenerator city_two, TreeMap<String,MapValues> map, int numbOfPlayers) {
		//----------------------------------------------------------------------------------\\
		int topWorth = Integer.MIN_VALUE;
		String point = "";

		for(String tile: neighbourTiles(city_one.getOwnedTiles(), map)) {
			int currentworth = map.get(tile).getWorth();
			if(currentworth > topWorth) {
				topWorth = currentworth;
				point = tile;

			}
		}

		int worth = map.get(point).getWorth();
		String owner = "1";
		MapValues newmv = new MapValues();
		newmv.setOwner(owner);
		newmv.setWorth(worth);
		map.put(point,newmv);
		//----------------------------------------------------------------------------------\\
		topWorth = Integer.MIN_VALUE;
		point = "";

		for(String tile: neighbourTiles(city_two.getOwnedTiles(), map)) {
			int currentworth = map.get(tile).getWorth();
			if(currentworth > topWorth) {
				topWorth = currentworth;
				point = tile;
			}
		}

		worth = map.get(point).getWorth();
		owner = "2";
		newmv = new MapValues();
		newmv.setOwner(owner);
		newmv.setWorth(worth);
		map.put(point,newmv);
		//----------------------------------------------------------------------------------\\

		return map;
	}

	//agnostic function that works for both cities
	private static HashSet<String> neighbourTiles(HashSet<String>ownedTiles, TreeMap<String,MapValues> map){
		HashSet<String> neighbours = new HashSet<String>();
		for(String tile : ownedTiles) {
			String [] explodedTile = tile.split(",");

			//discover tiles around current key
			String plusLat = (Integer.parseInt(explodedTile[0] )+ 1) + "," + (Integer.parseInt(explodedTile[1]) + 0);
			String plusLong = (Integer.parseInt(explodedTile[0] )+ 0) + "," + (Integer.parseInt(explodedTile[1]) + 1);
			String minusLat = (Integer.parseInt(explodedTile[0] )- 1) + "," + (Integer.parseInt(explodedTile[1]) + 0);
			String minusLong = (Integer.parseInt(explodedTile[0] )- 0) + "," + (Integer.parseInt(explodedTile[1]) - 1);

			//add them to set
			neighbours.add(plusLat);
			neighbours.add(plusLong);
			neighbours.add(minusLat);
			neighbours.add(minusLong);
		}

		HashSet<String> finalNeighbours = new HashSet<String>();
		//check if tile is valid and unowned.
		for(String point : neighbours) {
			if(map.containsKey(point) && !ownedTiles.contains(point)) {
				finalNeighbours.add(point);
			}
		}
		return finalNeighbours;
	}
}