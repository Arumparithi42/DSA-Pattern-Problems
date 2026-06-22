

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def removeNthFromEnd(head, n):
    if head is None:
        return None

    tail = head
    delete = head
    for _ in range(n):
        tail = tail.next
    if (tail == None):
        return head.next
    while(tail.next):
        tail = tail.next
        delete = delete.next
    delete.next = delete.next.next
    return head

h1 = ListNode(1)
h2 = ListNode(2)
h3 = ListNode(3)
h4 = ListNode(4)
h1.next = h2
h2.next = h3
h3.next = h4
res = removeNthFromEnd(h1,4)
print(res.val if res else None)