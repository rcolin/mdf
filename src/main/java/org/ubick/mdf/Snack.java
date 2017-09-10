package org.ubick.mdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Snack {

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

	    int n = Integer.parseInt(sc.nextLine());
        int p = Integer.parseInt(sc.nextLine());
        
        List<Integer> snackx = new ArrayList<>();
        List<Integer> snacky = new ArrayList<>();

        for (int i = 0; i < n; i++) {
        		snackx.add(i);
        		snacky.add(0);	
		}
        
        //pourquoi ?
        //sc.nextLine();
        
        String[] mvt = new String[p];
        for(int i = 0; i < p; i++){
        		String mv = sc.nextLine();
        		mvt[i] = mv;
        }
        
        for(String m : mvt){
        		
        		if(m.equals("D")) {
        			
        			snackx.add(snackx.get(snackx.size()-1)+1);
        			snacky.add(snacky.get(snacky.size()-1));
        			snackx.remove(0);
        			snacky.remove(0);
        			
        		}else if (m.equals("B")) {
        			
        			snackx.add(snackx.get(snackx.size()-1));
        			snacky.add(snacky.get(snacky.size()-1)+1);
        			snackx.remove(0);
        			snacky.remove(0);
        			
        		}else if (m.equals("G")) {
        			
        			snackx.add(snackx.get(snackx.size()-1)-1);
        			snacky.add(snacky.get(snacky.size()-1));
        			snackx.remove(0);
        			snacky.remove(0);
        			
        		}else if (m.equals("H")) {
        			
        			snackx.add(snackx.get(snackx.size()-1));
        			snacky.add(snacky.get(snacky.size()-1)-1);
        			snackx.remove(0);
        			snacky.remove(0);
        			
        		}
        }
        
        System.out.println(snackx.get(0) + " " + snacky.get(0));
     
    }
}