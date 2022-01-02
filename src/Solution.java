import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        Node next ;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            next = map.get(cur);
            next.next = map.get(cur.next);
            next.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        Solution s = new Solution();
        Node node = s.copyRandomList(head);

    }
}