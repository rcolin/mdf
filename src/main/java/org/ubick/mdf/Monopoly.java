package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Monopoly {

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
		
		int sum = Integer.parseInt(sc.nextLine());
		
		Integer[] cases = new Integer[40];
		
		for(int i = 0; i < 40; i++) {
			cases[i] =sc.nextInt();
		}
		//jump line
		sc.nextLine();
		
		int position = 1;
		while(sc.hasNextInt()) {
			int d1 = sc.nextInt();
			int d2 = sc.nextInt();
			int d = d1 + d2;
			position = d + position;
			if(position > 40) {
				position = position % 40;
			}
			
			if (position == 20)
				position = 10;
			sum -= cases[position-1];
			
			//System.out.println("Sum : " + sum + " position : " + position);
			
			if(sum <= 0) {
				System.out.println(position);
				break;
			}
		}//end while
	}//end main
}
