// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
import java.util.Random;   // Do not change
// The OrdArray class manages an array of long values that are kept in sorted order at all times.
// This design allows for more efficient searching (using binary search) compared to a simple array.
class OrdArray
{
    private long[] a;                 // ref to array a: The underlying array that stores the sorted data.
    private int nElems;               // number of data items: The count of elements currently in the array.
    Random rnd;   // Do not change
    //-----------------------------------------------------------
    // The constructor initializes the array and the random number generator.
    // The seed is used to ensure repeatable sequences of random numbers, useful for testing.
    public OrdArray(int seed,int max)          // constructor
    {
        a = new long[max];             // create array with a specified maximum size.
        nElems = 0;
        rnd = new Random();   // Do not change
        rnd.setSeed(seed);    // Do not change: Sets the seed for the random number generator.
    }
    //-----------------------------------------------------------
    // Returns the number of elements currently in the array.
    public int size()
    { return nElems; }
    //-----------------------------------------------------------
    // This method performs a binary search to find a specified value.
    // Binary search is highly efficient on sorted arrays, dividing the search space in half with each comparison.
    public int find(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true)
        {
            // Calculates the middle index of the current search range.
            curIn = (lowerBound + upperBound ) / 2;
            if(a[curIn]==searchKey)
                return curIn;              // found it: The item is at the current index.
            else if(lowerBound > upperBound)
                return nElems;             // can't find it: The search bounds have crossed, meaning the item is not present.
            else                          // divide range
            {
                // Adjusts the search bounds based on whether the search key is greater or smaller than the current element.
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
        }  // end while
    }  // end find()
    //-----------------------------------------------------------
    // Inserts a new value into the array while maintaining the sorted order.
    // It first finds the correct insertion point and then shifts elements to make space.
    public void insert(long value)    // put element into array
    {
        int j;
        for(j=0; j<nElems; j++)        // find where it goes
            if(a[j] > value)            // (linear search): Finds the first element larger than the value to be inserted.
                break;
        for(int k=nElems; k>j; k--)    // move bigger ones up
            a[k] = a[k-1];
        a[j] = value;                  // insert it at the correct position.
        nElems++;                      // increment size
    }  // end insert()
    //-----------------------------------------------------------
    // Deletes a specified value from the array.
    // It uses the find() method to locate the value and then shifts elements to close the gap.
    public boolean delete(long value)
    {
        int j = find(value);
        if(j==nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for(int k=j; k<nElems; k++) // move bigger ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------
    // Displays all the elements currently stored in the array.
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------
    // Add your new methods here

    // Fills the array with 'n' random numbers. It first clears the array and then inserts the new numbers
    // using the insert() method to ensure the array remains sorted.
   public void fillArray(int n) {
      nElems = 0; // Clears the array by resetting the element count.
      for (int j = 0; j < n; j++) {
         long random = rnd.nextInt(99) + 1; // Generates a random number between 1 and 99.
         insert(random); // Inserts the number in the correct sorted position.
      }
   }
   
   // Adds a single number to the array, but only if the array is not full.
   public void addNumber(int n) {
      if (nElems < a.length) { // Checks if there is space in the array.
         insert(n);
      } else {
         System.out.println("full");
      }
   }
   
   // Finds the index of a given number in the array using the find() method.
   public int findIndex(int num) {
      int ind = find(num);
      return ind;
   }
   
   // Removes the element at a specific index from the array.
   // It performs a linear shift of elements to close the gap created by the removal.
   public void removeIndex(int idx) {
      // Validates that the index is within the bounds of the current elements.
      if (idx >= 0 && idx < nElems) {
         for (int j = idx; j < nElems - 1; j++) {
            a[j] = a[j + 1]; // Shifts elements to the left.
      } nElems--;
   } else {
      System.out.println("error"); // Prints an error if the index is invalid.
   }
}

}  // end class OrdArray