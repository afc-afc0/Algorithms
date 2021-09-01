package GraphAlgos;

public class Successor {

    /*
    Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
    binary search tree. You may assume that each node has a link to its parent.
    */

    BinaryNode root;

    public Successor()
    {
        initTree();
    }

    private BinaryNode findInOrderSuccessor(BinaryNode node) {

        BinaryNode rightNode = node.right;
        if(rightNode != null)
            return getLeftMost(node.right);

        BinaryNode current = node;
        BinaryNode parent = node.parent;

        while(parent != null && current != parent.left)
        {
            current = parent;
            parent = parent.parent;
        }

        return parent;
    }

    private BinaryNode getLeftMost(BinaryNode node)
    {
        if(node == null)
            return null;

        while (node.left != null)
            node = node.left;

        return node;
    }

    public void initTree()
    {
        root = new BinaryNode(20);

        BinaryNode node8 = new BinaryNode(8);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node12 = new BinaryNode(12);
        BinaryNode node10 = new BinaryNode(10);
        BinaryNode node14 = new BinaryNode(14);
        BinaryNode node22 = new BinaryNode(22);

        root.right = node22;
        root.left = node8;

        node8.left = node4;
        node8.right = node12;

        node12.left = node10;
        node12.right = node14;

        root.parent = null;
        node4.parent = node8;
        node10.parent  = node12;
        node12.parent = node8;
        node14.parent = node12;
        node22.parent = root;
        node8.parent = root;

        BinaryNode node = findInOrderSuccessor(node14);
        System.out.println(node.val);
    }


}
