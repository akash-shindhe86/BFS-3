// Time Complexity : O(v+e) 
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package BFS-3;

public class Problem2 {
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        HashMap<Node,Node> map = new HashMap<>(); // O(v) 
        Queue<Node> q = new LinkedList<>();
        //create deep copy
        Node copy = new Node(node.val);
        q.add(node); //O(v)
        map.put(node,copy);

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node n: cur.neighbors){ //O(v+e)
                if(!map.containsKey(n)){
                    Node copyChild = new Node(n.val);
                    map.put(n, copyChild);
                    q.add(n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}