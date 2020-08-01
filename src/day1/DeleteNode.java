package day1;

public class DeleteNode {
    public class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value = value;
        }
    }
    public ListNode deleteNode(ListNode head, ListNode node){
        if (head == null || node == null){
            return null;
        }
        //要删除的节点不是尾节点
        if (node.next != null) {
            ListNode next = node.next;
            node.value = next.value;
            node.next = next.next;
        }else if (head == node){
            return null;
        }else {
            ListNode cur = head;
            while (cur.next != node){
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }
}
