package builderMk1;

import java.util.HashSet;

public class CityGenerator {

	private String name;
	private String terrain;
	private String type;
	private int population;
	private int defenceRating;
	private int cityAge;
	private boolean isCostal;
	private String startingPoint;
	private String playerNumber; //meh its a string
	private HashSet<String>  ownedTiles;

	public CityGenerator() {
		
	}

	public HashSet<String> getOwnedTiles() {
		return ownedTiles;
	}

	public void setOwnedTiles(HashSet<String> ownedTiles) {
		this.ownedTiles = ownedTiles;
	}

	public String getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	
	public String getName() {//Name of the city
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isCostal() {
		return isCostal;
	}

	public void setCostal(boolean isCostal) {
		this.isCostal = isCostal;
	}

	public String getTerrain() {//Type of land it is on
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getType() {//Personality of city
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getDefenceRating() {
		return defenceRating;
	}

	public void setDefenceRating(int defenceRating) {
		this.defenceRating = defenceRating;
	}
	
	public int getCityAge() {
		return cityAge;
	}

	public void setCityAge(int cityAge) {
		this.cityAge = cityAge;
	}
	
}
