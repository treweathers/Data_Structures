import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int decimal = scnr.nextInt();
      String binary = decimalToBinary(decimal);
      System.out.println(binary);

      /* Type your code here. */
      

   }
   public static String decimalToBinary(int decimal)
   {
      /* Type your code here. */
      Stack s = new Stack(32);
      
      while (decimal > 0) {
         int remainder = decimal % 2;
         s.push(remainder);
         decimal = decimal / 2;
      }
      
      StringBuilder result = new StringBuilder();
      
         while (!s.isEmpty()) {
            result.append(s.pop());
         }
         
         return result.toString();
      
      
   }
}
