/*
 * Countries of the World App 1.0
 * TheLog.java "The Log"
 * Waleed Gudah
 * 
 */
import java.io.*;
import java.text.DecimalFormat;

public class TheLog {

	private BufferedWriter out;

	public TheLog() {

		try {

			out = new BufferedWriter(new FileWriter("TheLog.txt", true));

			out.newLine();

			statusFile("TheLog FILE opened");

		} catch (IOException e) {

			System.out.println("Error, File may have been prematurely closed");

		}

	}

	// ***************************************************************//
	public void transProcess(String trans) {

		if (!trans.isEmpty()) {

			try {

				out.write("" + trans);

				out.newLine();

			} catch (IOException e) {

				System.out
						.println("Error, File may have been prematurely closed");

			}
		}
	}

	// ***************************************************************//
	public void statusCode(String toLog) {

		try {

			out.write("CODE STATUS > " + toLog);

			out.newLine();

		} catch (IOException e) {

			System.out.println("Error, File may have been prematurely closed");

		}

	}

	// ***************************************************************//
	public void statusFile(String toLog) {

		try {

			out.write("FILE STATUS > " + toLog);

			out.newLine();

		} catch (IOException e) {

			System.out.println("Error, File may have been prematurely closed");

		}

	}

	// ***************************************************************//

	public void snapShot(bstNode[] list, int nodes, int nextEmpty, int rootPtr) {
		DecimalFormat formatter = new DecimalFormat("#,###.##");

		String adjust;
		try {

			out.write(String.format("N: %s, NextEmpty: %s, RootPtr: %03d",
					nodes, nextEmpty + 1, rootPtr));
			out.newLine();

			out.write("[SUB] CDE NAME-------------- CONTINENT---- ------AREA ---POPULATION LIFE LCh RCh");
			out.newLine();
			for (int i = 0; i < list.length; i++) {

				adjust = list[i].getName();

				if (adjust.length() > 18) {

					adjust = list[i].getName().substring(0, 18);

				}

				out.write(String.format(
						"[%03d] %-3s %-18s %-13s %10s %13s %3s %03d %03d "
								+ "\n", i, list[i].getKey(), adjust,
						list[i].getContinent(),
						formatter.format(list[i].getArea()),
						formatter.format(list[i].getPopulation()),
						list[i].getLifeExpectancy(), list[i].getLeft(),
						list[i].getRight()));
				out.newLine();

			}
			out.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			out.newLine();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// ***************************************************************//
	public void toLog(String oneRecord) {

		try {

			out.write(oneRecord);

			out.newLine();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// ***************************************************************//
	public void finishUp() {

		try {

			out.write("FILE STATUS > TheLog FILE closed");

			out.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	// ***************************************************************//
}
