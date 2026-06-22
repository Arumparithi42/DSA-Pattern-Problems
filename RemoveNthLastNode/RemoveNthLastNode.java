public class RemoveNthLastNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        ListNode del = head;
        for(int i = 0; i < n; i++){
            tail = tail.next;
        }
        if (tail == null)
            return head.next;
        while(tail.next != null){
            tail = tail.next;
            del = del.next;
        }
        del.next = del.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));


        RemoveNthLastNode solution = new RemoveNthLastNode();
        ListNode result = solution.removeNthFromEnd(head, 5);
        if (result != null){
            System.out.println(result.val);
        }

        
    }

    
}
