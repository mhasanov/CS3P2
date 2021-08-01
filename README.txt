Recursive functions are listed here.
author Syed Arib Ali
author Mehdi Hasanov
---------------------------------------------------------------------------------------------------------------------------
PRINT TREE
---------------------------------------------------------------------------------------------------------------------------
/**
     * Helper method for the printTree with recursive implementation.
     *
     * @param node
     *            The node of the ChessTreeNode.
     * @param depth
     *            How far the function goes in depth.
     * @param prefix
     *            The space that needs to be added before the move.
     * @param fitnessCary
     *            The fitness of the board.
     */
    public static void printTreeHelper(
        ChessTreeNode node,
        int depth,
        String prefix,
        int fitnessCary)
    {

        if (depth <= 0)
        {
            return;
        }

        String[] childrenStrings = ChessFaker.getNextMoves(node.getState());
        ChessTreeNode[] children = new ChessTreeNode[childrenStrings.length];
        for (int i = 0; i < childrenStrings.length; i++)
        {
            children[i] = new ChessTreeNode(
                ChessFaker.getNextBoard(node.getState(), childrenStrings[i]));
        }
        node.setChildren(children);
        String[] moves = ChessFaker.getNextMoves(node.getState());

        for (int index = 0; index < moves.length; index++)
        {

            int newFitnessCary = fitnessCary
                + ChessFaker.getFitnessChange(node.getState(), moves[index]);
            System.out.print(
                prefix + "+ " + moves[index] + " = "
                    + children[index].getState() + " ");
            System.out.println("fitness: " + newFitnessCary);
            String newPrefix = prefix + "+ " + moves[index] + " ";
            printTreeHelper(
                children[index],
                depth - 1,
                newPrefix,
                newFitnessCary);
        }

    }

---------------------------------------------------------------------------------------------------------------------------
Depth First Search
---------------------------------------------------------------------------------------------------------------------------

/**
     * Helper method for the dfsTarget with the recursion implementation.
     *
     * @param node
     *            the root node.
     * @param depth
     *            the depth of the search.
     * @param fitness
     *            fitness of the board (initially 0).
     */
    public static
        void
        dfsToTargetHelper(ChessTreeNode node, int depth, int fitness)
    {
        // movesToTarget : String

        if (depth <= 0 || found)
        {

            return;
        }
        nodesVisited++;
        if (node.getState().equals(goalChessBoard))
        {
            found = true;
            targetFitness = fitness;
            return;
        }

        String[] moves = ChessFaker.getNextMoves(node.getState());

        ChessTreeNode[] children = new ChessTreeNode[moves.length];

        for (int i = 0; i < moves.length; i++)
        {
            children[i] = new ChessTreeNode(
                ChessFaker.getNextBoard(node.getState(), moves[i]));

            dfsToTargetHelper(
                children[i],
                depth - 1,
                fitness
                    + ChessFaker.getFitnessChange(node.getState(), moves[i]));
            if (found)
            {
                movesToTarget = "+ " + moves[i] + " " + movesToTarget;
                break;
            }
        }
    }
