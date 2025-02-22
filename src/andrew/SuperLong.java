package andrew;

import java.util.ArrayList;

public class SuperLong {
    private ArrayList<Byte> num1 = new ArrayList<Byte>();
    private ArrayList<Byte> num2;
    private ArrayList<Byte> num3;
    private String num1Sign = "+";
    private String num2Sign = "+";
    private String finalSign = "+";

    public SuperLong(String val) {
        if(val.substring(0,1).equals("-")){
            num1Sign = val.substring(0,1);
            val = val.substring(1);
        }
        for (int i = 0; i < val.length(); i++)
            num1.add(Byte.valueOf(val.substring(i, i + 1)));
        num2 = new ArrayList<Byte>();
        num3 = new ArrayList<Byte>();
    }
    public ArrayList<Byte> biggerNum(ArrayList<Byte> y, ArrayList<Byte> x ){
        if(y.size() > x.size()){
            return y;
        }
        else if(x.size() > y.size()){
            return x;
        }
        else{
            for(int i = y.size() - 1; i >= 0;) {
                if(y.get(i) > x.get(i)){
                    return y;
                }
                else if(x.get(i) > y.get(i)){
                    return x;
                }
                else{
                    return null;
                }
            }
        }
        return null;
    }
    public ArrayList<Byte> add(String val){
        int y =0;
        int z = 0;
        int carry = 0;
        boolean used = false;
        ArrayList<Byte> x = new ArrayList<>();
        if(val.substring(0,1).equals("-") || val.substring(0,1).equals("+")){
            num2Sign = val.substring(0,1);
            val = val.substring(1);
        }
        
        
        num2 = stringToArray(val);

        int sum = 0;
        if(biggerNum(num1, num2) == num1){
            finalSign = num1Sign;
            
        }
        else{
            finalSign = num2Sign;
            x = num1;
            num1 = num2;
            num2 = x;
        }
        addLeadingZero(num1, num2);
        for(int j = num1.size() - 1; j >= 0; j--){
                sum = num1.get(j) + num2.get(j);
                if(num2Sign.equals("-") && num1Sign.equals("-")){
                    finalSign = "-";
                }
                if(num2Sign.equals("-") && num1Sign.equals("+") || num2Sign.equals("+") && num1Sign.equals("-")){
                    
                    try{
                        if(num1.get(j) < num2.get(j)){
                            
                            if(j==0){
                                finalSign = flip(finalSign);

                            }
                            else{
                                y = num1.get(j-1) - 1;
                                num1.remove(j-1);
                                num1.add(j-1, (byte)y);
                                
                                z = num1.get(j) + 10;
                                num1.remove(j);
                                num1.add(j, (byte)z);
                            }


                            
                        }
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Index out of bounds for j - " + j);
                    }

                    sum = -1*(num1.get(j)) + (num2.get(j));
                    
                }
                
                if (carry > 0 && !used) {
                    sum += carry;
                    used = true;
                }
                if (sum >= 10) {
                    carry = Byte.parseByte(Byte.toString((byte)10).substring(0, 1));
                    sum -= 10 * carry;
                    used = false;
                }
                if (used) {
                    carry = 0;
                }
                if (j == 0) {
                    sum += 10 * carry;
                }

                num3.add((byte)sum);
        }
        
        return num3;
    }
    public String flip(String x){
        if(x.equals("-")){
            x = "+";
        }
        else{
            x = "-";
        }
        return x;
    }
    public ArrayList<Byte> subtract(String val){
        if(val.substring(0,1).equals("-")){
            num2Sign = val.substring(0,1);
            val = val.substring(1);
        }
        num3 = add(flip(num2Sign) + val);
        return num3;
    }
    public ArrayList<Byte> stringToArray(String val){
        int x = 0;
        ArrayList<Byte> interim = new ArrayList<>();
        if(val.substring(0,1).equals("-")){
            val = val.substring(1);
        }
        
        for (int i = 0; i < val.length(); i++)
            interim.add(Byte.valueOf(val.substring(i, i + 1)));
        return interim;
    }
    public void addLeadingZero(ArrayList<Byte> x, ArrayList<Byte> y){
        
        if(y.size() > x.size()){
            for(int i = y.size(); i >= 0 ; i--){
                try{
                    x.get(i);
                }
                catch(IndexOutOfBoundsException e){
                    x.add(0,(byte)0);
                }
            }
        }
        if(y.size() < x.size()){
            for(int i = x.size(); i >= 0 ; i--){
                try{
                    y.get(i);
                }
                catch(IndexOutOfBoundsException e){
                    y.add(0, (byte)0);
                }
            }
        }

    }
    public ArrayList<Byte> removeLeadingZero(ArrayList<Byte> y){
        for(int i = 0; i < y.size(); i++){
            if(y.get(i) == 0 && y.get(i +1) == 0){
                y.remove(i);
            }
            if(y.get(i) == 0 && y.get(i+1) > 0 || y.get(i) == 0 && y.get(i + 1) < 0){
                y.remove(i);
                return y;
            }
        }
        return y;
    }
    public int multiplySign(){
        int y;
        int z;
        y = Byte.parseByte(num1Sign + "1");
        z = Byte.parseByte(num2Sign + "1");
        String x = "";
        for(int i = num3.size() - 1; i >= 0; i--){
            x += Byte.toString(num3.get(i));
        }
        return Byte.parseByte(x) * y * z;
    }
    public String toString(){
        String x = finalSign;
        String y;
        
        for(int i = num3.size() - 1; i >= 0; i--){
            y = Byte.toString(num3.get(i));
            y = y.replaceAll("-", "");
            x += y;
            
        }
        
        return x;
    }
}
