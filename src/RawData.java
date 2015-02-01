/*
 * Countries of the World App 1.0
 * RawData.java "RawData
 * Waleed Gudah
 * 
 */

import java.io.*;

public class RawData {

	private String country;
	private String code;
	private String continent;
	private int area;
	private int population;
	private float lifeExpectency;
	private File file;
	private DataInputStream dataIn;
	private TheLog tLog;

	// ***************************************************************//
	public RawData(String fileName, TheLog tLog) {// pass in string filename

		this.tLog = tLog;

		file = new File(fileName + ".csv");

		try {

			dataIn = new DataInputStream(

			new BufferedInputStream(new FileInputStream(file)));

		} catch (FileNotFoundException e1) {

			System.out.println("The file required could not be found "

			+ "in the root path of this application");
		}
		tLog.statusFile("RawData FILE opened");
	}

	// ***************************************************************//
	public boolean nextRecord() {

		try {

			seperate(dataIn.readLine());

		} catch (IOException e) {

			return false;
		}

		catch (NullPointerException f) {

			return false;

		}

		return true;

	}

	// ***************************************************************//
	public void seperate(String raw) {

		raw = raw.substring(30, raw.length() - 2); // Cut off the ends

		raw = raw.replace("'", "");

		String[] oneRecord = raw.split(","); // Split the record up

		fillFields(oneRecord);

	}

	// ***************************************************************//
	public void fillFields(String[] oneRecord) {

		setCode(oneRecord[0]);

		setCountry(oneRecord[1]);

		setContinent(oneRecord[2]);

		setArea(Math.abs((int) Float.parseFloat(oneRecord[4])));

		setPopulation(Integer.parseInt(oneRecord[6]));

		setLifeExpectency(Float.parseFloat(oneRecord[7]));

	}

	// ***************************************************************//
	public void finishUp() {

		try {

			tLog.statusFile("RawData FILE closed");

			dataIn.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	// ***************************************************************//
	public String getCode() {

		return code;

	}

	// ***************************************************************//
	public void setCode(String code) {

		this.code = code;

	}

	// ***************************************************************//
	public String getContinent() {

		return continent;

	}

	// ***************************************************************//
	public void setContinent(String continent) {

		this.continent = continent;

	}

	// ***************************************************************//
	public int getArea() {

		if (area == 0) {

			return -1;

		}

		return area;
	}

	// ***************************************************************//
	public void setArea(int area) {

		this.area = area;

	}

	// ***************************************************************//
	public int getPopulation() {

		if (population == 0) {
			return -1;
		}

		return population;
	}

	// ***************************************************************//
	public void setPopulation(int population) {

		this.population = population;

	}

	// ***************************************************************//
	public float getLifeExpectency() {

		if (lifeExpectency == 0.0) {

			return -1;

		}

		return lifeExpectency;
	}

	// ***************************************************************//
	public void setLifeExpectency(float lifeExpectency) {

		this.lifeExpectency = lifeExpectency;

	}

	// ***************************************************************//
	public void setFile(File file) {

		this.file = file;

	}

	// ***************************************************************//
	public String getCountry() {

		return country;

	}

	// ***************************************************************//
	public void setCountry(String country) {

		this.country = country;

	}

}
