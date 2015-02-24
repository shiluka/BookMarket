package bookrating.filehandler;

import java.io.*;

import bookrating.record.Record;

//To Handles Files
public class FileReader {

	private int numberOfLines = 0;

	public FileReader(Record[] record) throws NumberFormatException,
			IOException {
		// text file to search
		File file = new File("text2.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;
		int k = 0;

		while ((line = br.readLine()) != null) {
			// \\s+ means any number of whitespaces between tokens
			numberOfLines++;
			String[] tokens = line.split("\\s+");

			try {
				record[k].setTimeStamp(tokens[0]);
			} catch (Exception e) {
				System.out
						.println("ERROR: Number of Lines in text file wrong, check ProductSearch.RECORD_SIZE !");
			}

			record[k].setUserName(tokens[1]);
			record[k].setBookName(tokens[2]);
			record[k].setVendor(tokens[3]);
			record[k].setVendorRating(Integer.parseInt(tokens[4]));
			record[k].setBookRating(Integer.parseInt(tokens[5]));

			record[k].setTime();

			k++;
		}

	}

}
