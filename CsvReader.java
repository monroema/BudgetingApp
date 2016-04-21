package BudgetingApp;
import java.io.BufferedReader;
import java.io.FileReader;

public class CsvReader {

	private static final String DELIMITER = ",";
	MapHandler map = new MapHandler();

	public void csvReader(String filePath) {
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

				// loop through the map
				for (String string : map.getMap().keySet()) {
					if (category == string) {
						category = string;
						break;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
