package org.ubick.mdf;

import java.io.*;
import java.security.interfaces.RSAKey;
import java.util.*;

public class Friandise {

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

		// parsing

		int m = Integer.parseInt(sc.nextLine());
		int t = Integer.parseInt(sc.nextLine());

		List<Integer> monnaies = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			
			int n = sc.nextInt();
			int v = sc.nextInt();
			for(int j = 0; j < n; j++) {
				monnaies.add(v);	
			}
		}

		sc.close();
		
		
		boolean estCalculable = false;
		//test 
		for (Integer mon : monnaies) {
			if(m > mon) {
				estCalculable = true;
			}
		}
		
		if(!estCalculable) {
			System.out.println("IMPOSSIBLE");
			System.exit(0);
		}
		
		List<List<Integer>> combiList = new ArrayList<>();
		
		Integer result = 0;
		List<Integer> results = new ArrayList<>();
		
		//appel de l'algo
		combiAlgo(monnaies, 1000, 0, new ArrayList(), 0, results, m);
		
		
		if(results.size()>0) {
			Collections.sort(results);
			result = results.get(0);	
		}
		
		if(result == 0)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(result);
	}

	public static void combiAlgo(List<Integer> ensemble, int profMax,
	         int profCourante, List<Integer> prefix, int rang, List<Integer> results, Integer m)
	   {
	      if (profCourante < profMax)
	      {
	         for (int i = rang; i < ensemble.size(); i++)
	         {
	        	 	List<Integer> tmp = new ArrayList<>(prefix);
	        	 	tmp.add(ensemble.get(i));
	        	 	//System.out.println(tmp);
	        	 	if(testPrice(m, tmp)) {
	        			if(!results.contains(tmp.size())){
	        				results.add(tmp.size());
	        				System.out.println("interm result : " + results);
	        			}
	        	 	}
	         }
	         
	         for (int i = rang; i < ensemble.size(); i++)
	         {
	        	 	List<Integer> newPrefix = new ArrayList<>(prefix);
	        	 	newPrefix.add(ensemble.get(i));
	        	 	combiAlgo(ensemble, profMax, profCourante + 1, newPrefix, i + 1, results, m );
	         }
	      }
	   }//fin algo
///fin main	

	private static boolean testPrice(Integer m, List<Integer> list) {
		int prix = m;
		for (Integer i: list) {
			prix -=i;
		}
		if(prix == 0)
			return true;
		return false;
	}
}
