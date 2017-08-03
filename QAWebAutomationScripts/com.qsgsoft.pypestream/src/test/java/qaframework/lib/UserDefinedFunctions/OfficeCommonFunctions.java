package qaframework.lib.UserDefinedFunctions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import jxl.CellType;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableWorkbook;

/**
 * <font face="courier" size="2">This Class includes all common functions
 * related to Office application</font>
 * 
 * @author <font face="courier" size="2">QSG</font>
 * @version <font face="courier" size="2">1.0</font>
 */

public class OfficeCommonFunctions {

	Properties EnvPropertyDetails = null;

	private static String FILE_PATH = "";
	@SuppressWarnings("unused")
	private static WritableCellFormat courier;

	/***
	 * This function is used to write data into the Excel file
	 * 
	 * @throws Exception
	 */

	@SuppressWarnings("deprecation")
	public void WriteResultdb_Excel(String strTCId, String strTO,
			String strResult, double timeTaken) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String strDate = dateFormat.format(date);

		// Read Results path from Properties file
		PathsProperties objPathProperty = new PathsProperties();

		try {
			EnvPropertyDetails = objPathProperty.Read_FilePath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// private static final String FILE_PATH =
		// "C:/Projects/HomeReport/TestResults/HomeReport_ResultSummary.xls";
		String FILE_PATH = "D:/com.qsgsoft.pypestream/com.qsgsoft.pypestream/TestResults/Result_Report.xls";

		FILE_PATH = EnvPropertyDetails.getProperty("ResultsPath");
		// strDate = date.toString();

		// WRITE RESULTS TO EXCEL UNDER ANY CONDITION WITHOUT CHECKING ANY FLAG.

		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));

		// Create a writable workbook with the same name using the workbook
		// object that has been read from file
		WritableWorkbook wwb = Workbook.createWorkbook(new File(FILE_PATH), wb);

		// Total number of rows in the sheet
		int intRowCount = wwb.getSheet(0).getRows();
		for (int intRow = 4; intRow <= intRowCount; intRow++) {
			// Target cell
			WritableCell cell = wwb.getSheet(0).getWritableCell(1, intRow);

			if (cell.getType() == CellType.EMPTY) {
				WritableCellFormat wcf = new WritableCellFormat();
				wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf.setWrap(true);

				WritableFont courier10pt = new WritableFont(
						WritableFont.COURIER, 10);
				// Define the cell format
				courier = new WritableCellFormat(courier10pt);
				wcf.setFont(courier10pt);

				Label label0 = new Label(0, intRow, "", wcf);
				wwb.getSheet(0).addCell(label0);

				// Enter the TC ID
				Label label1 = new Label(1, intRow, strTCId, wcf);
				wwb.getSheet(0).addCell(label1);
				// Enter Test Objective
				Label label2 = new Label(2, intRow, strTO, wcf);
				wwb.getSheet(0).addCell(label2);
				// Enter Result
				Label label3 = new Label(3, intRow, strResult, wcf);
				wwb.getSheet(0).addCell(label3);
				// Enter Reason
				/*
				 * Label label4 = new Label(4, intRow, strReason, wcf);
				 * wwb.getSheet(0).addCell(label4);
				 */
				// Enter Date of execution
				Label label5 = new Label(4, intRow, strDate, wcf);
				wwb.getSheet(0).addCell(label5);
				// Enter Execution time
				/*String strTime = String.valueOf(timeTaken);
				Label label6 = new Label(5, intRow, strTime, wcf);
				wwb.getSheet(0).addCell(label6);*/

				// Write the data
				wwb.write();
				intRow = intRowCount + 1;
			}
		}
		wwb.close();
	}

	/* This function is used calculate the Time taken for test case execution */
	public double TimeTaken(Date dtStartDate) {
		Date dtEndDate = new Date();
		double dtTimeTaken = dtEndDate.getTime() - dtStartDate.getTime();
		dtTimeTaken = dtTimeTaken / 1000;
		return dtTimeTaken;

	}

	/***
	 * This function is used to write test data into the Excel file for PDF
	 * verification
	 * 
	 * @throws Exception
	 */

	@SuppressWarnings("deprecation")
	public void writeResultData(String[] strTestData, String strFilePath,
			String strSheetName) throws Exception {
		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(strFilePath));

		// Create a writable workbook with the same name using the workbook
		// object that has been read from file
		WritableWorkbook wwb = Workbook.createWorkbook(new File(strFilePath),
				wb);

		// Total number of rows in the sheet
		int intRowCount = wwb.getSheet(strSheetName).getRows();
		for (int intRow = 1; intRow <= intRowCount; intRow++) {

			// Target cell
			WritableCell cell = wwb.getSheet(strSheetName).getWritableCell(1,
					intRow);
			if (cell.getType() == CellType.EMPTY) {
				WritableCellFormat wcf = new WritableCellFormat();
				wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf.setWrap(true);

				WritableFont courier10pt = new WritableFont(
						WritableFont.COURIER, 10);
				// Define the cell format
				courier = new WritableCellFormat(courier10pt);
				wcf.setFont(courier10pt);

				for (int intRec = 1; intRec <= strTestData.length; intRec++) {

					Label label1 = new Label(intRec, intRow,
							strTestData[intRec - 1], wcf);
					wwb.getSheet(strSheetName).addCell(label1);

				}

				// Write the data
				wwb.write();
				intRow = intRowCount + 1;

			}

		}

		wwb.close();
	}
}
