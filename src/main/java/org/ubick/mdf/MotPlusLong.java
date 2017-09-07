package org.ubick.mdf;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Celine on 31/08/2017.
 */
public class MotPlusLong {
	
    public static void main(String[] args) {

        /*
        String popo = "le petit chat, est mort";

        String[]t =  popo.split("\\W+");

        for (String s: t
             ) {
            System.out.println("->" +s);
        }*/

        List<String> texts = new ArrayList<>();

        Map<String, A> mapResult = new ConcurrentHashMap<>();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            texts.add(s);
        }

        //on parse ligne par ligne
        for (String text: texts) {
           String[] worlds = text.split("\\W+");
           //on parse mot par mot 
           for (String world: worlds) {
                if (mapResult.containsKey(world)){
                		A a = mapResult.get(world);
                		a.i = a.i+1; 
                }else{
                    A a = new A();
                    a.m = world;
                    a.i = 1;
                		mapResult.put(world, a);
                }
            }
        }

        List<Integer> tabInt = new ArrayList<>();
        for (String world: mapResult.keySet()) {
            //tabInt.add(mapResult.get(world));
        }

        Collections.sort(tabInt);

        int max1 = findMax(tabInt, 0);
        tabInt = remove(tabInt, max1);

        int max2 = findMax(tabInt, max1);
        tabInt = remove(tabInt, max2);

        int max3 = findMax(tabInt, max2);


        for (String world: mapResult.keySet()) {
            //if(max3 > mapResult.get(world)){
            //    mapResult.remove(world);
            //}
        }

    }

    private static List<Integer> remove(List<Integer> tabInt, int max) {
        List<Integer> tabResult = new ArrayList<>();
        for (Integer n: tabInt) {
            if(n < max){
                tabResult.add(n);
            }
        }
        return tabResult;
    }

    private static int findMax(List<Integer> tabInt, int max) {

        for(int i =0; i < tabInt.size(); i++ ){
            int n = tabInt.get(i);
            if(n > max)
                max = n;
        }
        return max;
    }


}

class A implements Comparable<A>{
	
	public String m;
	
	public Integer i;
	
	@Override
	public int compareTo(A o) {
		int result = this.m.compareTo(o.m);
		if(result == 0) {
			result = this.i.compareTo(o.i); 
		}
		return result;
	}

	@Override
	public String toString() {
		return "A [m=" + m + ", i=" + i + "]";
	}
}

/*

Enoncé

Le but de ce challenge est de trouver les mots qui sont le plus présents dans une série de textes.
Cependant, on considère que les mots qui sont présents dans tous les textes (s'il y en a ) ne sont pas intéressants et on ne les prendra donc pas en compte.

Chaque texte est constitué par une séquence de caractères ASCII terminée par le caractère fin de ligne n.
Les sous-séquences de lettres correspondant à des lettres (minuscules ou majuscules) sont considérées comme les mots composant le texte.
Les mots sont définis de façon insensible aux minuscules ou majuscules : word, Word ou WORD désignent donc un même mot.
Si le jeu de données contient n textes, chaque mot m est donc associé à un nombre de textes n_m compris entre 1 et n.
On ne s'intéresse qu'aux mots pour lesquels n_m < n, et l'on veut connaître les 3 mots parmi ceux-ci pour lesquels n_m est maximal.
En cas d'égalité de n_m entre plusieurs mots on les affichera en ordre alphabétique.

Format des données

Entrée

Une série de textes séparées par des fins de ligne "/n". Les mots du texte ne comprennent pas de caractère accentué.
On entend par mot une série consécutive de lettres minuscules ou majuscules.

Sortie

3 lignes avec sur chaque ligne un entier et un mot séparés par un espace. L'entier correspond au nombre de textes qui
incluent ce mot. Les lignes sont triées par nombre de textes décroissant puis en cas d'égalité par mot par ordre alphabétique. Exemple : 3 chemin

2 chevaux

2 livres

 */
