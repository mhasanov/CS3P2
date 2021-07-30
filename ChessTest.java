import student.TestCase;

/**
 * /** ChessTest will test all the methods in Chess class to make sure they
 * perform as expected.
 *
 * @author Syed Arib Ali
 * @author Mehdi Hasanov
 * @version 07/28/2021
 */

public class ChessTest
    extends TestCase
{
    private Chess chess;

    /**
     * Sets up the each of the test methods.
     */
    public void setUp()
    {
        chess = new Chess();
    }


    /**
     * Test to make sure main works as expected.
     */
    public void testMain()
    {
        String[] args = { "Stonewall", "2" };
        Chess.main(args);
        String[] args2 = { "StoneWall", "2", "Wall" };
        Chess.main(args2);
        String[] args3 = { "StoneWall" };
        Chess.main(args3);
        String[] args4 = { "StoneWall" };
        chess.main(args4);

        // testing with zero arguments
        String[] noArgs = {};
        Exception thrown = null;
        try
        {
            Chess.main(noArgs);
            fail("Exception not being thrown when it should.");
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        // testing with more than 3 arguments
        String[] manyArgs = { "Stonewall", "stonewall", "4", "4", "stonewall" };
        Exception thrown1 = null;
        try
        {
            Chess.main(manyArgs);
            fail("Exception not being thrown when it should.");
        }
        catch (Exception e)
        {
            thrown1 = e;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof IllegalArgumentException);
    }

}
