// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue
{
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //--------------------------------------------------------------
    public Queue(int s)          // constructor
    {
        maxSize = s;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //--------------------------------------------------------------
    public void insert(int j)   // put item at rear of queue
    {
        if(rear == maxSize-1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++;                     // one more item
    }
    //--------------------------------------------------------------
    public int remove()         // take item from front of queue
    {
        int temp = queArray[front++]; // get value and incr front
        if(front == maxSize)           // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }
    //--------------------------------------------------------------
    public int peekFront()      // peek at front of queue
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true if queue is empty
    {
        return (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if queue is full
    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size()           // number of items in queue
    {
        return nItems;
    }
    public void display() 
    {
         for (int i = 0; i < nItems; i++)
            System.out.print(queArray[(front + i) % maxSize]+" ");
         System.out.println();
    }
    public int[] toArray()
    {
         int[] outArray = new int[nItems];
         for (int i = 0; i < nItems; i++)
            outArray[i] = queArray[(front + i) % maxSize];
         return outArray;
    }
    
    public void reverse () {
       int queSize = this.size();
       Stack stack = new Stack(queSize);
       
       while (!this.isEmpty()) {
          stack.push(remove());
       }
       
       while (!stack.isEmpty()) {
          insert(stack.pop());
       }
    }
}