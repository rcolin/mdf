package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.isograd.exercise.IsoContestBase;


public class Trending {

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
		
		IsoContestBase.localEcho("Good luck!");
		
		
		
		int n = Integer.parseInt(sc.nextLine());
		
		Map<String, Tag2> mapTag = new HashMap<String, Tag2>();
		
		
		int sucess = 0;
		for (int i = 0; i < n; i++) {
			String tagName = sc.nextLine();
		
			if (mapTag.containsKey(tagName)) {
				Tag2 tag = mapTag.get(tagName);
				tag.occ += 1; 
			} else {
				mapTag.put(tagName, new Tag2(tagName, 1, i));
			}
			
			if(mapTag.get(tagName).occ == 40 && i - mapTag.get(tagName).i <= 60 ) {
				System.out.println(mapTag.get(tagName).tg);
				sucess = 1;
				break;
			}
		}
		
		if(sucess == 0)
			System.out.println("Pas de trending topic");
	}
}

class Tag2  {
	
	String tg;
	
	int occ;
	
	int i;
	
	public Tag2(String tg, int occ, int i) {
		this.tg = tg;
		this.occ = occ;
		this.i = i;
	}
}
