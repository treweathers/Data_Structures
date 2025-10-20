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
      
      int removeVal = scnr.nextInt();
      
      System.out.println(theList.toString() + " ");
      System.out.println("theList.removeLast(" + removeVal + ")");
      theList.removeLast(removeVal);
      
      
      //if (removeVal == 7 || removeVal == 1) {
         //System.out.print(theList.toString() + " ");
         //System.out.print("theList.removeAll(" + removeVal + ")");
         
         //theList.removeAll(removeVal);
         
         //System.out.println(theList.toString() + " ");
         
      //} else {
         System.out.println(theList.toString() + " ");
         int n2 = scnr.nextInt();
         
         LinkList theList2 = new LinkList();
         
         for (int i = 0; i < n2; i++) {
            int number = scnr.nextInt();
            theList2.insertFirst(number);
         }
      
         int removeAllVal = scnr.nextInt();
         
         System.out.println(theList2.toString() + " ");
         System.out.println("theList.removeAll(" + removeAllVal + ")");
         
         theList2.removeAll(removeAllVal);
         
         System.out.println(theList2.toString() + " ");
      
   }
}
