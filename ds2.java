import java.util.*;
 

class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class downapproach
{
 
    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                        Integer key, Integer value) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }
 
  
    public static void printNodes(Node root)
    {
        
        if (root == null) {
            return;
        }
 
        
        int level = 1;
 
        
        Map<Integer, List<Integer>> map = new HashMap<>();
 
   
        insertIntoMultiMap(map, level, root.key);
 
       
        Queue<Node> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
 
        if (root.left != null && root.right != null)
        {
            q1.add(root.left);
            q2.add(root.right);
        }
 

        while (!q1.isEmpty())
        {
            level++;
 
            int n = q1.size();
 
      
            while (n-- > 0)
            {
               
                Node x = q1.poll();
                insertIntoMultiMap(map, level, x.key);
 
                
                if (x.left != null) {
                    q1.add(x.left);
                }
 
                if (x.right != null) {
                    q1.add(x.right);
                }
 
               
                Node y = q2.poll();
 
                map.get(level).add(y.key);
 
               
                if (y.right != null) {
                    q2.add(y.right);
                }
 
                if (y.left != null) {
                    q2.add(y.left);
                }
            }
        }
 
       
        for (int i = map.size(); i > 0; i--) {
            System.out.print(map.get(i));
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
 
        printNodes(root);
    }
}