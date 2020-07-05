public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node1 = new Node(8);
        Node node2 = new Node(3);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        Node node5 = new Node(6);
        Node node6 = new Node(14);
        Node node7 = new Node(4);
        Node node8 = new Node(7);
        Node node9 = new Node(13);


        tree.initTree(node1, 0);
        tree.add(node2, tree.getRoot(), true);
        tree.add(node3, tree.getRoot(), false);
        tree.add(node4, node2, true);
        tree.add(node5, node2, false);
        tree.add(node6, node3, false);
        tree.add(node7, node5, true);
        tree.add(node8, node5, false);
        tree.add(node9, node6, true);
        tree.print(tree.getRoot());

        System.out.println(tree.findLevelWithBiggestSum());
    }

}
