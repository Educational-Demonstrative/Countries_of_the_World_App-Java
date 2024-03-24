/*
 * Countries of the World App 1.0
 * Main.java "Demo"
 * Waleed Gudah
 * 
 */

public class Main {

	public static void main(String[] args) {

		TheLog tLog = new TheLog(); // Declare Object of TheLog

		CountryDataTable dTable = new CountryDataTable(tLog); // Declare Object
																// of
																// CountryDataTable
																// and pass it
																// TheLog

		new Setup("RawDataSample", dTable, tLog); // Call Setups Constructor,
													// passing Filename for
													// RawData,
													// CountryDataTable, and
													// TheLog

		for (int i = 1; i <= 3; i++) {

			new UserApp(dTable, i, tLog); // Call UserApp, passing
											// CountryDataTable, int to choose
											// which transData file(1,2,3,4) and	
											// TheLog

		}

		dTable.finishUp(true); // Call CountryDataTable, passing true to print
								// SnapShot

		new Setup("RawDataAll", dTable, tLog);

		for (int i = 4; i <= 4; i++) {
		
			new UserApp(dTable, i, tLog);

		}

		dTable.finishUp(false); // Do not print SnapShot

		tLog.finishUp(); // Finish Up the Log

	}

}
