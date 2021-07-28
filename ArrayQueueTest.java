
import student.TestCase;

/**
 * ArrayQueueTest will test all methods in ArrayQueue class to make sure they
 * perform as expected. Note: I utilized this class in CS2114.
 *
 * @author Syed Arib Ali
 * @version 07/28/2021
 */
public class ArrayQueueTest
    extends TestCase
{
    private ArrayQueue<String> arrayQueue1;
    private ArrayQueue<String> arrayQueue2;

    /**
     * Sets up each of the Test Cases.
     */
    public void setUp()
    {
        arrayQueue1 = new ArrayQueue<String>();
        arrayQueue2 = new ArrayQueue<String>(40);
        arrayQueue1.enqueue("Entry 1");
        arrayQueue1.enqueue("Entry 2");
        arrayQueue1.enqueue("Entry 3");
        arrayQueue1.enqueue("Entry 4");
        arrayQueue2.enqueue("entry 1");
        arrayQueue2.enqueue("entry 2");
        arrayQueue2.enqueue("entry 3");
        arrayQueue2.enqueue("entry 4");
    }


    /**
     * Test to make sure getLength() works as expected.
     */
    public void testGetLength()
    {
        assertEquals(21, arrayQueue1.getLength());
        assertEquals(41, arrayQueue2.getLength());
    }


    /**
     * Test to make sure getSize() works as expected.
     */
    public void testGetSize()
    {
        assertEquals(4, arrayQueue1.getSize());
        assertEquals(4, arrayQueue2.getSize());
    }


    /**
     * Test to make sure isEmpty() works as expected.
     */
    public void testIsEmpty()
    {
        assertFalse(arrayQueue1.isEmpty());
        assertFalse(arrayQueue2.isEmpty());
        arrayQueue1.clear();
        assertEquals(true, arrayQueue1.isEmpty());
    }


    /**
     * Test to make sure enqueue() works as expected.
     */
    public void testEnqueue()
    {
        arrayQueue1.enqueue("Entry 5");
        assertEquals(5, arrayQueue1.getSize());
        assertEquals("Entry 1", arrayQueue1.getFront());
        // Adding 21 elements to make sure ensureCapcity works
        for (int i = 6; i < arrayQueue1.getLength(); i++)
        {
            arrayQueue1.enqueue("Entry" + i);
        }
        arrayQueue1.enqueue("Entry 21");
        assertEquals(21, arrayQueue1.getSize());
        assertEquals(41, arrayQueue1.getLength());
        // Adding beyond 150 elements to make sure ensureCapacity throws
        // exception.
        Exception thrown = null;
        try
        {
            for (int i = 0; i < arrayQueue1.getLength(); i++)
            {
                arrayQueue1.enqueue("Entry" + i);
            }
            fail("Exception not being thrown when it should.");
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
    }


    /**
     * Test to make sure dequeue() works as expected.
     */
    public void testDequeue()
    {
        assertEquals("Entry 1", arrayQueue1.dequeue());
        assertEquals(3, arrayQueue1.getSize());
    }


    /**
     * Test to make sure getFront() works as expected.
     */
    public void testGetFront()
    {
        assertEquals("Entry 1", arrayQueue1.getFront());
        assertEquals(4, arrayQueue1.getSize());
        arrayQueue1.dequeue();
        arrayQueue1.dequeue();
        arrayQueue1.dequeue();
        arrayQueue1.dequeue();
        // Test to ensure that exception is thrown because the queue is empty.
        assertEquals(null, arrayQueue1.getFront());

    }


    /**
     * Test to make sure clear() works as expected.
     */
    public void testClear()
    {
        assertEquals(4, arrayQueue2.getSize());
        assertEquals(41, arrayQueue2.getLength());
        assertEquals("entry 1", arrayQueue2.getFront());
        arrayQueue2.clear();
        assertEquals(0, arrayQueue2.getSize());
        assertEquals(21, arrayQueue2.getLength());
        // ArrayQueue has been reset. Test to ensure that exception is thrown
        // because the queue is empty.

    }


    /**
     * Test to make sure toArray() works as expected.
     */
    public void testToArray()
    {
        // Testing EmptyQueueException in an empty array.
        ArrayQueue<String> empty = new ArrayQueue<String>();
        assertEquals(null, empty.toArray());
        Object[] toArray = arrayQueue1.toArray();
        assertEquals("Entry 1", toArray[0]);
        assertEquals("Entry 4", toArray[3]);

    }


    /**
     * Test to make sure toString() works as expected.
     */
    public void testToString()
    {
        String expected = "[Entry 1, Entry 2, Entry 3, Entry 4]";
        assertEquals(expected, arrayQueue1.toString());
        String expected2 = "[entry 1, entry 2, entry 3, entry 4]";
        assertEquals(expected2, arrayQueue2.toString());
        ArrayQueue<String> empty = new ArrayQueue<String>();
        String expected3 = "[]";
        assertEquals(expected3, empty.toString());
    }


    /**
     * Test to make sure equals() works as expected.
     */
    public void testEquals()
    {
        assertEquals(true, arrayQueue1.equals(arrayQueue1));
        ArrayQueue<String> nullArray = null;
        assertEquals(false, arrayQueue1.equals(nullArray));
        assertEquals(false, arrayQueue1.equals(new ArrayQueueTest()));
        ArrayQueue<String> diffSize = new ArrayQueue<String>();
        diffSize.enqueue("entry 1");
        assertEquals(false, arrayQueue1.equals(diffSize));
        // Different elements in the array
        ArrayQueue<String> diffElements = new ArrayQueue<String>();
        diffElements.enqueue("Element 1");
        diffElements.enqueue("Element 2");
        diffElements.enqueue("Element 3");
        diffElements.enqueue("Element 4");
        assertEquals(false, arrayQueue1.equals(diffElements));
        // Different order but same elements
        ArrayQueue<String> diffOrder = new ArrayQueue<String>();
        diffOrder.enqueue("Entry 1");
        diffOrder.enqueue("Entry 2");
        diffOrder.enqueue("Entry 4");
        diffOrder.enqueue("Entry 3");
        assertEquals(false, arrayQueue1.equals(diffOrder));
        // Same ArrayQueue
        ArrayQueue<String> same = new ArrayQueue<String>();
        same.enqueue("Entry 1");
        same.enqueue("Entry 2");
        same.enqueue("Entry 3");
        same.enqueue("Entry 4");
        assertEquals(true, arrayQueue1.equals(same));
        assertEquals(false, arrayQueue1.equals(arrayQueue2));
    }

}
