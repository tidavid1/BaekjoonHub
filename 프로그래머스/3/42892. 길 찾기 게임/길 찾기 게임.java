import java.util.*;
class Solution {
    
    private int idx = 0;
    private int[][] answer;
    public int[][] solution(int[][] nodeInfo) {
        answer = new int[2][nodeInfo.length];
        Queue<Node> queue = new PriorityQueue<>();
        for(int i=0;i<nodeInfo.length;i++){
            queue.add(new Node(i+1, nodeInfo[i][0], nodeInfo[i][1]));
        }
        Node head = queue.poll();
        while(!queue.isEmpty()){
            insertNode(head, queue.poll());
        }
        preOrder(head);
        idx = 0;
        postOrder(head);
        return answer;
    }
    
    private void insertNode(Node head, Node node){
        if(node.x < head.x){
            if(head.isLeftAvaliable()){
               insertNode(head.left, node); 
            } else {
                head.left = node;
            }
        } else {
            if(head.isRightAvaliable()){
                insertNode(head.right, node);
            } else{
                head.right = node;
            }
        }
    }
    
    private void preOrder(Node head){
        answer[0][idx++] = head.name;
        if(head.isLeftAvaliable()){
            preOrder(head.left);
        }
        if(head.isRightAvaliable()){
            preOrder(head.right);
        }
    }
    
    private void postOrder(Node head){
        if(head.isLeftAvaliable()) {
            postOrder(head.left);
        }
        if(head.isRightAvaliable()){
            postOrder(head.right);
        }
        answer[1][idx++] = head.name;
    }
    
    private static class Node implements Comparable<Node>{
        int name;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
        
        public Node setLeft(Node node){
            this.left = node;
            return node;
        }
        
        public Node setRight(Node node){
            this.right = right;
            return node;
        }
        
        public boolean isLeftAvaliable(){
            return left != null;
        }
        
        public boolean isRightAvaliable() {
            return right != null;
        }
        
        

        @Override
        public int compareTo(Node node) {
            if(this.y == node.y){
                return Integer.compare(this.x, node.x);
            }
            return -Integer.compare(this.y, node.y);
        }
        
        @Override
        public String toString(){
            return "name: "+ this.name+ ", x: "+ this.x+ ", y: "+this.y;
        }
    }
}