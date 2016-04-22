package BudgetingApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

public class TestImport {
	private static final String DELIMITER = ",";

	@Test
	public void test() {
		// write the csv
		String filePath = "C:/Users/monroe/Documents/GitHub/FirstBankBudgetingApp/Test.csv";
		File file = new File(filePath);
		String rowOne = "05/20/1988, Check+ #2200, 1100,1";
		String rowTwo = "\n06/20/1988, Visa Safeway, VISA,195";
		String rowThree = "\n07/20/1988, Payroll Tyler Technologies, EFT,19500000";

		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(rowOne);
			bw.write(rowTwo);
			bw.write(rowThree);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		CsvReader csv = new CsvReader();

		// call the import function
		Map<String, BigDecimal> csvReader = csv.csvReader(filePath);

		// check to make sure it's the same

	}

}
