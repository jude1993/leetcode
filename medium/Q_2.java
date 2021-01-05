import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q_2 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.buildNode(new int[]{9, 9, 9, 9});
        Q_2 q = new Q_2();
        ListNode listNode = q.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(getR(l1.val, l2.val));
        int l = getZ(l1.val, l2.val);
        ListNode c1 = l1, c2 = l2;
        ListNode currentNode = result;
        while (c1.next != null || c2.next != null) {
            int nextVal = 0;
            int v1 = 0, v2 = 0;
            if (c1.next != null) {
                v1 = c1.next.val;
                c1 = c1.next;
            }
            if (c2.next != null) {
                v2 = c2.next.val;
                c2 = c2.next;
            }
            nextVal = getR(v1 + v2, l);
            l = getZ(v1 + v2, l);
            ListNode next = new ListNode(nextVal);
            currentNode.next = next;
            currentNode = next;
        }
        if(l != 0){
            currentNode.next = new ListNode(l);
        }
        return result;
    }

    private int getR(int i, int j) {
        return (i + j) % 10;
    }

    private int getZ(int i, int j) {
        return (i + j) / 10;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildNode(int[] arr) {
        ListNode result = new ListNode(arr[0]);
        ListNode current = result;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            current.next = node;
            current = node;
        }
        return result;
    }
}
