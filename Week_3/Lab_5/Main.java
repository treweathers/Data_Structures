import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      int count = scnr.nextInt();
      
      Queue myQueue = new Queue(count);
      
      for (int i = 0; i < count; i++) {
         myQueue.insert(scnr.nextInt());
      }
      
      myQueue.display();
      myQueue.reverse();
      System.out.println("After reverse");
      myQueue.display();
   }
}
