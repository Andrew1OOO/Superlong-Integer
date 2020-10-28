import java.util.*;
import java.math.BigInteger;

class Main{
    public static void main(String[] args){

        SuperLong a = new SuperLong("1");

        String z;
        long start = System.currentTimeMillis();
        for (int i = 0; i<1000; i++) {
            z = a.add("-4025372428371997405", "-4344936009049315546");
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop-start + " milliseconds");

        start = System.currentTimeMillis();
        BigInteger x = new BigInteger("-4025372428371997405");
        BigInteger q = new BigInteger("-4344936009049315546");
        BigInteger y;
        for (int i = 0; i<100000; i++) {
            y = x.add(q);
        }
        stop = System.currentTimeMillis();
        System.out.println(stop-start + " milliseconds");
        
    }

}