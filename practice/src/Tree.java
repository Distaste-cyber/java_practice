import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Tree {
    TreeNode1 head;

    public Tree(TreeNode1 head) {
        this.head = head;
    }

    public TreeNode BFS(int val) {
        if (head == null) {
            return null;
        }

        Queue<TreeNode> queue = new Queue<>(30);
        queue.enqueue(head);

        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();

            if (node.data == val) {
                return node;
            }

            for (TreeNode child : node.children) {
                if (child != null) {
                    queue.enqueue(child);
                }
            }
        }

        return null; // not found
    }

    public void preorder(TreeNode1 node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.leftChild);
        preorder(node.rightChild);
    }

    public void inorder(TreeNode1 node) {
        if (node == null)
            return;

        inorder(node.leftChild);
        System.out.print(node.data + " ");
        inorder(node.rightChild);
    }

    public void postorder(TreeNode1 node) {
        if (node == null)
            return;

        postorder(node.leftChild);
        psotorder(node.rightChild);
        System.out.print(node.data + " ");
    }

    public

    public void searchInBST(TreeNode1 node, int val) {
        if (node == null)
            return;

        if (node.data == val)
            return node;

        if (node.data > val) {
            searchInBST(node.leftChild, val);
        } else {
            searchInBST(node.rightChild, val);
        }

    }

    public void insertInBST(TreeNode1 head, int val) {
        if (head == null) {
            head = TreeNode1(val);
            return head;
        }

        if (head.data > val) {
            head.leftChild = insertInBST(head.leftChild, val);
        } else {
            head.rightChild = insertInBST(head.rightChild, val);
        }
    }
}
