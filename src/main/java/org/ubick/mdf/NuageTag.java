package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NuageTag {

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
		
		int nbTag = Integer.parseInt(sc.nextLine());
		
		Map<String, Tag> tags = new HashMap<>(); 
		
		for (int i = 0; i < nbTag; i++) {
			String tag = sc.nextLine();
			
			if(tags.containsKey(tag)) {
				tags.get(tag).n += 1;
			}else {
				tags.put(tag, new Tag(tag, 1));
			}
		}
		
		List<Tag> tagList = new ArrayList<>(tags.values());
		Collections.sort(tagList);
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println(tagList.get(i).t + " " + tagList.get(i).n);
		}
	}
	
}

class Tag implements Comparable<Tag>{
	
	String t;
	int n;

	public Tag(String t, int n) {
		this.t = t;
		this.n = n;
	}

	public int compareTo(Tag o) {
		return o.n-n;
	}

	@Override
	public String toString() {
		return "Tag [t=" + t + ", n=" + n + "]";
	};
	
	
	
}
