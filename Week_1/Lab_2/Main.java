import java.util.Scanner;

// The Main class is the driver for the program.
// It handles user input and serves as the interface
// to interact with the OrdArray class.
public class Main {
   // A static Scanner object to read user input from the console.
   static Scanner scnr = new Scanner(System.in);
   // A static reference to an OrdArray object, which will be the sorted array.
   static OrdArray arr;
   
   // The main method is the entry point of the program.
   public static void main(String[] args) {
      
      // Reads an integer seed value from the user, which is used by OrdArray's constructor.
      int seed = scnr.nextInt();    // Do not modify
      // Creates a new OrdArray instance with the given seed and a maximum size of 10.
      arr = new OrdArray(seed,10);  // Do not modify
      
      int choice;
      // This do-while loop continuously prompts the user for a choice
      // and processes their input until they enter '5' to exit.
      do {

         if (scnr.hasNextInt()) {
         choice = scnr.nextInt();
         if (choice != 5) {
            // If the choice is not 5, the input method is called to handle the command.
            input(choice);
         }
         } else {
            // If the input is not an integer (e.g., end of file), the choice is set to 5 to terminate the loop.
            choice = 5;
         }
      } while (choice != 5);
   
}
      // The input method processes the user's choice and performs the corresponding action.
      public static void input(int choice) {

      // A switch statement is used to execute different code blocks based on the 'choice' value.
      switch (choice) {
         // Case 1: Fill the array with a specified number of random values.
         case 1:
            int num = scnr.nextInt();
            // Validates that the number of elements to fill is within a valid range.
            if (num > 0 && num <= 10) {
               arr.fillArray(num);
            } else {
               System.out.println("invalid");
            }
            // Displays the current contents of the array after the operation.
            arr.display();
            break;
            
         // Case 2: Add a new number to the array while maintaining its sorted order.
         case 2:
            int number = scnr.nextInt();
            arr.addNumber(number);
            arr.display();
            break;
            
         // Case 3: Find the index of a specified number in the sorted array.
         case 3:
            int numInd = scnr.nextInt();
            int foundInd = arr.findIndex(numInd);
            
            // Checks if the number was found. The findIndex method returns the size of the array if the number is not found.
            if (foundInd != arr.size()) {
               System.out.println("Index = " + foundInd);
            } else {
               System.out.println("not found");
            }
            arr.display();
            break;
         
         // Case 4: Remove a number at a specific index.
         case 4:
            int delete = scnr.nextInt();
            arr.removeIndex(delete);
            arr.display();
            break; 
            
         // Case 5: Exit the program. The return statement exits the current method.
         case 5:
            return;
         
         // The default case handles any invalid integer input that doesn't match a case.
         default:
            System.out.println("invalid");
      }
   }
   
}