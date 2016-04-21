package BudgetingApp;
import java.util.HashMap;

public class MapHandler {

	private HashMap<String, String> transactionTypeMap = new HashMap<String, String>();

	public MapHandler() {
		this.transactionTypeMap = null;
		this.transactionTypeMap.put("Safeway", "Grocery");
	}

	public void addToMap(String newStore, String type) {
		this.transactionTypeMap.put(newStore, type);
	}

	public HashMap<String, String> getMap() {
		return this.transactionTypeMap;
	}
}
