package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrivialPoursuite {

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

    	    Map<Integer, String> colors = new HashMap<>();
    	    colors.put(1,"orange");
    	    colors.put(2,"jaune");
    	    colors.put(3,"vert");
    	    colors.put(4,"rose");
    	    colors.put(5,"bleu");
    	    colors.put(6,"violet");
    	    
    	    
    	    int position = Integer.MAX_VALUE; 
    	    		
    	    do {
    	    		int n = sc.nextInt();
    	    		if(position == Integer.MAX_VALUE) {
    	    			position = n;
    	    		}else {
    	    			if((position + n) <= 6) {
    	    				position = position + n;
    	    			}else {
    	    				position = n + position - 6;
    	    			}
    	    		}
    	    }while(sc.hasNext());
    	    
    	    System.out.println(colors.get(position));
    	    
	}

}
