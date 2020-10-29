package andrew;

import java.util.*;

class Main{
    public static void main(String[] args){
        
        SuperLong a = new SuperLong("4544017515201731728");
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            a = new SuperLong("500000000000");
            a.subtract("100000000000");
        }
        
        
        long stop = System.currentTimeMillis();
        System.out.println(a.toString());
        System.out.println(stop-start + " milliseconds");
    }

}