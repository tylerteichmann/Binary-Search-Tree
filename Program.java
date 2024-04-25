public class Program {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.Insert(8);
        bst.Insert(22);
        bst.Insert(35);
        bst.Insert(5);
        bst.Insert(9);
        bst.Insert(20);
        bst.Insert(4);
        bst.Insert(100);
        bst.Insert(6);
        bst.Insert(45);
        bst.Insert(28);
        bst.Insert(1);
        bst.Insert(7);
        bst.Insert(15);
        bst.Display();
        System.out.println(bst.Search(35));
        bst.Delete(22);
        bst.Display();
        System.out.println(bst.CountNodes());
    }
}
