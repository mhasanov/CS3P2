
public class Chess {

    private static ChessTreeNode root;
    
    /**
     * Main function executed by console
     * 
     * @param args  arguments passed by the console
     */
    public static void main(String[] args) {
        mainHelper(args);
    }
    
    /**
     * Decides which command is called using the argument count
     * 
     * @param args  Arguments passed by console
     */
    public static void mainHelper(String[] args) {
        
        if (args.length == 0 || args.length > 3) {
            throw new IllegalArgumentException();
        }
        else if(args.length == 1) {
            bfsToWin(args[0]);
        }
        else if(args.length == 2) {
            printTree(args[0], args[1]);
        }
        else if(args.length == 3) {
            dfsToTarget(args[0], args[1], args[2]);
        }
        
            
    }

    /**
     * 
     * 
     * @param startingState The Starting State
     * @param depthLimit how far the function should got depth-wise
     * @param target The target board
     */
    private static void dfsToTarget(String startingState, String depthLimit, String target) {
        root = new ChessTreeNode(startingState);
        
    }

    /**
     * Prints the tree, uses prre-order traversal
     * 
     * @param startingState The Starting State
     * @param depthLimit how far the function should got depth-wise
     */
    private static void printTree(String startingState, String depthLimit) {
        root = new ChessTreeNode(startingState);
        
    }

    /**
     * Finds the state with over 200 fitness in the fewest moves
     * 
     * @param startingState The Starting State
     */
    private static void bfsToWin(String startingState) {
        root = new ChessTreeNode(startingState);
        
    }
    
    //static
    
    //String[] getNextMoves(String board)
    //String getNextBoard(String board, String move)
    //int getFitnessChange(String oldBoard, String move)
    
    
    
    
    
    

}
