
/**
 * This data structure provides default queue behavior, such as enqueue,
 * dequeue, getFront, and isEmpty.
 *
 * @author Syed Arib Ali
 * @version 07/28/2021
 * @param <T>
 *            The type of elements contained in the LinkedQueue.
 */
public class LinkedQueue<T>

{
    private int  numberElem;
    private Node top;
    private Node bottom;

    private class Node
    {
        private T    element;
        private Node next;
    }

    /**
     * Constructor for the LinkedQueue.
     */
    public LinkedQueue()
    {
        numberElem = 0;
        top = null;
        bottom = null;

    }


    /**
     * Insert an element to the queue.
     *
     * @param element
     *            the element that will be added.
     */
    public void enqueue(T element)
    {
        Node temp = bottom;
        bottom = new Node();
        bottom.element = element;
        bottom.next = null;
        if (isEmpty())
        {
            top = bottom;
        }
        else
        {
            temp.next = bottom;
        }
        numberElem++;

    }


    /**
     * Removes the first item that was added.
     *
     * @return the element that was first added.
     */
    public T dequeue()
    {
        if (isEmpty())
        {
            System.out.print(
                "Dequeue attempted on an empty queue. Null is returned.");
            return null;
        }
        T element = top.element;
        top = top.next;
        numberElem--;
        if (isEmpty())
        {
            bottom = null;
        }
        return element;
    }


    /**
     * Obtains the number of elements in the queue.
     *
     * @return the number of elements in this queue.
     */
    public int size()
    {
        return numberElem;
    }


    /**
     * Checks whether the queue is empty.
     *
     * @return true if queue is empty otherwise false.
     */
    public boolean isEmpty()
    {
        return top == null;
    }


    /**
     * Obtains the last element in the queue.
     *
     * @return the last element in the queue.
     */
    public T peek()
    {
        if (isEmpty())
        {
            System.out
                .print("Peek attempted on an empty queue. Null is returned.");
            return null;
        }
        return top.element;
    }

}
