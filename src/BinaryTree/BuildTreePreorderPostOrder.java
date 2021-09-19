package BinaryTree;

import GraphAlgos.BinaryNode;

import java.util.HashMap;
import java.util.Map;

import static BinaryTree.SumTree.levelOrderPrint;

public class BuildTreePreorderPostOrder {

    int[] inorder;
    int[] postorder;

    public BuildTreePreorderPostOrder(){
        initInputs();;
    }

    private void initInputs() {
        inorder = new int[]{4,2,1,7,5,8,3,6};
        postorder = new int[]{4,2,7,8,5,6,3,1};

        postOrderIndex = postorder.length - 1;

        BinaryNode root = createTree(inorder, postorder);
        levelOrderPrint(root);
    }

    private int postOrderIndex;
    private BinaryNode createTree(int[] inorder, int[] postorder) {

        Map<Integer,Integer> numIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length;i++)
            numIndexMap.put(inorder[i],i);

        return  createTreeUtil(0, postorder.length -1, postorder, numIndexMap);
    }

    private BinaryNode createTreeUtil(int left, int right, int[] postorder, Map<Integer,Integer> numIndexMap){
        if(left > right)
            return null;

        BinaryNode root = new BinaryNode(postorder[postOrderIndex]);
        int mid = numIndexMap.get(root.val);
        postOrderIndex--;

        //In here if we go the left first. It will be the wrong result
        root.right = createTreeUtil(mid + 1, right, postorder, numIndexMap);
        root.left = createTreeUtil(left, mid - 1, postorder, numIndexMap);

        return root;
    }
}
