/**
 * ChessTreeNode will store children nodes and the board state.
 *
 * @author Syed Arib Ali
 * @author Mehdi Hasanov
 * @version 07/28/2021
 */
public class ChessTreeNode
{

    private String          state;
    private ChessTreeNode[] children;

    /**
     * Create a new ChessTreeNode object.
     *
     * @param state
     *            The state of the board.
     */
    public ChessTreeNode(String state)
    {
        this.state = state;
    }


    /**
     * Obtains the state of the board.
     *
     * @return The state of the board.
     */
    public String getState()
    {
        return state;
    }


    /**
     * Obtains the children of the ChessTreeNode.
     *
     * @return An array of children of the ChessTreeNode.
     */
    public ChessTreeNode[] getChildren()
    {
        return children;
    }


    /**
     * Sets the children of the ChessTreeNode.
     *
     * @param children
     *            Array of ChessTreeNode objects which are the children of the
     *            current ChessTreeNode.
     */
    public void setChildren(ChessTreeNode[] children)
    {
        this.children = children;
    }
}
