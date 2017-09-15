package org.ubick.mdf;

public class TemplateAlgoCombinatoire {

	   public static void main(String[] args)
	   {
	      String[] ensemble = { "A", "B", "C", "D" };
	      int profondeur = 10;
	      displayEnsemble(ensemble, profondeur, 0, "", 0);
	   }
	   
	   public static void displayEnsemble(String[] ensemble, int profMax,
	         int profCourante, String prefix, int rang)
	   {
	      if (profCourante < profMax)
	      {
	         for (int i = rang; i < ensemble.length; i++)
	         {
	            System.out.println(prefix + ensemble[i]);
	         }
	 
	         for (int i = rang; i < ensemble.length; i++)
	         {
	            displayEnsemble(ensemble, profMax, profCourante + 1, prefix
	                  + ensemble[i], i + 1);
	         }
	      }
	   }
}
