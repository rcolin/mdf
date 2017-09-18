/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;

import java.io.*;
import java.util.*;

public class IsoContest {
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
		System.out.println("Good luck!");

	}
}