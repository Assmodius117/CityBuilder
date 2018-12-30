package builderMk1;

import java.util.HashMap;
import java.util.Random;

public class MapGen {
	public HashMap<String,MapValues> map(){
		
		HashMap<String,MapValues> map = new HashMap<String,MapValues>();
		
		
		for(int i = 1; i< 10; i++) {
			for(int o = 1; o< 10; o++) {
				MapValues mv = new MapValues();
				Random rand  = new Random();
				mv.setOwner("N");
				mv.setWorth(rand.nextInt(10));
				map.put(i+","+o, mv);
			}
		}
		
		//Static selection of starting points.
		//bodge
		for(String point:map.keySet()) {
			if(point.equals("3,5")) {
				int worth = map.get(point).getWorth();
				String owner = "1";
				MapValues newmv = new MapValues();
				newmv.setOwner(owner);
				newmv.setWorth(worth);
				map.put("3,5",newmv);
			}else if(point.equals("7,7")) {
				int worth = map.get(point).getWorth();
				String owner = "2";
				MapValues newmv = new MapValues();
				newmv.setOwner(owner);
				newmv.setWorth(worth);
				map.put("7,7",newmv);
			}
		}
		return map;		
	}
}