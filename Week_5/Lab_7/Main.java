import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      DoublyLinkedList priorityList = new DoublyLinkedList();
      
      if (!scnr.hasNextInt()) {
         return;
      }
      
      int count = scnr.nextInt();
      
      for (int i = 0; i < count; i++) {
         if (scnr.hasNextLong()) {
            long key = scnr.nextLong();
            priorityList.priorityInsert(key);
         } else {
            break;
         }
      }
      
      priorityList.displayForward();
      
      Link_D removedNode = priorityList.priorityRemove();
      
      if (removedNode != null) {
         priorityList.displayForward();
      }
      
      scnr.close();
   }
}