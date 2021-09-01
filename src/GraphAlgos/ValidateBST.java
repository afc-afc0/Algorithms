package GraphAlgos;

public class ValidateBST {

    BinaryNode root;

    public ValidateBST(){
        initTree();
    }

    private void initTree()
    {
        root = new BinaryNode(10);

        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node11 = new BinaryNode(11);

        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node1 = new BinaryNode(1);

        BinaryNode node3 = new BinaryNode(3);

        BinaryNode node7 = new BinaryNode(7);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node8 = new BinaryNode(8);

        root.right = node11;
        root.left = node5;

        node5.left = node2;
        node5.right = node7;

        node2.left = node1;
        node2.right = node3;

        node7.left = node6;
        node7.right = node8;


        System.out.println(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private boolean isValidBST(BinaryNode node, int min, int max) {

        if(node == null)
            return true;

        if(node.val > max || node.val < min) {
            return false;
        }
        //When we go left we need to set the max value
        boolean left = isValidBST(node.left, min, node.val);
        if(!left)
            return false;
        //When we go right we need to set the min value;
        boolean right = isValidBST(node.right, node.val, max);
        if(!right)
            return false;

        return true;
    }


}
