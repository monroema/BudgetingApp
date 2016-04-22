package BudgetingApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CsvReader {

	private static final String DELIMITER = ",";
	MapHandler map = new MapHandler();

	public Map<String, BigDecimal> csvReader(String filePath) {
		Map<String, List<String>> localMap = map.getMap();
		Map<String, BigDecimal> resultsMap = new HashMap<String, BigDecimal>();
		try {
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(filePath));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] fileReadIn = line.split(DELIMITER);
				String date = fileReadIn[0];
				String category = fileReadIn[1];
				String transactionType = fileReadIn[2];
				String amount = fileReadIn[3].replace("$", "");
				amount = amount.trim();
				String newCat = "";
				// loop through the map
				Iterator it = localMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					List<String> newList = (List<String>) pair.getValue();
					for (String string : newList) {
						if (string.toLowerCase().contains(category.toLowerCase())) {
							newCat = (String) pair.getKey();
						}
					}
					it.remove(); // avoids a ConcurrentModificationException
				}

				BigDecimal bigDecimal = resultsMap.get(newCat);
				if (bigDecimal == null) {
					resultsMap.put(newCat, new BigDecimal(amount));
				} else {
					resultsMap.put(newCat, bigDecimal.add(new BigDecimal(amount)));
				}

				/*
				 * for (List<String> stringList : localMap.values()) { for
				 * (String string : stringList) { if
				 * (string.toLowerCase().contains(category.toLowerCase())) {
				 * 
				 * } } }
				 */
				// check to see if this category already exists in this month

				// put in memory somewhere to save for later
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultsMap;
	}
}
