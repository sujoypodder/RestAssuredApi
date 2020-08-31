package DDUtils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook; // HSSFWorkbook workbook; --if xls file
	static XSSFSheet sheet; // HSSFSheet sheet; --if xls file

	public ExcelUtils(String excelpath, String sheetname) {

		try {
			// InputStrem file=new InputStream(excelpath); --if xls file
			workbook = new XSSFWorkbook(excelpath); // (file) instead of (excelpath) --if xls file
			sheet = workbook.getSheet(sheetname);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}

	}

	public static void getCellData(int rownum, int colnum) {

		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rownum).getCell(colnum));
		System.out.println(value);
	}

	public static void getRowCount() {

		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("number of rows " + rowcount);
	}

}
