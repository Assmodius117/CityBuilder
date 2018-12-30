package builderMk1;

public class CityPopulationGen {
	public int populationSetter(String cityName, Integer cityAge) {
		int lengthOfName = cityName.length();
		Integer lengthOfAge = cityAge.toString().length();
		int pop = lengthOfName * cityAge;
		
		return pop*lengthOfAge;
	}
	
}
