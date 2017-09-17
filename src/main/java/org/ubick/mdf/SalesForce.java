package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesForce {

	private static final String REGEX ="\\+\\d{1,3}\\-\\d{9,11}$";
	
    public static void main( String[] argv ) throws Exception {
		
		Scanner sc = null;
	    if (argv!=null && argv.length>0 && argv[0].equals("-d")){
	    		try {
					sc = new Scanner(new File(argv[1]));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    } else {
	    		sc = new Scanner(System.in);
	    }
	    //code
	    
	    Pattern p = Pattern.compile(REGEX);
	    
	    int m = Integer.parseInt(sc.nextLine());
	    
	    String[] tabCountries = sc.nextLine().split(";");

	    Map<String, Integer> countries = new HashMap<>();
	    for (String s : tabCountries) {
			countries.put(s, 0);
		}
	    
	    Map<String, Integer> keys = new HashMap<>();
	    
	    int x = 0, y = 0, z = 0; 
	    
	    //ietrate on ligne
	    for (int i = 0; i < m; i++) {
			String[] tab = sc.nextLine().split(";");
			String key = tab[0]+tab[1]+tab[2];
			//test doublon
			if(keys.containsKey(key)) {
				keys.put(key, keys.get(key)+1);
				x++;
			}else {
				keys.put(key, 1);
				
				//test pays hors zone
				if(!countries.containsKey(tab[4])) {
					z++;
				}
				//mauvais numero
				Matcher matcher = p.matcher(tab[3]);
				if(!matcher.find()) {
					y++;
				}
					
			}

		}
	    
	    System.out.println(x + " " + y + " " + z);
    }
	
}
