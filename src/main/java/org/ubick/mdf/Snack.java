package org.ubick.mdf;

import java.util.*;

public class Snack {

    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

	    int n = sc.nextInt();
        int p = sc.nextInt();
        
        String[] mvt = new String[p];
        for(int i = 0; i < p; i++){
            String m = sc.nextLine();
            mvt[i] = m;
        }

        for(String m : mvt){
             //switch

        }
    }
}