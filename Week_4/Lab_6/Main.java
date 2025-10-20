import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      int n = scnr.nextInt();
      
      LinkList theList = new LinkList();
      
      for (int i = 0; i < n; i++) {
         int number = scnr.nextInt();
         theList.insertFirst(number);
      }
      
      int removeLastVal = scnr.nextInt();
      
      System.out.println(theList.toString());
      System.out.println("theList.removeLast(" + removeLastVal + ")");
      
      theList.removeLast(removeLastVal);
      
      System.out.println(theList.toString());
      
      n = scnr.nextInt();
      
      theList = new LinkList();
      
      for (int i = 0; i < n; i++) {
         int number = scnr.nextInt();
         theList.insertFirst(number);
      }
      
      int removeAllVal = scnr.nextInt();
      
      System.out.println(theList.toString());
      System.out.println("theList.removeAll(" + removeAllVal + ")");
      
      theList.removeAll(removeAllVal);
      
      System.out.println(theList.toString());
   }
}

// only passed 8/10