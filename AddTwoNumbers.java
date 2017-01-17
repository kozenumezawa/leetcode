// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode n1 = l1;
       ListNode n2 = l2;

       int[] a = new int[100];
       int[] b = new int[100];
       int aLength = -1, bLength = -1;

       for(int i = 0; i < 100; i++) {
           a[i] = n1.val;
           if(n1.next == null) {
               aLength = i;
               break;
           }
           n1 = n1.next;
       }

       for(int i = 0; i < 100; i++) {
           b[i] = n2.val;
           if(n2.next == null) {
               bLength = i;
               break;
           }
           n2 = n2.next;
       }

       n1 = l1;
       n2 = l2;
       int test = a[0] + b[0];
       ListNode answer = new ListNode(test % 10);

       int carry = 0;
       if(test >= 10) {
           carry = 1;
       }

       ListNode indicator = answer;
       for(int i = 1; i <= aLength || i <= bLength; i++) {
           int store = 0;
           if(i <= aLength && i <= bLength) {
               store = a[i] + b[i] + carry;
           } else if(i <= aLength) {
               store = a[i] + carry;
           } else if(i <= bLength) {
               store = b[i] + carry;
           }

           if(store >= 10) {
               indicator.next = new ListNode(store % 10);
               carry = 1;
           } else {
               indicator.next = new ListNode(store);
               carry = 0;
           }
           indicator = indicator.next;
       }

       if(carry == 1) {
           indicator.next = new ListNode(carry);
       }

       return answer;
   }
}
