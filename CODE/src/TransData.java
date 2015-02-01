/*
 * Countries of the World App 1.0
 * TransData.java "Transaction Data"
 * Waleed Gudah
 * 
 */

import java.io.*;

public class TransData {

	private String country;
	private String code;
	private String key;
	private String continent;
	private int area;
	private int population;
	private float lifeExpectency;
	private int numOfTransactions;
	private File file;
	private DataInputStream dataIn;
	private TheLog tLog;
	private boolean doneWithInput;

	// ***************************************************************//
	public TransData(int fileNumber, TheLog tLog) {

		this.tLog = tLog;

		file = new File("TransData" + fileNumber + ".txt");

		try {

			dataIn = new DataInputStream(

			new BufferedInputStream(new FileInputStream(file)));

		} catch (FileNotFoundException e1) {

			System.out.println("The file required could not be found "

			+ "in the root path of this application");

		}

		tLog.statusFile("TransData FILE opened");

	}

	// ***************************************************************//
	// This method handles transaction data, one record at a time*****//
	// It is called by UserApp and is passed one record at a time from TransData
	// class///
	public void transactionIn(String arg) {

		clear(); // Clears Global variable used in this method

		if (!arg.isEmpty()) {

			key = arg.substring(0, 2);

			if (arg.startsWith("SA")) {

				numOfTransactions++;

				return;

			} else if (key.equals("IN") & !arg.substring(2).isEmpty()) {

				seperate(arg);

				numOfTransactions++;

			}

			else if ((key.equalsIgnoreCase("SN") || key.equalsIgnoreCase("DN"))
					& !arg.substring(2).isEmpty()) {

				arg = arg.substring(3);

				String[] fields = arg.split(",");

				fillFields(fields);

				numOfTransactions++;

			}

			else

				return;

		}

	}

	// ***************************************************************//
	public void seperate(String raw) {

		raw = raw.substring(34, raw.length() - 2); // Cut off the ends

		raw = raw.replace("'", "");

		String[] fields = raw.split(","); // Split the record up

		fillFields(fields);

	}

	// ***************************************************************//
	public void fillFields(String[] fields) {

		if (key.equalsIgnoreCase("IN")) {

			code = fields[0];

			country = fields[1];

			continent = fields[2];

			area = Math.abs((int) Long.parseLong(fields[5]));

			population = Integer.parseInt(fields[6]);

			lifeExpectency = Float.parseFloat(fields[7]);

		}

		else if (key.equalsIgnoreCase("SN") || key.equals("DN")) {

			country = fields[0].trim();

		}

	}

	// ***************************************************************//
	// This Method returns true if there is a record in the stream, else it
	// returns false//
	public boolean nextRecord() {

		try {

			transactionIn(dataIn.readLine());

		} catch (IOException e) {

			doneWithInput = true;

		}

		catch (NullPointerException f) {

			doneWithInput = true;

			return false;

		}

		return true;

	}

	// ***************************************************************//
	// Resets fields within TransData before each new record//
	public void clear() {

		country = code = key = continent = "";

		area = population = (int) (lifeExpectency = 0);

	}

	// ***************************************************************//
	public void finishUp() {

		tLog.statusCode("UserApp finished – " + numOfTransactions
				+ " transactions processed");

		try {

			dataIn.close();

		} catch (IOException e) {

			System.out.println("Oops File Can NOT be closed");

		}

		tLog.statusFile("TransData FILE closed");
	}

	// ***************************************************************//
	public int getNumOfTransactions() {

		return numOfTransactions;

	}

	// ***************************************************************//
	public String getCountry() {

		return country;

	}

	// ***************************************************************//
	public String getKey() {

		return key;

	}

	// ***************************************************************//
	public String getCode() {

		return code;

	}

	// ***************************************************************//
	public String getContinent() {

		return continent;

	}

	// ***************************************************************//
	public int getArea() {

		return area;

	}

	// ***************************************************************//
	public int getPopulation() {

		return population;

	}

	// ***************************************************************//
	public float getLifeExpectency() {

		return lifeExpectency;

	}

	// ***************************************************************//
	public int getNumberOfTransactions() {

		return numOfTransactions;

	}

}
