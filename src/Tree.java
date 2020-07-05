import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tree {

    private Node root = null;
    private int size = 0;

    public void initTree(Node node, int level) {
        node.setLevel(level);
        root = node;
    }

    public void add(Node node, Node parent, boolean isLeftChild) {
        if (isLeftChild) {
            if ((node.getValue() >= parent.getValue())) {
                System.out.println("Value >= parent value. Search tree error!");
                return;
            }

            if (parent.getLeftChild() != null) {
                System.out.println("Left child already exists!");
                return;
            }
            node.setLevel(parent.getLevel() + 1);
            parent.setLeftChild(node);
            size++;
        } else {
            if ((node.getValue() < parent.getValue())) {
                System.out.println("Value < parent value. Search tree error!");
                return;
            }

            if (parent.getRightChild() != null) {
                System.out.println("Right child already exists!");
                return;
            }
            node.setLevel(parent.getLevel() + 1);
            parent.setRightChild(node);
            size++;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        print(node.getLeftChild());
        print(node.getRightChild());
    }

    public List<Node> getAll() {
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            nodes.add(node);
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
        return nodes;
    }

    public int findLevelWithBiggestSum(){
        List<Node> nodes = getAll();
        int levelCount = nodes.get(nodes.size() - 1).getLevel();

        int biggestSum = root.getValue();
        int levelResult = 0;
        for (int level = 1; level <= levelCount; level++){
            int currentLevelSum = countLevelSum(nodes, level);
            if (currentLevelSum > biggestSum){
                biggestSum = currentLevelSum;
                levelResult = level;
            }
        }

        return levelResult;
    }

    public int countLevelSum(List<Node> nodes, int level){
        int result = 0;
        for (Node n:
             nodes) {
            if (n.getLevel() == level){
                result += n.getValue();
            }
        }

        return result;
    }
}
