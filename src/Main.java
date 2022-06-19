import java.math.BigInteger;
import java.time.chrono.IsoEra;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main   {
    public static void main(String[] args) {
        System.out.println("enter a number");
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
      boolean isdiv2=  div2(num);
        System.out.println("is divisible by 2: "+isdiv2);
      boolean isdiv3=  div3(num);
        System.out.println("is divisible by 3: "+isdiv3);
      boolean isdiv4=  div4(num);
        System.out.println("is divisible by 4: "+isdiv4);
      boolean isdiv5=  div5(num);
        System.out.println("is divisible by 5: "+isdiv5);
      boolean isdiv6= div6(num);
        System.out.println("is divisible by 6: "+isdiv6);
      boolean isdiv7= div7(num);
        System.out.println("is divisible by 7: "+isdiv7);
    }
    private static boolean div7(String num) {
        //1123
        //double 3
        // 112 - 6
        //106
        //10-12
        //2
        int count=2;
        ArrayList<String> numbers = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            numbers.add(String.valueOf(num.charAt(i)));
        }
      //  System.out.println(numbers);
        while (numbers.size()>0){
         //   System.out.println(numbers);
          int dbl1= Integer.parseInt( numbers.get(numbers.size()-1));
            dbl1 *= 2;
           BigInteger dbl=new BigInteger (String.valueOf(dbl1));
          //  System.out.println("dbl"+dbl);
            numbers.remove(numbers.size()-1);
            num="";
            for (int i = 0; i < numbers.size(); i++) {
                num+=numbers.get(i);
            }
          //  System.out.println(num);
            BigInteger minus= new BigInteger(num);

            BigInteger value = new BigInteger("0");
            value = minus.subtract(dbl);

            BigInteger absvalue = value.abs();
            String num2 =absvalue.toString();
            numbers=new ArrayList<>();
            for (int i = 0; i < num2.length(); i++) {
                numbers.add(String.valueOf(num2.charAt(i)));
            }
           // System.out.println("value "+absvalue);
            BigInteger seven= new BigInteger("7");
            BigInteger zer0= new BigInteger("0");
            if (absvalue.mod(seven).equals(zer0)&&BigInteger.valueOf(Long.parseLong("99984")).compareTo(absvalue)>0)
                return true;
        }
        return false;
    }

    private static boolean div6(String num) {
        boolean is2=div2(num);
        boolean is3=div3(num);
        return is2 && is3;
    }

    private static boolean div5(String num) {
        return num.charAt(num.length() - 1) == '0' || num.charAt(num.length() - 1) == '5';
    }

    private static boolean div4(String num) {
        String last2="";
        last2 +=String.valueOf(num.charAt(num.length()-2));
        last2 +=String.valueOf(num.charAt(num.length()-1));
        return Integer.parseInt(last2) % 4 == 0;
    }

    private static boolean div3(String num) {
        int sum=0;
        for (int i = 0; i < num.length(); i++) {
            sum+=Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return sum % 3 == 0;
    }

    private static boolean div2(String num) {
        return Integer.parseInt(String.valueOf(num.charAt(num.length() - 1))) % 2 == 0;
    }

}
