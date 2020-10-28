import java.util.ArrayList;

public class SuperLong {
    private ArrayList<Integer> num1 = new ArrayList<Integer>();
    private ArrayList<Integer> num2 = new ArrayList<Integer>();
    private ArrayList<Integer> num3 = new ArrayList<Integer>();
    public SuperLong(String val) {
        for (int i = 0; i < val.length(); i++)
            num1.add(Integer.valueOf(val.substring(i, i + 1)));
    }
    public ArrayList<Integer> add(String val){
        int x = 0;
        int carry = 0;
        boolean used = false;
        for (int i = 0; i < val.length(); i++)
            num2.add(Integer.valueOf(val.substring(i, i + 1)));
        int sum = 0;
        // we need to use the larger array to iterate through
        for(int j = num1.size() - 1; j >= 0; j--){
                sum = num1.get(j) + num2.get(j);
                if (carry > 0 && !used) {
                    sum += carry;
                    used = true;
                }
                if (sum >= 10) {
                    carry = Integer.parseInt(Integer.toString(10).substring(0, 1));
                    sum -= 10 * carry;
                    used = false;
                }
                if (j == 0) {
                    sum += 10 * carry;
                }
                if (used) {
                    carry = 0;
                }
                num3.add(sum);

        }

        return num3;
    }
    public String toString(){
        String x = "";
        for(int i = num3.size() - 1; i >= 0; i--){
            x += Integer.toString(num3.get(i));
            System.out.println(x);
        }
        return x;
    }
}
