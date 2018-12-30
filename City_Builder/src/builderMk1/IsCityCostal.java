package builderMk1;

import java.io.IOException;
import java.util.Random;

public class IsCityCostal {
	public boolean costal(String cityName) throws IOException {
		int lengthOfName = cityName.length();
		if (lengthOfName % 2 == 0 ) {
			return true;
		}
		return false;
	}
}
