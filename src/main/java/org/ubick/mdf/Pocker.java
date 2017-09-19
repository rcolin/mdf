package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pocker {

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
		//code
		
		int sum = sc.nextInt();
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sum += (-x+y);
		}
		System.out.println(sum);
	}
}
