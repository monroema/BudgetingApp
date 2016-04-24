package BudgetingApp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapHandler {
//this class handles maps.
	private HashMap<String, List<String>> transactionTypeMap = new HashMap<String, List<String>>();

	public MapHandler() {
		transactionTypeMap.put("Grocery", Arrays.asList("Safeway", "King Sooper's", "Costco", "Wal-mart"));
		transactionTypeMap.put("Gas", Arrays.asList("7-Eleven", "Sinclair", "Shell Oil"));
	}

	public void addToMap(String newStore, String type) {
		List<String> newList = transactionTypeMap.get(newStore);
		if (newList == null) {
			transactionTypeMap.put(newStore, Arrays.asList(type));
		} else {
			newList.add(type);
			transactionTypeMap.put(newStore, newList);
		}
	}

	public HashMap<String, List<String>> getMap() {
		return transactionTypeMap;
	}
}
