package DDUtils;

public class DDTestFileRun {

	public static void main(String[] agrs) {

		String excelpath = "./data/dataset.xlsx";
		String sheetname = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelpath, sheetname);
		excel.getRowCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
		excel.getCellData(2, 0);
		excel.getCellData(2, 1);
		excel.getCellData(2, 2);
	}

}
