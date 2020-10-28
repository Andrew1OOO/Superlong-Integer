import java.util.Arrays;

public class SuperLong {

    String value;
    
    public SuperLong(String n){
        value = n;
    }

    public String toString() {
        return value;
    }
     
    private long[] toLongArray(String a) {
        long[] arrayA;
        if (a.length() < 10) {
            arrayA = new long[1];
            arrayA[0] = Long.parseLong(a);
        }
        else {
            arrayA = new long[(int)Math.ceil(a.length()/9.0)];
            boolean isNegative = a.charAt(0) == '-';
            if (isNegative) {
                a = a.substring(1,a.length());
            }

            while (a.length() % 9 != 0) {
                a = "0" + a;
            }

            for (int i = 0; i < a.length(); i++) {
                if (i%9 == 0) {
                    if (isNegative) {
                        arrayA[i/8] = Long.parseLong("-"+a.substring(i, i+9));
                    }
                    else {
                        arrayA[i/8] = Long.parseLong(a.substring(i, i+9));
                    }
                    
                }
                
            }
        }

        return arrayA;
    }
    public String add(String a, String b) {

        while (b.length() < a.length()) {
            b = "0" + b;
        }
        while (a.length() < b.length()) {
            a = "0" + a;
        }
        
        long[] arrayA = toLongArray(a);
        long[] arrayB = toLongArray(b);

        int size = arrayA.length;

        long[] sum = new long[size+1];

        long carry = 0; 
        
        for (int i = size-1; i >= 0; i--) {
            long newSum = arrayA[i] + arrayB[i] + carry;
            sum[i] = newSum;
            String added = String.valueOf(newSum);
            if ((newSum >= 0 && added.length() > 9) || (newSum < 0 && added.length() > 10)) {
                carry = Long.parseLong(added.substring(0, added.length()-8));
                System.out.println(carry);
            }
        }

        String output = "";
        for (int i=0; i<sum.length; i++) {
            if (i != 0) {
                output += Math.abs(sum[i]);
            }
            else {
                output += sum[i];
            }
            
        }
        return output.substring(0, output.length()-1);
    }

}
