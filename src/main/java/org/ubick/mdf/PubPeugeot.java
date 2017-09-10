package org.ubick.mdf;

import java.io.*;
import java.util.*;

public class PubPeugeot {

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

		int x = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		
		
		List<Integer> listY = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			listY.add(Integer.parseInt(sc.nextLine()));
		}

		sc.close();
		
		for (Integer y : listY) {
			x -= y;
		}
		
		System.out.println(x);
		
	}
}
