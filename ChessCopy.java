
/**
 * Chess will perform Print Tree, Depth First Search to Target, and Breadth
 * First Search to win depending on which arguments are present when invoking
 * the program.
 *
 * @author Syed Arib Ali
 * @author Mehdi Hasanov
 * @version 07/28/2021
 */
public class Chess {

    private static ChessTreeNode root;
    private static ArrayQueue<String> myQueue;
    private static boolean found;
    private static String movesToTarget = "";
    private static int targetFitness = 0;
    private static int nodesVisited = 0;
    private static long duration = 0;
    private static String goalChessBoard;

    /**
     * Main function executed by console
     *
     * @param args arguments passed by the console
     */
    public static void main(String[] args) {
        mainHelper(args);
    }

    /**
     * Decides which command is called using the argument count
     *
     * @param args Arguments passed by console
     */
    public static void mainHelper(String[] args) {

        if (args.length == 0 || args.length > 3) {
            throw new IllegalArgumentException();
        } else if (args.length == 1) {
            root = new ChessTreeNode(args[0]);
            bfsToWin();
        } else if (args.length == 2) {
            root = new ChessTreeNode(args[0]);
            printTree(args[1]);
        } else if (args.length == 3) {
            root = new ChessTreeNode(args[0]);
            dfsToTarget(args[1], args[2]);
        }

    }


    /**
     * @param startingState The Starting State
     * @param depthLimit    how far the function should got depth-wise
     */
    private static void dfsToTarget(String goalState, String depthLimit) {

        found = false;
        
        int depth = Integer.parseInt(depthLimit);
        depth++;
        goalChessBoard = goalState;
        System.out.println("Search from " + root.getState() + " to " + goalState);
        long initialTime = System.currentTimeMillis();
        dfsToTargetHelper(root, depth - 1, 0);
        long finalTime = System.currentTimeMillis();
        duration = finalTime - initialTime;
        System.out.println("Moves to target: " + movesToTarget);
        System.out.println("Target Fitness: " + targetFitness);
        System.out.println("Nodes Visited: " + nodesVisited);
        System.out.println("Duration: " + duration);
    }

    
    public static void dfsToTargetHelper(ChessTreeNode node, int depth, int fitness) {
        //movesToTarget : String 
        
        
        if (depth <= 0 || found == true) {
            return;
            //TODO: Make sure to have "Unknown" clause
        }
        if (node.getState() == goalChessBoard) {
            found = true;
            targetFitness = fitness;
            return;
        }

        nodesVisited++;
        
        String[] moves = ChessFaker.getNextMoves(node.getState());
        ChessTreeNode[] children = new ChessTreeNode[moves.length];
        for (int i = 0; i < moves.length; i++) {
            if (found == true) {
                return;
            }
            children[i] = new ChessTreeNode(ChessFaker.getNextBoard(node.getState(), moves[i]));
            dfsToTargetHelper(children[i], depth - 1, fitness + ChessFaker.getFitnessChange(node.getState(), moves[i]));
            if (found == true) {
                movesToTarget = "+ " + moves[i] + " " + movesToTarget;
            }
        }
    }

    /**
     * Prints the tree, uses pre-order traversal
     *
     * @param depthLimit The depth specified by the console.
     */
    private static void printTree(String depthLimit) {
        int depth = Integer.parseInt(depthLimit);
        depth++;
        System.out.println(root.getState() + " fitness: 0");
        printTreeHelper(root, depth - 1, "", 0);
    }

    /**
     * Helper method for the printTree.
     *
     * @param node        The node of the ChessTreeNode.
     * @param depth       How far the function goes in depth.
     * @param prefix      The space that needs to be added before the move.
     * @param fitnessCary The fitness of the board.
     */
    public static void printTreeHelper(ChessTreeNode node, int depth, String prefix, int fitnessCary) {

        if (depth <= 0) {
            return;
        }

        String[] childrenStrings = ChessFaker.getNextMoves(node.getState());
        ChessTreeNode[] children = new ChessTreeNode[childrenStrings.length];
        for (int i = 0; i < childrenStrings.length; i++) {
            children[i] = new ChessTreeNode(ChessFaker.getNextBoard(node.getState(), childrenStrings[i]));
        }
        node.setChildren(children);
        String[] moves = ChessFaker.getNextMoves(node.getState());

        for (int index = 0; index < moves.length; index++) {

            int newFitnessCary = fitnessCary + ChessFaker.getFitnessChange(node.getState(), moves[index]);
            System.out.print(prefix + "+ " + moves[index] + " = " + children[index].getState() + " ");
            System.out.println("fitness: " + newFitnessCary);
            String newPrefix = prefix + "+ " + moves[index] + " ";
            printTreeHelper(children[index], depth - 1, newPrefix, newFitnessCary);
        }

    }

    /**
     * Finds the state with over 200 fitness in the fewest moves
     */
    private static void bfsToWin() {
        ArrayQueue<String> brd = new ArrayQueue<String>();
        ArrayQueue<Integer> fit = new ArrayQueue<Integer>();
        brd.enqueue(root.getState());
        fit.enqueue(0);
        
        System.out.println("Playing to win from: " + root.getState());
        long initialTime = System.currentTimeMillis();
        
        int fitness;
        String board;
        do {
            fitness = fit.dequeue();
            board = brd.dequeue();

            String[] moves = ChessFaker.getNextMoves(board);
            for(int i = 0; i < moves.length; i++) {
                brd.enqueue(ChessFaker.getNextBoard(board, moves[i]));
                fit.enqueue(fitness + ChessFaker.getFitnessChange(board, moves[i]));
            }

            nodesVisited++;
        } while(fitness < 200);
                
        long finalTime = System.currentTimeMillis();
        duration = finalTime - initialTime;
        System.out.println("Win state: " + board);
        System.out.println("Moves to target: " + movesToTarget);
        System.out.println("Target Fitness: " + fitness);
        System.out.println("Nodes Visited: " + nodesVisited);
        System.out.println("Duration: " + duration);
             
        
    }

}
