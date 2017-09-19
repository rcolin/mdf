package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrivialPoursuite {

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

		String[] colors = { "orange", "jaune", "vert", "rose", "bleu", "violet" };

		int position = 0;

		do {
			int n = sc.nextInt();
			position = position + n;
			if (position > 6) {
				position = position % 6;
			}
		} while (sc.hasNextInt());

		System.out.println(colors[position - 1]);

	}

}
