package builderMk1;

import java.util.HashMap;

public class GameObject {

	private CityGenerator city_one;
	private CityGenerator city_two;
	private HashMap map;
	
	public CityGenerator getCity_one() {
		return city_one;
	}
	public void setCity_one(CityGenerator city_one) {
		this.city_one = city_one;
	}
	public CityGenerator getCity_two() {
		return city_two;
	}
	public void setCity_two(CityGenerator city_two) {
		this.city_two = city_two;
	}
	public HashMap getMap() {
		return map;
	}
	public void setMap(HashMap map) {
		this.map = map;
	}
	

	
}
