import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      LinkList theList = new LinkList(); //make new list
      
      int count = 0;
      if (scnr.hasNextInt()) {
         count = scnr.nextInt();
      }
      
      for (int i = 0; i < count; i++) {
         if (scnr.hasNextInt()) {
            int key = scnr.nextInt();
            theList.insertFirst(key);
         }
      }

      // Read the items to be inserted in the list. InsertFirst each of them
        
      theList.recPrint(); //display list
      System.out.println("\nList length = "+theList.recGetLength());
      System.out.println("\nrecReversePrint:");
      theList.recReversePrint();
      
      System.out.println("\n\nrecSearchFor(45)");
      theList.recSearchFor(45);
      theList.recPrint();
      System.out.println("\necRemoveFirst 44");
      theList.recRemoveFirst(44);
      theList.recPrint();
      System.out.println("\nrecRemove all 44");
      theList.recRemoveAll(44);
      theList.recPrint();
    } //end main()   }
}