import java.lang.reflect.Array;

public class TreeNode {
    int data;

    TreeNode[] children;

    public TreeNode(int data) {
        this.data = data;
        this.children = new TreeNode[5];
    }

    public void addChild(int index, TreeNode child) {
        if (index >= 0 && index < children.length) {
            children[index] = child;
        } else {
            System.out.println("Index out of range!");
        }
    }
}
