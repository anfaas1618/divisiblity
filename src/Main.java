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
        while (count<num.length()+2)
        {
          int num2double=Integer.parseInt( String.valueOf( num.charAt(num.length()-1)));
          num2double*=2;
          StringBuilder remaining= new StringBuilder();
            for (int i = 0; i < num.length()-count; i++) {
              remaining.append(String.valueOf(num.charAt(i)));
            }
            int remvalue = Integer.parseInt(remaining.toString());
            int value=Math.abs(remvalue-num2double);
            if (value==7)
                return true;
            count++;
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
