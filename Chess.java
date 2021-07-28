
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
            root = new ChessTreeNode(args[0]);
            bfsToWin();
        }
        else if(args.length == 2) {
            root = new ChessTreeNode(args[0]);
            printTree(args[1]);
        }
        else if(args.length == 3) {
            root = new ChessTreeNode(args[0]);
            dfsToTarget(args[1], args[2]);
        }
        
            
    }

    /**
     * 
     * 
     * @param startingState The Starting State
     * @param depthLimit how far the function should got depth-wise
     */
    private static void dfsToTarget(String startingState, String depthLimit) {
        
    }

    /**
     * Prints the tree, uses pre-order traversal
     * 
     * @param startingState The Starting State
     */
    private static void printTree(String depthLimit) {
        int depth = Integer.parseInt(depthLimit);
        depth++;
        System.out.println(root.getState() + " fitness: 0");
        printTreeHelper(root, depth-1, "", 0);
    }

    public static void printTreeHelper(ChessTreeNode node, int depth, String prefix, int fitnessCary){

        if(depth <= 0) {
            return;
        }
        
        String[] childrenStrings = ChessFaker.getNextMoves(node.getState());
        ChessTreeNode[] children = new ChessTreeNode[childrenStrings.length];
        for(int i = 0; i < childrenStrings.length; i++) {
            children[i] = new ChessTreeNode(ChessFaker.getNextBoard(node.getState(), childrenStrings[i]));
        }
        root.setChildren(children);
        String[] moves = ChessFaker.getNextMoves(node.getState());
        
        
        for(int index = 0; index < moves.length; index++) {

            int newFitnessCary = fitnessCary + ChessFaker.getFitnessChange(node.getState(), moves[index]);
            System.out.print(prefix + "+ " + moves[index] + " = " + children[index].getState() + " ");
            System.out.println("fitness: " + newFitnessCary);
            String newPrefix = prefix + "+ " + moves[index] + " ";
            printTreeHelper(children[index], depth-1, newPrefix, newFitnessCary);
        }
        
    }
    
    /**
     * Finds the state with over 200 fitness in the fewest moves
     */
    private static void bfsToWin() {
        
    }
    
    //static
    
    //String[] getNextMoves(String board)
    //String getNextBoard(String board, String move)
    //int getFitnessChange(String oldBoard, String move)
    
    
    
    
    
    

}
