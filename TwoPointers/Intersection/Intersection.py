from typing import Optional

class ListNode:
    def __init__(self, x: int):
        self.val = x
        self.next: Optional["ListNode"] = None

def getIntersectionNode(headA: ListNode, headB: ListNode):
    tailA = headA
    tailB = headB
    while(tailA != tailB):
        if (tailA == None):
            tailA = headB
        else:
            tailA = tailA.next
        if (tailB == None):
            tailB = headA
        else:
            tailB = tailB.next
            
    return tailA

a1 = ListNode(1)
a2 = ListNode(2)
a3 = ListNode(3)
a1.next = a2
a2.next = a3

b1 = ListNode(4)
b2 = ListNode(5)
b1.next = b2
b2.next = a2
result = getIntersectionNode(a1, b1)
if result is not None:
    print(result.val)
else:
    print("No intersection")
