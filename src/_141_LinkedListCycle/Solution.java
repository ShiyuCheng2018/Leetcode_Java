package _141_LinkedListCycle;


class ListNode{
    int value = 0;
    ListNode next;

    ListNode(int value){
        this.value = value;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return  true;
            }

        }
        return false;
    }
}

