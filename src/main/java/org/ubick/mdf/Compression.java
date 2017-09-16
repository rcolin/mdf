package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compression {

	public static void main(String[] argv) throws Exception {

		Scanner sc = null;
		if (argv != null && argv.length > 0 && argv[0].equals("-d")) {
			try {
				sc = new Scanner(new File(argv[1]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			sc = new Scanner(System.in);
		}
		// code...

		String str = sc.nextLine();

		String result = "";
		Character lastC = null;
		int nbSameC = 0;

		for (int i = 0; i < str.length(); i++) {

			Character c = str.charAt(i);

			if (lastC != c && i != str.length() - 1) {

				if (nbSameC > 2) {
					result += String.valueOf(nbSameC);
					result += String.valueOf(lastC);
				} else {
					for (int j = 0; j < nbSameC; j++) {
						result += String.valueOf(lastC);
					}
				}

				nbSameC = 1;
			} else if (i == str.length() - 1) {
				if (lastC == c && nbSameC >= 2)
					nbSameC++;

				if (nbSameC > 2) {
					result += String.valueOf(nbSameC);
					result += String.valueOf(lastC);
				} else {
					for (int j = 0; j < nbSameC; j++) {
						result += String.valueOf(lastC);
					}
					result += String.valueOf(c);
				}

			} else {
				nbSameC++;
			}

			lastC = c;
		}
		System.out.println(result);

	}

}
