/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode y = res;
        while(!pq.isEmpty()){
            ListNode temp = new ListNode(pq.poll());
            y.next = temp;
            y = y.next;
        }
        return res.next;
    }
}