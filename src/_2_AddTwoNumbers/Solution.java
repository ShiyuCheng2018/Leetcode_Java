package _2_AddTwoNumbers;


class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
        next = null;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}



public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(); // 初始化一个dummyHead
        ListNode curr = dummyHead; // 将curr指向dummyHead

        int carry = 0; // 初始化一个为0的进位
        ListNode p = l1; // 拿到l1的个位
        ListNode q = l2; // 拿到l2的个位

        while (p != null || q != null){

            int x = 0; // 默认为0， 因为当链表遍历完毕时需要取0
            int y = 0;

            if(p != null){
                x = p.val; // 拿到第一个链表当前值
                p = p.next; // 当next不为空，获取下一位数
            }
            if (q != null){
                y = q.val; // 拿到第二个链表当前值
                q = q.next; // 当next不为空，获取下一位数
            }

            int sum = x + y + carry; // 得到俩数相加结果
            carry = sum / 10; // 取整， 拿到进位

            curr.next = new ListNode(sum % 10); // 添加以sum结果当个位数为新节点，并挂载到curr的next
            curr = curr.next; // 后移curr

        }

        if(carry == 1){ // 判断是否需要进行最后一次carry
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}
