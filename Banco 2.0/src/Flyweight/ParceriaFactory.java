package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ParceriaFactory {
	private static Map<String, Parceiros> names;
	
	
	private static void init() {
		names = new HashMap<String, Parceiros>();
		names.put("Facebook", new Parceiros("Facebook"));
		names.put("MercedesBenz", new Parceiros("MercedesBenz"));
		names.put("Instagram", new Parceiros("Instagram"));
		names.put("Subway", new Parceiros("Subway"));
	}
	
	public static Parceiros get(String s) {
		if (names == null)
			init();
		
		return names.get(s);
	}

}
