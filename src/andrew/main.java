package andrew;

import java.util.*;

class Main{
    public static void main(String[] args){
        SuperLong a = new SuperLong("-4344936009049315546");

        long start = System.currentTimeMillis();
        for (int i = 0; i<1000; i++) {
            a.add("4025372428371997405");
        }
        System.out.println(a.toString());
        long stop = System.currentTimeMillis();
        System.out.println(stop-start + " milliseconds");
    }

}