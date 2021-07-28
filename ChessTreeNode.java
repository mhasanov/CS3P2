
public class ChessTreeNode {

    private String state;
    private ChessTreeNode[] children;
    
    public ChessTreeNode(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public ChessTreeNode[] getChildren() {
        return children;
    }
    
    public void setChildren(ChessTreeNode[] children) {
        this.children = children;
    }
}
