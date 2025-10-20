// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
// The HighArray class is a data structure that encapsulates a simple array
// and provides a set of high-level methods for common array operations
// such as insertion, searching, deletion, and finding the maximum value.
class HighArray
{
    private long[] a;                 // ref to array a: This is a reference to the underlying array that holds the data.
    private int nElems;               // number of data items: This integer tracks the number of actual items currently stored in the array.
    //-----------------------------------------------------------
    // The constructor initializes the HighArray object.
    // It creates a new array of a specified maximum size and
    // sets the initial number of elements to zero.
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array with the specified maximum capacity.
        nElems = 0;                        // no items yet: The array is initially empty.
    }
    //-----------------------------------------------------------
    // This method searches for a specific value within the array.
    // It iterates through the elements until the value is found or the end of the data is reached.
    public boolean find(long searchKey)
    {                              // find specified value
        int j;
        for(j=0; j<nElems; j++)            // for each element,
            if(a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if(j == nElems)                    // gone to end?: If the loop completed without finding the item, 'j' will be equal to 'nElems'.
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()
    //-----------------------------------------------------------
    // The insert method adds a new value to the end of the array.
    // It places the value at the next available position and increments the element count.
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it at the current end of the data.
        nElems++;                      // increment size to reflect the new item.
    }
    //-----------------------------------------------------------
    // This method deletes the first occurrence of a specified value from the array.
    // If found, it shifts all subsequent elements down to fill the gap,
    // thereby maintaining a contiguous block of data.
    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++)        // look for it
            if( value == a[j] )
                break;
        if(j==nElems)                  // can't find it: The loop finished without finding the value.
            return false;
        else                           // found it: The loop was exited because the value was found at index 'j'.
        {
            // Shifts all elements after the deleted one down by one position.
            for(int k=j; k<nElems; k++) // move higher ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size to reflect the removal of one item.
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------
    // The display method prints all the current elements of the array to the console.
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------
    
    // This method finds and returns the largest value in the array.
    // It does not modify the array. If the array is empty, it returns -1.
    public long getMax() {
      if (nElems == 0) {
         return -1;
      }
       long max = a[0];
       
       for (int j = 0; j < nElems; j++) {
          if (a[j] > max) {
             max = a[j];
          }
       }
       
       return max;
    }

   // This method finds, removes, and returns the largest value in the array.
   // It's useful for sorting algorithms where you repeatedly extract the maximum element.
   public long removeMax() {
      if (nElems == 0) {
         return -1;
      }
       long max = a[0];
       int maxInd = 0;
       
       // Finds the maximum value and its index.
       for (int j = 1; j < nElems; j++) {
          if (a[j] > max) {
             max = a[j];
             maxInd = j;
         } 
      }
       
      // Shifts all elements after the maximum value down to fill the gap.
      for (int k = maxInd; k < nElems - 1; k++) {
         a[k] = a[k + 1];
       }
       nElems--; // Decrements the size of the array after removal.
       return max; // Returns the removed maximum value.
   }
    
    // Returns the number of elements currently in the array.
    public int size() {
       return nElems;
    }
    
    // This method is used to retrieve the entire underlying array.
    public long[] getArray() {
       return a;
    }
}  // end class HighArray
////////////////////////////////////////////////////////////////