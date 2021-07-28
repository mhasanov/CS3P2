
/**
 * This data structure implements QueueInterface with a circular array
 * implementation. It provides default queue behavior, such as enqueue, dequeue,
 * getFront, and isEmpty. Note: I utilized this class in CS2114.
 *
 * @author Syed Arib Ali
 * @version 07/28/2021
 * @param <T>
 *            The type of elements contained in the ArrayQueue.
 */
public class ArrayQueue<T>
{
    private T[]             queue;
    /**
     * The default capacity of the ArrayQueue.
     */
    public static final int DEFAULT_CAPACITY = 20;
    /**
     * The maximum capacity of the ArrayQueue.
     */
    public static final int MAX_CAPACITY     = 160;
    private int             enqueueIndex; // backIndex
    private int             dequeueIndex; // frontIndex
    private int             size;

    /**
     * Creates a new ArrayQueue object.
     */
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }


    /**
     * Creates a new ArrayQueue object based on the capacity.
     *
     * @param capacity
     *            the capacity of the ArrayQueue.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity)
    {
        queue = (T[])new Object[capacity + 1];
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }


    /**
     * Obtains the length of the queue.
     *
     * @return the length of the queue.
     */
    public int getLength()
    {
        return queue.length;
    }


    /**
     * Obtains the size of the queue.
     *
     * @return the size of the queue.
     */
    public int getSize()
    {
        return size;
    }


    /**
     * Checks whether the queue is empty or not.
     *
     * @return True, if the queue is empty. False, otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Checks whether the queue has reached its capacity.
     *
     * @return True, if the queue is full. False, otherwise.
     */
    private boolean isFull()
    {
        return this.size == MAX_CAPACITY;
    }


    /**
     * Inserts the element at the back of the queue.
     *
     * @param element
     *            The element that will be added.
     */
    public void enqueue(T element)
    {
        ensureCapacity();
        queue[enqueueIndex] = element;
        enqueueIndex = this.incrementIndex(enqueueIndex);
        size++;
    }


    /**
     * Helper method used to upgrade the length of the underlying array when it
     * is full.
     *
     * @throws IllegalStateException
     *             when the queue has reached MAX_CAPACITY.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        if (isFull())
        {
            throw new IllegalStateException("Max capacity has been reached.");
        }
        if (this.size == this.getLength() - 1)
        {
            int index = 0;
            T[] newQueue = (T[])new Object[this.size * 2 + 1];
            for (int i = dequeueIndex; i != enqueueIndex; i = incrementIndex(i))
            {
                newQueue[index] = queue[i];
                index++;
            }
            dequeueIndex = 0;
            enqueueIndex = this.size;
            queue = newQueue;
        }
    }


    /**
     * Removes the element of the queue from the front.
     *
     * @return The element at the front of the queue.
     */
    public T dequeue()
    {
        T item = this.getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = this.incrementIndex(dequeueIndex);
        size--;
        return item;
    }


    /**
     * Obtains the item at the front of the queue.
     *
     * @return The item at the front of the queue.
     */
    public T getFront()
    {
        if (isEmpty())
        {
            System.out.print(
                "Get Front attempted on an empty queue. Null is returned.");
            return null;
        }
        return queue[dequeueIndex];
    }


    /**
     * Clears everything in the queue.
     */
    @SuppressWarnings("unchecked")
    public void clear()
    {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }


    /**
     * Assists with the circular queue logic, and increments the index after
     * checking the logic.
     *
     * @param index
     *            the index that will be incremented.
     * @return The value of index after it's been incremented.
     */
    private int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
    }


    /**
     * Places the queue into an array that can be accessed by the user.
     *
     * @return the array of the queue.
     */
    @SuppressWarnings("unchecked")
    public T[] toArray()
    {
        if (isEmpty())
        {
            System.out.print(
                "ToArray attempted on an empty queue. Null is returned.");
            return null;
        }
        int index = dequeueIndex;
        int x = 0;
        T[] array = (T[])new Object[getSize()];
        while (index != enqueueIndex)
        {
            array[x] = queue[index];
            x++;
            index = incrementIndex(index);
        }
        return array;
    }


    /**
     * ToString of the ArrayQueue class.
     *
     * @return the string representation of the queue.
     */
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        int index = dequeueIndex;
        StringBuilder s = new StringBuilder("[");
        while (index != enqueueIndex - 1)
        {
            s.append(queue[index].toString() + ", ");
            index = incrementIndex(index);
        }
        s.append(queue[enqueueIndex - 1].toString() + "]");
        return s.toString();
    }


    /**
     * Checks whether the two ArrayQueues are equal based on the elements and
     * their order.
     *
     * @param obj
     *            The queue that the current queue will be compared with.
     * @return True, if both the queue are equal. False, otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass().equals(obj.getClass()))
        {
            ArrayQueue<T> temp = ((ArrayQueue<T>)obj);
            if (temp.getSize() == this.getSize())
            {
                for (int i = 0; i < this.getSize(); i++)
                {
                    T myElement = queue[(dequeueIndex + i) % queue.length];
                    T otherElement =
                        temp.queue[(temp.dequeueIndex + i) % temp.queue.length];
                    if (!myElement.equals(otherElement))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
