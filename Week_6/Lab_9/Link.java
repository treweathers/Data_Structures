class Link
{
    public int iData;         // data item
    public Link next;         // next link in list
    // -------------------------------------------------------------
    public Link(int id)         // constructor
    {
        iData = id;         // initialize data
        // (â€˜nextâ€™ is automatically
    }                 // set to null)
    // -------------------------------------------------------------
    public void displayLink()     // display ourself
    {
        //System.out.print("{" + iData + "} ");
        System.out.print(iData + " ");

    } // end class Link
}
