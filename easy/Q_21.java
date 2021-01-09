/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Q_21 {
    public static void main(String[] args) {

        ListNode l1 = ListNode.buildNode(new int[]{1,2,4});
        ListNode l2 = ListNode.buildNode(new int[]{1,3,4});

        Q_21 q = new Q_21();
        ListNode listNode = q.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode t1 = l1.val > l2.val ? l1 : l1.next;
        ListNode t2 = l2.val >= l1.val ? l2 : l2.next;
        ListNode result = new ListNode(Math.min(l1.val,l2.val));
        ListNode temp = result;
        while (t1 != null || t2 != null){
            ListNode child = new ListNode();
            if(t1 == null){
                child.val = t2.val;
                t2 = t2.next;
                temp.next = child;
                temp = child;
                continue;
            }
            if(t2 == null){
                child.val = t1.val;
                t1 = t1.next;
                temp.next = child;
                temp = child;
                continue;
            }
            if(t1.val > t2.val){
                child.val = t2.val;
                t2 = t2.next;
            }else{
                child.val = t1.val;
                t1 = t1.next;
            }
            temp.next = child;
            temp = child;
        }
        return result;
    }
}

