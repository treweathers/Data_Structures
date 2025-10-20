class Link_D
{
    public long dData;                 // data item
    public Link_D next;                  // next link in list
    public Link_D previous;              // previous link in list
    // -------------------------------------------------------------
    public Link_D(long d)                // constructor
    { 
        dData = d; 
    }
    // -------------------------------------------------------------
    public void displayLink_D()          // display this link
    { 
        System.out.print(dData + " "); 
    }
    public String toString()
    {
       String outString = "" + dData;
       return outString;
    }
    // -------------------------------------------------------------
}  // end class Link_D