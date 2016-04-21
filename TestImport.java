package BudgetingApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

public class TestImport {
	private static final String DELIMITER = ",";

	@Test
	public void test() {
		// write the csv
		String filePath = "C:/Users/monroe/Documents/GitHub/FirstBankBudgetingApp/Test.csv";
		File file = new File(filePath);
		String header = "Name,Birthday,Gender";
		String rowOne = "Matt, May 20th 1988, Male";

		try {
			file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(header + "\n");
			bw.write(rowOne);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		CsvReader csv = new CsvReader();

		csv.csvReader(filePath);

		// call the import function

		// check to make sure it's the same

	}

}
