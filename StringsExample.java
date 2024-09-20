import java.util.*;

public class StringsExample {
    public static void main(String[] args) {
        RomanToNumerical();
    }
    public static void RomanToNumerical(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter roman value");
        String roman = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int totalValue = 0;
        int preValue = 0;
        for(int i=roman.length()-1;i>=0;i--){
            int currvalue = map.get(roman.charAt(i));
            if(currvalue<preValue){
                totalValue -= currvalue;
            }
            else{
                totalValue += currvalue;
            }
            preValue = currvalue;
        } 
        System.out.println("Numerical value of "+roman+" is "+totalValue);
    }
}
