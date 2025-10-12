import java.util.ArrayList;

class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        display(root.left);
        display(root.right);
    }

    public static void preorder(TreeNode root, ArrayList<Integer> pre) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        preorder(root.left, pre);
        preorder(root.right, pre);
    }

    public static void inorder(TreeNode root, ArrayList<Integer> ino) {
        if (root == null) {
            return;
        }
        inorder(root.left, ino);
        ino.add(root.val);
        inorder(root.right, ino);
    }
    public static TreeNode buildBinaryTree( ArrayList<Integer> pre,int preLow,int preHigh,ArrayList<Integer> ino ,int inLow,int inHigh){
          if (preLow > preHigh || inLow > inHigh) {
        return null;
    }

    TreeNode root = new TreeNode(pre.get(preLow));  

        int i=inLow;
        while(pre.get(preLow)!=ino.get(i))i++;
        root.left=buildBinaryTree(pre,preLow+1,preLow+i-inLow,ino,inLow,i-1);
        root.right=buildBinaryTree(pre,preLow + i - inLow + 1,preHigh,ino,i+1,inHigh);
        return root;
    }
    
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        display(root);

        ArrayList<Integer> pre = new ArrayList<>();
        preorder(root, pre);
        System.out.println("Preorder: " + pre);

        ArrayList<Integer> ino = new ArrayList<>();
        inorder(root, ino);
        System.out.println("Inorder: " + ino);
        int size=pre.size();
     
       TreeNode tree= buildBinaryTree(pre,0,size-1,ino,0,size-1);
        display(tree);
        
    }
}
