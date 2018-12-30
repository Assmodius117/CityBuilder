package builderMk1;

public class CityGenerator {

	private String name;
	private String terrain;
	private String type;
	private String population;
	private String defenceRating;
	private int cityAge;

	public CityGenerator() {
		
	}

	public String getName() {//Name of the city
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getDefenceRating() {
		return defenceRating;
	}

	public void setDefenceRating(String defenceRating) {
		this.defenceRating = defenceRating;
	}
	
	public int getCityAge() {
		return cityAge;
	}

	public void setCityAge(int cityAge) {
		this.cityAge = cityAge;
	}
	
}
