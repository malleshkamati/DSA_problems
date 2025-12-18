package DSA_problems.Graphs;

import java.util.*;

// Given a reference of a node in a connected undirected graph.

// Return a deep copy (clone) of the graph.

// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

// class Node {
//     public int val;
//     public List<Node> neighbors;
// }

public class CloneGraph {
    
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map=new HashMap<>();
        if(node==null) return node;
        Node root=new Node(node.val);
        HashSet<Node> visited=new HashSet<>();

        Queue<Node> q=new LinkedList<>();

        q.offer(node);
        map.put(node,root);
        

        while(!q.isEmpty()){
            Node temp=q.poll();
           
            for(Node t:temp.neighbors){

                if(!map.containsKey(t)){
                    Node t1=new Node(t.val);
                    t1.neighbors=new ArrayList<>();
                    map.put(t,t1);
                    q.offer(t);
                }
                map.get(temp).neighbors.add(map.get(t));
               
                

            }
        }

        return root;

    

        

    }


    public static void main(String[] args) {


    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    n1.neighbors.add(n2);
    n1.neighbors.add(n4);

    n2.neighbors.add(n1);
    n2.neighbors.add(n3);

    n3.neighbors.add(n2);
    n3.neighbors.add(n4);

    n4.neighbors.add(n1);
    n4.neighbors.add(n3);

    CloneGraph obj = new CloneGraph();
    Node cloned = obj.cloneGraph(n1);
    System.out.println(cloned.val);                         
    System.out.println(cloned.neighbors.get(0).val);        
    System.out.println(cloned.neighbors.get(1).val);        
    System.out.println(cloned != n1);                        
    System.out.println(cloned.neighbors.get(0) != n2);       
}

}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}