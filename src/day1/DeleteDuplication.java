package day1;
public class DeleteDuplication {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null){
            return null;
        }
        ListNode cur = pHead;
        ListNode pre = null;

        while (cur != null){
            //设置一个标志位来判断重复
            ListNode next = cur.next;
            boolean flag = false;
            if (next != null && cur.val == next.val){
                flag = true;
            }

            //标志位为假的就继续遍历 否则存值删除
            if (!flag){
                pre = cur;
                cur = cur.next;
            }else {
                int value = cur.val;
                ListNode del = cur;
                while (del != null && del.val == value){
                    next = del.next;
                    del = next;
                }
                //重复值已删除
                pre.next = next;
                cur = next;
            }
        }
        return cur.next;
    }
}
