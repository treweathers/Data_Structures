import java.util.*;

// The Main class serves as the entry point for the application.
// It demonstrates the usage of the HighArray class by creating an array,
// performing various operations like insertion, searching, deletion,
// and finally, sorting the elements.
public class Main
{
    // The main method is where the program execution begins.
    // It initializes a HighArray object and performs a series of operations
    // on it to test its functionality.
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        // Inserts 10 integer values into the HighArray.
        // The insert() method adds each item to the end of the array.
        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        // Searches for a specific value (searchKey) in the array.
        // The find() method returns true if the value is found, and false otherwise.
        int searchKey = 35;           // search for item
        if( arr.find(searchKey) )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        // Deletes three items from the array: 00, 55, and 15.
        // The delete() method shifts the remaining elements to fill the gap.
        // Note that '15' is not present, so the array will remain unchanged after that call.
        System.out.println("Deleting 00, 55, 15");
        arr.delete(00);               // delete 3 items
        arr.delete(55);
        arr.delete(15);//arr.delete(99);

        arr.display();                // display items again

        // Calls getMax() to find the largest value in the array.
        // This method finds the maximum value without removing it.
        System.out.println("\ngetMax() returned "+arr.getMax());

        // Calls removeMax() to find and remove the largest value from the array.
        // The array is then displayed again to show the removal.
        arr.removeMax();
        System.out.println("\nAfter calling removeMax()");
        arr.display();
        
        System.out.println("\nSorting using removeMax()");
        // Sort as stated in the requirements and display the sorted array        
 
        // This section of the code sorts the array in descending order.
        // It repeatedly calls removeMax() to get the largest remaining element
        // and stores it in a new sorted array.
        long[] sorted = new long[maxSize];
        int originalSize = arr.size();
        int j = 0;
        // The while loop continues as long as there are elements in the HighArray.
        while (arr.size() > 0) {
                      // removeMax() returns and removes the largest item, which is then stored in the sorted array.
                      sorted[j] = arr.removeMax();
                      j++;
        }

        // Iterates through the newly created sorted array and prints its elements.
        // This displays the result of the sorting process.
        for (int i=0; i< j; i++) {
           System.out.print(sorted[i] + " ");
        }
    }  // end main()
}  // end class HighArrayApp
