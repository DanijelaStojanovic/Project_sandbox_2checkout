package utils;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtReadLineUtils {

	public static String readLine(int lineNumber) {

		String text = "";
		String finaltext;
		int line;

		try {
			FileReader readfile = new FileReader("Url_Locators_utils.txt");
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (line = 1; line < 50; line++) {
				if (line == lineNumber) {
					text = readbuffer.readLine();
				} else
					readbuffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] specific_text = text.split("   ");
		finaltext = specific_text[1];

		return finaltext;

	}
}
