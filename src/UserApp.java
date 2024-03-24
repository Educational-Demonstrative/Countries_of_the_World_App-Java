/*
 * Countries of the World App 1.0
 * UserApp.java "User Application"
 * Waleed Gudah
 * 
 */

public class UserApp {

	private CountryDataTable DTable;

	private TheLog tLog;

	private TransData td;

	// ***************************************************************//
	public UserApp(CountryDataTable DTable, int fileNumber, TheLog tLog) {

		this.DTable = DTable;

		this.tLog = tLog;

		this.td = new TransData(fileNumber, tLog);

		tLog.statusCode("UserApp started");

		processUserInput();

	}

	// ***************************************************************//
	public void processUserInput() {

		while (td.nextRecord() == true) {

			inputSwitch(td.getKey());

		}
		td.finishUp();
	}

	// ***************************************************************//
	// This method determines the Selection made by the transaction file //
	// and calls one of the 4 helper methods below to perform the appropriate
	// task.//
	public void inputSwitch(String key) {

		switch (key) {

		case "IN":

			insertNode();

			break;

		case "DN":

			deleteNode();

			break;

		case "SA":

			selectAll();

			break;

		case "SN":

			tLog.transProcess("");

			selectNode();

			break;

		}

	}

	// ***************************************************************//
	private void deleteNode() {

		tLog.transProcess(td.getKey() + " " + td.getCountry());

		DTable.deleteNode(td.getCountry());

	}

	// ***************************************************************//
	private void selectAll() {

		tLog.transProcess(td.getKey());

		tLog.toLog("      CDE NAME-------------- CONTINENT---- ------AREA ---POPULATION LIFE");

		DTable.inOrderTraverse(0);

		tLog.toLog("      ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	}

	// ******************************************************************************************//
	// This method guarantees the node being selected is found before writing to
	// log, ie echo//
	private void selectNode() {

		tLog.transProcess(td.getKey() + " " + td.getCountry());

		DTable.selectNode(DTable.binarySearch(td.getCountry()));

	}

	// ***************************************************************//
	public void insertNode() {
		tLog.transProcess(td.getKey() + " " + td.getCountry());

		DTable.insert(td.getCode(), td.getCountry(), td.getContinent(),

		td.getArea(), td.getPopulation(), td.getLifeExpectency());

	}

	// ***************************************************************//
	public void finishUp() {

		tLog.statusCode("UserApp finished - " + td.getNumberOfTransactions()
				+ " transactions processed");

	}

}
