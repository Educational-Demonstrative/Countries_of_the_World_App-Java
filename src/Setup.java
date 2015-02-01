/*
 * Countries of the World App 1.0
 * Setup.java "Setup"
 * Waleed Gudah
 * 
 */

public class Setup {

	private RawData rd;
	private CountryDataTable dTable;
	private TheLog tLog;

	// ***************************************************************//
	public Setup(String fileName, CountryDataTable table, TheLog tLog) {

		this.dTable = table;

		this.tLog = tLog;

		this.rd = new RawData(fileName, tLog);

		tLog.statusCode("Setup Started");

		getRecord();

		finishUp();

	}

	// ***************************************************************//
	// This method calls RawData for one Record, then passes the record to
	// the "Table"
	public void getRecord() {

		while (rd.nextRecord() == true) {

			toTable(dTable, rd);

		}
		rd.finishUp();

	}

	// ***************************************************************//
	// This method is called by getRecord(), it passes RawDatas fields to
	// CountryDataTable
	public void toTable(CountryDataTable dTable, RawData RD) {

		dTable.addNode(rd.getCode(), rd.getCountry(), rd.getContinent(),
				rd.getArea(), rd.getPopulation(), rd.getLifeExpectency());

	}

	// ***************************************************************//
	public void finishUp() {

		tLog.statusCode("Setup Finished - " + dTable.getNumberOfNodes()
				+ " countries processed");

	}
	// ***************************************************************//
}
