package org.ubick.mdf;

import java.io.*;
import java.security.interfaces.RSAKey;
import java.util.*;

public class Friandise {

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
	    
	    //parsing
	    
	    int m = Integer.parseInt(sc.nextLine());
	    int t = Integer.parseInt(sc.nextLine());
	    
	    List<Piece> monnaies = new ArrayList<>();
	   
	    
	    for (int i = 0; i < t; i++) {
	    		monnaies.add(new Piece(sc.nextInt(), sc.nextInt()));
		}
	    
	    //System.out.println(monnaies);
	    Collections.sort(monnaies);
	    //System.out.println(monnaies);
	    
	    sc.close();
	    
	    int result = 0;
	    
	    int first = m;
	    
	    for (Piece piece : monnaies) {
			
	    		for (int i = piece.n; i > 0; i--) {
	    			System.out.println("i = " + i); 
	    			if(first - (i*piece.v) == 0) {
	    				System.out.println(i);
	    				System.exit(0);
	    			}
	    			if(m - (i*piece.v) >= 0 ){
					System.out.println("i = " + i + " v=" + piece.v);
					m=m-(i*piece.v);
					System.out.println("m = " + m);
					result += i;
					break;
				}
			}
	    	
		}
	    
	    System.out.println(m);
	    if(m == 0 )
	    		System.out.println(result);
	    else
	    		System.out.println("IMPOSSIBLE");
	}

}

class Piece implements Comparable<Piece>{
	int n;
	
	int v;

	public Piece(int n, int v) {
		this.n = n;
		this.v = v;
	}

	@Override
	public int compareTo(Piece o) {
		int result = o.v-v;
		if(result == 0)
			result = o.n-n;
		return result;
	}
	
	@Override
	public String toString() {
		return "Piece [n=" + n + ", v=" + v + "]";
	}
	
	
	
}
