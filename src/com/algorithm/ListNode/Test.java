package com.algorithm.ListNode;

import com.algorithm.Structure.ListNode;

public class Test {


    public ListNode deleteDuplicates(ListNode head) {
          if(head==null){
              return null;
          }
          ListNode cur=head;
          while(cur.next!=null){
              if (cur.next.val==cur.val){
                cur.next=cur.next.next;
              }else{
                  cur=cur.next;
              }
          }
          return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        ListNode pre=null;
        ListNode head2=null;

        if(cur.next==null){
            return cur;
        }

        while(cur!=null&&cur.next!=null){
            if (cur.next.val==cur.val){
                int temp=cur.val;
                ListNode n=cur.next;
                while (n!=null&&n.val==temp){
                    n=n.next;
                }
                if(pre!=null){
                    pre.next=n;
                }
                cur=n;
            }else{
                if(pre==null){
                    head2=cur;
                }
                pre=cur;
                cur=cur.next;
            }
        }

        if(head2==null){
            head2=cur;
        }

        return head2;
    }



    public static void main(String[] args) {

        ListNode head=new ListNode(4);

        ListNode n1=new ListNode(2);

        ListNode n2=new ListNode(1);

        ListNode n3=new ListNode(3);

        ListNode n4=new ListNode(5);
        head.next=null;

        printListNode(removeNthFromEnd(head,1));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int i=0;
        ListNode head=null;
        ListNode cur=null;

        for(;l1!=null&&l2!=null;l1=l1.next,l2=l2.next){
            int val=(l1.val+l2.val+i)%10;
            i=(l1.val+l2.val+i)/10;
            if(head==null){
                head=new ListNode(val);
                cur=head;
            }else {
                ListNode n = new ListNode(val);
                cur.next = n;
                cur = n;
            }
         }

         while(l1!=null){
             int val=(l1.val+i)%10;
             i=(l1.val+i)/10;
             if(head==null){
                 head=new ListNode(val);
                 cur=head;
             }else {
                 ListNode n = new ListNode(val);
                 cur.next = n;
                 cur = n;
             }
         }

        while(l2!=null){
            int val=(l2.val+i)%10;
            i=(l2.val+i)/10;
            if(head==null){
                head=new ListNode(val);
                cur=head;
            }else {
                ListNode n = new ListNode(val);
                cur.next = n;
                cur = n;
            }
        }

        return reverse(head);


    }

    private static ListNode reverse(ListNode head) {


        ListNode cur=head;
        ListNode reverseCur=null;

        while (cur!=null){
            ListNode temp=cur;
            cur=cur.next;
            if(reverseCur==null) {
                temp.next=null;
                reverseCur =temp;
            }else {
                temp.next=reverseCur;
                reverseCur=temp;
            }
        }

        return reverseCur;

    }

    private static void printListNode(ListNode head) {
        ListNode cur=head;

        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if(m==n||head==null||head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode h=null;
        ListNode reversePrev=null;
        ListNode reverseHead=null;
        ListNode reverseTail=null;
        ListNode reverseNext=null;

        int i=0;
        while(temp!=null){
            i++;
            if(i==1&&i!=m){
                h=temp;
            }

            if(i<m){
                reversePrev=temp;
            }
            ListNode node=temp;
            temp=temp.next;
            if(i>=m&&i<=n){
                if(reverseHead==null){
                    reverseHead=node;
                    reverseTail=node;
                    reverseTail.next=null;
                }else{
                    node.next=reverseHead;
                    reverseHead=node;
                }
            }
            if(i==n+1){
                reverseNext=node;
            }
        }
        if(reversePrev!=null){
            reversePrev.next=reverseHead;
        }
        if(reverseNext!=null){
            reverseTail.next=reverseNext;
        }
        return h==null?reverseHead:h;
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode n=new ListNode(Integer.MIN_VALUE);
        ListNode cur=head;
        while(cur!=null){
            ListNode node=cur;
            cur=cur.next;
            node.next=null;
            if(n.next==null){
                n.next=node;
            }else{
                ListNode temp=n.next;
                ListNode prev=n;
                while(temp!=null){
                    if(temp.val>node.val){
                        prev.next=node;
                        node.next=temp;
                        break;
                    }
                    prev=temp;
                    temp=temp.next;
                }
                if(temp==null){
                    prev.next=node;
                }

            }
        }
        return n.next;
    }

    public static boolean isPalindrome(String s) {
        StringBuffer sb=new StringBuffer();
        StringBuffer rb=new StringBuffer();

        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if((chars[i]>='a'&&chars[i]<='z')||(chars[i]>='A'&&chars[i]<='Z')||(chars[i]>='0'&&chars[i]<='9')){
                sb.append(chars[i]);
                rb.insert(0,chars[i]);
            }
        }
        return sb.toString().equalsIgnoreCase(rb.toString());

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode second=head;
        for(int i=1;i<=n;i++){
            second=second.next;
        }

        ListNode prev=null;
        while (second!=null){
            prev=first;
            first=first.next;
            second=second.next;
        }

       if (prev==null) return head.next;

       prev.next=first.next;

       return head;
    }

}
