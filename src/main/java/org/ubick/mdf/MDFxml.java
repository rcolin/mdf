package org.ubick.mdf;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MDFxml {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Map<Character, Float> arr = new ConcurrentHashMap<Character, Float>();

        int p = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '-'){
                i++;
                char l = s.charAt(i);

                //calcul du poids
                float f = 1F/p;

                if(arr.containsKey(l)){//existe déja nun poids pour cette lettre
                    arr.put(l, arr.get(l)+f);
                }else {//premiere fois pour cette lettre
                    arr.put(l, f);
                }
                p--;
            }else{
                p++;
            }
        }

        Float maxP = 0F;

        Set<Character> setC = arr.keySet();
        //on détermine le max
        for (Character c: setC) {
            float cp = arr.get(c);
            if(cp > maxP){
                maxP = cp;
            }
        }
        /*
        for (Character c: setC) {
            System.out.println(c + " => " + arr.get(c));
        }*/
        //on supprime les entrées de poids plus faible
        for (Character c: setC) {
            if( arr.get(c) < maxP ){
                arr.remove(c);
            }
        }

        setC = arr.keySet();

        List<Character> list = new ArrayList<Character>();
        list.addAll(setC);
        Collections.sort(list);
        System.out.print(list.get(0));
        //System.out.print(arr.get(list.get(0)));

    }

}
