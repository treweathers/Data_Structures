class Link
{
    public int iData;         // data item
    public Link next;         // next link in list
    // -------------------------------------------------------------
    public Link(int id)         // constructor
    {
        iData = id;         // initialize data
    }
    // -------------------------------------------------------------
    public void displayLink()     // display ourself
    {
        System.out.print(iData + " ");

    } // end class Link
}
