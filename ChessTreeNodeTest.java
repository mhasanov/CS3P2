import student.TestCase;

/**
 * ChessTreeNodeTest will test all the methods in ChessTreeNode class to make
 * sure they perform as expected.
 *
 * @author Syed Arib Ali
 * @author Mehdi Hasanov
 * @version Jul 28, 2021
 */
public class ChessTreeNodeTest
    extends TestCase
{
    private ChessTreeNode node1;
    private ChessTreeNode child1;
    private ChessTreeNode child2;

    /**
     * Sets up each of the Test Cases.
     */
    public void setUp()
    {
        node1 = new ChessTreeNode("Stonewall");
        child1 = new ChessTreeNode("stone");
        child2 = new ChessTreeNode("wall");
        ChessTreeNode[] children = new ChessTreeNode[2];
        children[0] = child1;
        children[1] = child2;
        node1.setChildren(children);

    }


    /**
     * Test to make sure getState() works as expected.
     */
    public void testGetState()
    {
        assertEquals("Stonewall", node1.getState());
        assertEquals("stone", child1.getState());
        assertEquals("wall", child2.getState());
    }


    /**
     * Test to make sure getChildren() works as expected.
     */
    public void testGetChildren()
    {
        assertEquals("stone", node1.getChildren()[0].getState());
        assertEquals("wall", node1.getChildren()[1].getState());
    }

}
