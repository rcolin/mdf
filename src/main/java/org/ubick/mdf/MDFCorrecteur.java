package org.ubick.mdf;

import java.util.*;

/**
 * Created by Celine on 22/08/2017.
 */
public class MDFCorrecteur {

    private static Map<String, Integer> dico = new HashMap<>();

    private static Map<String, Integer> results = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        //nombre de mot du dico
        int d = sc.nextInt();


        for(int i = 0; i < d ; i++){
            String m = sc.nextLine();
            dico.put(m,0);
        }

        //nombre de mots tapés
        int n = sc.nextInt();
        List<String> motsSaisis = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            motsSaisis.add(sc.nextLine());
        }


        ///on parse chaque mot
        for (String mot : motsSaisis) {

            maFct(mot, 0);

        }
    }

    public static void maFct(String mot, int cout){

        //cas d'arrêt
        if(dico.containsKey(mot)){
            results.put(mot, cout);
        }else{

            //ajout d'une lettre


            //supression d'une lettre


            //remplacement d'une


            //swap
            if(mot.length() > 1) {
                for (int i = 0; i < mot.length() - 1; i++) {
                    String motTrasnforme = swap(mot, i);
                    if(dico.containsKey(mot)){
                        results.put(mot, cout+3);
                    }else{
                        //je regarde si le mot généré existe dans le tableau mot générés
                        //si oui je m'arret en mettant à jour le cout minimum
                        //sinon j'appele maFct(mot, cout + 3);

                    }

                }
            }//fin de swap



        }
    }

    private static String swap(String mot, int indice){
        char[] tabc = mot.toCharArray();
        char buff = tabc[indice];
        tabc[indice] = tabc[indice+1];
        tabc[indice+1] = buff;
        return tabc.toString();

    }


}