import student.TestCase;

/**
 * LinkedQueueTest will test all the methods in LinkedQueue class to make sure
 * they perform as expected.
 *
 * @author Syed Arib Ali
 * @author Mehdi Hasanov
 * @version Jul 28, 2021
 */
public class LinkedQueueTest
    extends TestCase
{
    private LinkedQueue<String> lq1;
    private LinkedQueue<String> lq2;

    /**
     * Sets up each of the test case.
     */
    public void setUp()

    {
        lq1 = new LinkedQueue<String>();
        lq2 = new LinkedQueue<String>();
        lq1.enqueue("Entry 1");
        lq1.enqueue("Entry 2");
        lq1.enqueue("Entry 3");
        lq1.enqueue("Entry 4");
        lq2.enqueue("entry 1");
        lq2.enqueue("entry 2");
        lq2.enqueue("entry 3");
        lq2.enqueue("entry 4");
    }


    /**
     * Test to make sure enqueue() works as expected.
     */
    public void testEnqueue()
    {
        lq1.enqueue("Entry 5");
        assertEquals("Entry 1", lq1.peek());
    }


    /**
     * Test to make sure size() works as expected.
     */
    public void testSize()
    {
        assertEquals(4, lq1.size());
        assertEquals(4, lq2.size());
    }


    /**
     * Test to make sure isEmpty() works as expected.
     */
    public void testIsEmpty()
    {
        assertFalse(lq1.isEmpty());
        assertFalse(lq2.isEmpty());
        lq1.dequeue();
        lq1.dequeue();
        lq1.dequeue();
        lq1.dequeue();
        assertEquals(true, lq1.isEmpty());
        assertEquals(null, lq1.dequeue());
        assertEquals(null, lq1.peek());
    }

}
