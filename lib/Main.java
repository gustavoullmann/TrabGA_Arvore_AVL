
public class Main {

    static Tree AVL_TREE = new Tree();
    public static void main(String[] args) {

        AVL_TREE.insertNode(12);
        AVL_TREE.insertNode(6);
        AVL_TREE.insertNode(18);
        AVL_TREE.insertNode(2);
        AVL_TREE.insertNode(9);
        AVL_TREE.insertNode(15);
        AVL_TREE.insertNode(20);

        Menu.menu();
    }
}
