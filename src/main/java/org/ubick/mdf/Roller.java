package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Roller {

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
		// code

		int n = Integer.parseInt(sc.nextLine());

		List<Integer> data = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			data.add(Integer.parseInt(sc.nextLine()));
		}

		Collections.sort(data);

		List<Integer> startMin = createListStartMin(data);
		
		StringBuilder buffer = new StringBuilder();
		for (Integer integer : startMin) {
			if(buffer.length() != 0) {
				buffer.append(" ");
			}
			buffer.append(integer);
		}
		
		System.out.println(buffer);
	}

	private static List<Integer> createListStartMin(List<Integer> data) {
		List<Integer> result = new ArrayList<>(data);

			int i = 1;
			while(i < result.size()) {
				if(i + 1 < result.size()) {	
					int ia = result.get(i);
					int ib = result.get(i+1);
					result.set(i, ib);
					result.set(i+1, ia);
					i += 2;
				}else
					i++;
			}
			
		return result;
	}

}
