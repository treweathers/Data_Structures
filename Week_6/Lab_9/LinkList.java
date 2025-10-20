public class LinkList
{
    private Link first;            // ref to first item on list
    // -------------------------------------------------------------
    public LinkList()              // constructor
    { 
        first = null; 
    }           // no items on list yet
    // -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    { 
        return (first==null); 
    }
    // -------------------------------------------------------------
    public void insertFirst(int dd) // insert at start of list
    {                           // make new link
        Link newLink = new Link(dd);
        newLink.next = first;       // newLink --> old first
        first = newLink;            // first --> newLink
    }
    // -------------------------------------------------------------
    //public long deleteFirst()      // delete first item
    public Link deleteFirst()      // delete first item
    {                           // (assumes list not empty)
        Link temp = first;          // save reference to link
        first = first.next;         // delete it: first-->old next
        return temp;          // return deleted link
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
    public Link find(int key)     // find link with given key
    {                 // (assumes non-empty list)
        Link current = first;             // start at â€˜firstâ€™
        while(current != null)         // while no match,
        {
            if(current.iData == key)         // if end of list,
                return current;             // didnâ€™t find it
            current = current.next;     // go to next link
        }
        return null;             // found it
    }
    // -------------------------------------------------------------
    public Link delete(int key)    // delete link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // search for link
        Link previous = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;                 // didn't find it
            else
            {
                previous = current;          // go to next link
                current = current.next;
            }
        }                               // found it
        if(current == first)               // if first link,
            first = first.next;             //    change first
        else                               // otherwise,
            previous.next = current.next;   //    bypass it
        return current;
    }

    public int getSize()
    {
        int size=0;
        Link current = first;          // start at beginning
        while(current != null)         // until end of list,
        {
            size++;
            current = current.next;     // move to next link
        }
        return size;
    }
    // returns an array with all list keys in sequence
    public int[] toArray()
    {
       int[] retArray = new int[getSize()];
       int i=0;
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            retArray[i]=current.iData;
            current = current.next;  // move to next link
            i++;
        }
        return retArray;
    }
    /* Add your methods here */
   public int recGetLength() {
       return recGetLength(first);
   }
   
   private int recGetLength(Link current) {
      if (current == null) {
         return 0;
      } else {
         return 1 + recGetLength(current.next);
      }
   }
   
   public void recReversePrint() {
      recReversePrint(first);
   }
   
   private void recReversePrint(Link current) {
      if (current == null) {
         return;
      }
      recReversePrint(current.next);
      current.displayLink();
   }
   
   public Link recSearchFor(int n) {
      Link result = recSearchFor(n, first);
      if (result == null) {
         System.out.println(n + " was not found");
      } else {
         System.out.println(n + " was found");
      }
      return result;
   }
   
   private Link recSearchFor(int n, Link current) {
      if (current == null) {
         return null;
      }
      if (current.iData == n) {
         return current;
      }
      return recSearchFor(n, current.next);
   }
   public void recRemoveFirst(int n) {
      Link oldFirst = first;
      first = recRemoveFirst(n, first);
      
      if(find(n) != null || oldFirst != first) {
         System.out.println(n + " was found");
      } else {
      }
   }
   
   private Link recRemoveFirst (int n, Link current) {
      if (current == null) {
         return null;
      }
      if (current.iData == n) {
         return current.next;
      }
      
      current.next = recRemoveFirst(n, current.next);
      return current;
   }
   
   public void recRemoveAll(int n) {
      first = recRemoveAll(n, first);
      System.out.println(n + " was found");
   }
   
   private Link recRemoveAll(int n, Link current) {
      if (current == null) {
         return null;
      }
      
      current.next = recRemoveAll(n, current.next);
      
      if (current.iData == n) {
         return current.next;
      } else {
         return current;
      }
   }
   
   public void recPrint() {
      recPrint(first);
      System.out.println();
   }
   
   private void recPrint(Link current) {
      if (current == null) {
         return;
      }
      
      current.displayLink();
      recPrint(current.next);
   }
}  // end class LinkList