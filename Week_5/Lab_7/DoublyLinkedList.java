class DoublyLinkedList
{
    private Link_D first;               // ref to first item
    private Link_D last;                // ref to last item
    
    public void priorityInsert(long key) {
       Link_D newLink = new Link_D(key);
       
       if (isEmpty()) {
          first = newLink;
          last = newLink;
          return;
       }
       
       Link_D current = first;
       
       while (current != null && current.dData < key) {
          current = current.next;
       }
       
       if (current == first) {
          first.previous = newLink;
          newLink.next = first;
          first = newLink;
       } else if (current == null) {
          last.next = newLink;
          newLink.previous = last;
          last = newLink;
       } else {
          newLink.next = current;
          newLink.previous = current.previous;
          
          current.previous.next = newLink;
          current.previous = newLink;
       }
    }
    
    public Link_D priorityRemove() {
      if (isEmpty()) {
         return null;
      }
      
      return deleteLast();
}
    // -------------------------------------------------------------
    public DoublyLinkedList()         // constructor
    {
        first = null;                  // no items on list yet
        last = null;
    }
    // -------------------------------------------------------------
    public boolean isEmpty()          // true if no links
    { 
        return first==null; 
    }
    // -------------------------------------------------------------
    public void insertFirst(long dd)  // insert at front of list
    {
        Link_D newLink = new Link_D(dd);   // make new link

        if (isEmpty() )                // if empty list,
            last = newLink;             // newLink <-- last
        else
            first.previous = newLink;   // newLink <-- old first
        newLink.next = first;          // newLink --> old first
        first = newLink;               // first --> newLink
    }
    // -------------------------------------------------------------
    public void insertLast(long dd)   // insert at end of list
    {
        Link_D newLink = new Link_D(dd);   // make new link
        if (isEmpty())                // if empty list,
            first = newLink;            // first --> newLink
        else
        {
            last.next = newLink;        // old last --> newLink
            newLink.previous = last;    // old last <-- newLink
        }
        last = newLink;                // newLink <-- last
    }
    // -------------------------------------------------------------
    public Link_D deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
        Link_D temp = first;
        if(first.next == null)         // if only one item
            last = null;                // null <-- last
        else
            first.next.previous = null; // null <-- old next
        first = first.next;            // first --> old next
        return temp;
    }
    // -------------------------------------------------------------
    public Link_D deleteLast()          // delete last link
    {                              // (assumes non-empty list)
        Link_D temp = last;
        if(first.next == null)         // if only one item
            first = null;               // first --> null
        else
            last.previous.next = null;  // old previous --> null
        last = last.previous;          // old previous <-- last
        return temp;
    }
    // -------------------------------------------------------------
    // insert dd just after key
    public boolean insertAfter(long key, long dd)
    {                              // (assumes non-empty list)
        Link_D current = first;          // start at beginning
        while(current.dData != key)    // until match is found,
        {
            current = current.next;     // move to next link
            if(current == null)
                return false;            // didn't find it
        }
        Link_D newLink = new Link_D(dd);   // make new link

        if(current==last)              // if last link,
        {
            newLink.next = null;        // newLink --> null
            last = newLink;             // newLink <-- last
        }
        else                           // not last link,
        {
            newLink.next = current.next; // newLink --> old next
            // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current;    // old current <-- newLink
        current.next = newLink;        // old current --> newLink
        return true;                   // found it, did insertion
    }
    // -------------------------------------------------------------
    public Link_D deleteKey(long key)   // delete item w/ given key
    {                              // (assumes non-empty list)
        Link_D current = first;          // start at beginning
        while(current.dData != key)    // until match is found,
        {
            current = current.next;     // move to next link
            if(current == null)
                return null;             // didn't find it
        }
        if(current==first)             // found it; first item?
            first = current.next;       // first --> old next
        else                           // not first
        // old previous --> old next
            current.previous.next = current.next;

        if(current==last)              // last item?
            last = current.previous;    // old previous <-- last
        else                           // not last
        // old previous <-- old next
            current.next.previous = current.previous;
        return current;                // return value
    }
    // -------------------------------------------------------------
    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        Link_D current = first;          // start at beginning
        while(current != null)         // until end of list,
        {
            current.displayLink_D();      // display data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }
    public String toString()
    {
        String outputString = "";
        Link_D current = first;          // start at beginning
        while(current != null)         // until end of list,
        {
           outputString +=current.toString() + " ";
           current = current.next;     // move to next link
        }
        return outputString;
    }
    // -------------------------------------------------------------
    public void displayBackward()
    {
        System.out.print("List (last-->first): ");
        Link_D current = last;           // start at end
        while(current != null)         // until start of list,
        {
            current.displayLink_D();      // display data
            current = current.previous; // move to previous link
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
}  // end class DoublyLinkedList