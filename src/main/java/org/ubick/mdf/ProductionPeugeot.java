package org.ubick.mdf;

import java.util.*;

public class ProductionPeugeot {

	public static void main( String[] argv ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
        
		int x = 0;
		
		for (int i = 0; i < n; i++) {
			x += sc.nextInt();	
		}
		
		System.out.println(x);
	
		sc.close();
    }
	
}
