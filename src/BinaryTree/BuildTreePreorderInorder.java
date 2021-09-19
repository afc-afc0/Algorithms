package BinaryTree;

import GraphAlgos.BinaryNode;

import java.util.HashMap;
import java.util.Map;

import static BinaryTree.SumTree.levelOrderPrint;

public class BuildTreePreorderInorder {

    int[] inorder;
    int[] preorder;

    public BuildTreePreorderInorder(){
        initInputs();
    }

    private void initInputs() {
        inorder = new int[]{4,2,1,7,5,8,3,6};
        preorder = new int[]{1,2,4,3,5,7,8,6};

        BinaryNode root = createTree(inorder, preorder);
        levelOrderPrint(root);
    }

    private BinaryNode createTree(int[] inorder, int[] preorder)
    {
        Map<Integer,Integer> numberIndexMap = new HashMap<>();
        for(int i = 0;i < inorder.length;i++)
            numberIndexMap.put(inorder[i], i);

        return createTreeUtil(0, inorder.length - 1, preorder, numberIndexMap);
    }

    private int preOrderIndex = 0;
    private BinaryNode createTreeUtil(int left, int right, int[] preorder, Map<Integer,Integer> numberIndexMap)
    {
        if(left > right)
            return null;

        BinaryNode root = new BinaryNode(preorder[preOrderIndex]);
        preOrderIndex++;
        int mid = numberIndexMap.get(root.val);

        root.left = createTreeUtil(left, mid - 1, preorder, numberIndexMap);
        root.right = createTreeUtil(mid + 1, right, preorder, numberIndexMap);

        return root;
    }

}
