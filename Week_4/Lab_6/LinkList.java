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
        while(current.iData != key)         // while no match,
        {
            if(current.next == null)         // if end of list,
                return null;             // didnâ€™t find it
            else                 // not end of list,
                current = current.next;     // go to next link
        }
        return current;             // found it
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
    public String toString()
    {
        String returnString ="List (first-->last):";
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
           returnString +=" "+current.iData;
            //current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        return returnString;
    }
   public void removeLast(int n) {
      if (isEmpty()) {
         return;
      }
      
      Link targetPrevious = null;
      Link targetCurrent = null;
      
      Link previous = null;
      Link current = first;
      
      while (current != null) {
         if (current.iData == n) {
            targetCurrent = current;
            targetPrevious = previous;
         }
         
         previous = current;
         current = current.next;
      }
      
      if (targetCurrent != null) {
         if (targetCurrent == first) {
            first = first.next;
         } else {
            targetPrevious.next = targetCurrent.next;
         }
      }
   }
   
   public void removeAll(int n) {
      if (isEmpty()) {
         return;
      }
      
      Link current = first;
      Link previous = null;
      
      while (current != null) {
         if (current.iData == n) {
            if (previous == null) {
               first = current.next;
            } else {
               previous.next = current.next;
               current = current.next;
            }
            } else {
               previous = current;
               current = current.next;
            }
         }
      }


    // -------------------------------------------------------------

}  // end class LinkList