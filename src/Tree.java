import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Tree {
    Node head;
    int visited = 0;

    public Tree(int data){
        head = new Node(data);
    }

    public void add(int data){
        if(Objects.isNull(head)){
            head = new Node(data);
        }
        add(data, head);
    }

    /*public void leftView(Node node){
       if(Objects.isNull(node)){
           return;
       }
        Queue<Node> queue = new LinkedList<>();
       queue.add(node);
       while(!queue.isEmpty()){
           Node currentNode = queue.peek();
           System.out.print(currentNode.data + " ");
           Queue<Node> secondaryQueue = new LinkedList<>(queue);
           queue.clear();
           while(!secondaryQueue.isEmpty()){
               Node secNode = secondaryQueue.poll();
               if(Objects.nonNull(secNode.left)){
                   queue.add(secNode.left);
               }
               if(Objects.nonNull(secNode.right)){
                   queue.add(secNode.right);
               }
           }
       }
    }*/

    public void leftView(Node node, int level){
        if(Objects.isNull(node)){
            return;
        }

        if(visited < level){
            System.out.println(node.data);
            visited++;
        }
        leftView(node.left, level+1);
        leftView(node.right,level+1);
    }



    /*Diameter of a tree the longest path between any two nodes, with or without through the root/head node.*/
    public int diameter(Node node){
        if(node == null) return 0;
        int[] diameter = {1};
        getDiameter(node, diameter);
        return diameter[0];
    }

    /*find max of left height + right height for each node*/
    private int getDiameter(Node node, int[] diameter) {
        if(Objects.isNull(node)){
            return 0;
        }
        int leftHeight = getDiameter(node.left, diameter);
        int rightHeight = getDiameter(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBST(Node node){
        if(Objects.isNull(node)){
            return false;
        }
        boolean isBST = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty() && isBST){
            Node currentNode = queue.poll();
            if(Objects.nonNull(currentNode.left)){
                isBST = currentNode.data > currentNode.left.data;
                queue.add(currentNode.left);
            }
            if(isBST && Objects.nonNull(currentNode.right)){
                isBST = currentNode.data < currentNode.right.data;
                queue.add(currentNode.right);
            }
        }
        return isBST;
    }

    private void add(int data, Node node){
        if(data > node.data){
            addToRight(data, node);
        }else if(data  < node.data){
            addToLeft(data, node);
        }else{
            return;
        }
    }

    private void addToRight(int data, Node node) {
        if(Objects.isNull(node.right)){
            node.right = new Node(data);
            return;
        }
        add(data, node.right);
    }

    private void addToLeft(int data, Node node) {
        if(Objects.isNull(node.left)){
            node.left = new Node(data);
            return;
        }
        add(data, node.left);
    }

    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }
}
