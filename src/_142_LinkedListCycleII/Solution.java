package _142_LinkedListCycleII;


class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class Solution {
    public ListNode findCycleStart(ListNode head) {
        int cycleLength = 0;
        // find the circle length;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                cycleLength = findLength(slow); // get the length of cycle
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null; // return null if the linklist doesn't have a inner cycle
        }
        return findStart(head, cycleLength);
    }

    private ListNode findStart(ListNode head, int cycleLength) {

        ListNode pointer_1 = head;
        ListNode pointer_2 = head;

        // place the pointer_2 to the position that ahead of K node
        while (cycleLength > 0) {
            pointer_2 = pointer_2.next;
            cycleLength--;
        }
        // moving two pointer forward until they meet
        while (pointer_1 != pointer_2) {
            pointer_1 = pointer_1.next;
            pointer_2 = pointer_2.next;
        }

        return pointer_1;
    }

    private int findLength(ListNode slow) {
        int length = 1;
        ListNode run = slow.next;
        while (run != slow) {
            run = run.next;
            length++;
        }
        return length;
    }
}
