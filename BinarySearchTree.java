public class BinarySearchTree {

    private Node root;

    public void Insert(int data) {
        Node newNode = new Node(data);
        root = RecursiveInsert(root, newNode);
    }

    private Node RecursiveInsert(Node root, Node newNode) {
        if (root == null) {
            root = newNode;
        } else if (newNode.data >= root.data) {
            root.right = RecursiveInsert(root.right, newNode);
        } else {
            root.left = RecursiveInsert(root.left, newNode);
        }

        return root;
    }

    public void Display() {
        RecursiveDisplay(root);
        System.out.println();
    }

    private void RecursiveDisplay(Node root) {
        if (root != null) {
            RecursiveDisplay(root.left);
            System.out.print(root.data + " ");
            RecursiveDisplay(root.right);
        }
    }

    public boolean Search(int data) {
        boolean exists = false;

        Node currentNode = root;

        while (currentNode != null) {
            if (currentNode.data == data) {
                exists = true;
                break;
            } else if (currentNode.data > data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return exists;
    }

    public void Delete(int data) {
        RecursiveDelete(root, data);
    }

    public Node RecursiveDelete(Node root, int data) {
        if (root == null) {
            return root;
        } else if (root.data == data) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.data = FindSuccessor(root.right).data;
                root.right = RecursiveDelete(root.right, root.data);
            } else {
                root.data = FindPredecessor(root.left).data;
                root.left = RecursiveDelete(root.left, root.data);
            }
        } else if (root.data > data) {
            root.left = RecursiveDelete(root.left, data);
        } else {
            root.right = RecursiveDelete(root.right, data);
        }

        return root;
    }

    public Node FindSuccessor(Node root) {
        Node currentNode = root;
        
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        
        return currentNode;
    }

    public Node FindPredecessor(Node root) {
        Node currentNode = root;
        
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        
        return currentNode;
    }

    // public void Delete(int data) {
    //     if (!Search(data)) {
    //         System.out.println("Unable to delete node that doesn't exist");
    //         return;
    //     }

    //     Node parentNode = root;
    //     Node currentNode = root;

    //     while (currentNode != null) {
    //         if (currentNode.data == data) {
    //             if (currentNode.left == null && currentNode.right == null) {
    //                 if (parentNode.left == currentNode) {
    //                     parentNode.left = null;
    //                 } else {
    //                     parentNode.right = null;
    //                 }
    //             }

    //             if (currentNode.right != null) {
    //                 Node node = FindSuccessor(currentNode.right);
    //             } else {
    //                 Node node = FindPredecessor(currentNode.left);
    //             }

    //         } else if (currentNode.data > data) {
    //             parentNode = currentNode;
    //             currentNode = currentNode.left;
    //         } else {
    //             parentNode = currentNode;
    //             currentNode = currentNode.right;
    //         }
    //     }
    // }

    public int CountNodes() {
        return RecursiveCountNodes(root);
    }

    public int RecursiveCountNodes(Node root) {
        int count;
        if (root == null) {
            count = 0;
        } else {
            count = 1;
            count += RecursiveCountNodes(root.left);
            count += RecursiveCountNodes(root.right);
        }
        return count;
    }

    public int CountLeaves() {
        return RecursiveCountLeaves(root);
    }

    public int RecursiveCountLeaves(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return RecursiveCountLeaves(root.left) + RecursiveCountLeaves(root.right);
    }

}
