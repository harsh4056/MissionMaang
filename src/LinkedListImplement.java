import java.util.LinkedList;
import java.util.List;

public class LinkedListImplement {


    public static void main(String[] args) {
        int[] nums= new int[]{1,2,3,4,5};

        LinkedListImplement soln= new LinkedListImplement();
        LinkedList head= soln.arrayToLinkedList(nums);
        soln.printList(head);
        head=soln.detachAndMakeHead(head,3);
        head=soln.reverse(head);
        soln.printList(head);



    }


    public LinkedList mergeSortedList(LinkedList head1,LinkedList head2){

        LinkedList curr1=head1;
        LinkedList curr2=head2;
        LinkedList nHead=new LinkedList(-101);
        LinkedList curr3=nHead;
        while (curr1!=null && curr2!=null){
            if(curr1.val<curr2.val){
                curr3.next=curr1;
                curr1=curr1.next;
            }
            else{
                curr3.next=curr2;
                curr2=curr2.next;
            }
            curr3=curr3.next;
        }
        while(curr1!=null){
            curr3.next=curr1;
            curr1=curr1.next;
            curr3=curr3.next;
        }
        while(curr2!=null){
            curr3.next=curr2;
            curr2=curr2.next;
            curr3=curr3.next;
        }




        return nHead.next;
    }

    public LinkedList reverse(LinkedList head){

        LinkedList curr=head;
        LinkedList temp=null;
        LinkedList prev=null;
        while (curr!=null){
            temp=curr.next;
            if(curr.next==null){
                head=curr;
            }
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return head;
    }

    public LinkedList detachAndMakeHead(LinkedList head,int val){
        LinkedList curr=head,prev=null;
        while (curr!=null && curr.val!=val){
            prev=curr;
            curr=curr.next;

        }
        prev.next=prev.next.next;
        curr.next=head;
        head=curr;
        return head;
    }


     public LinkedList arrayToLinkedList(int[]nums){
         LinkedList head= new LinkedList(-1);
         LinkedList curr= head;
         for (int num : nums) {

             curr.next= new LinkedList(num);
             curr=curr.next;

         }
         head=head.next;
         return head;
     }

     public void printList(LinkedList head){
         LinkedList curr=head;
         //traversing a list
         int count=0;
         while (curr!=null){
             System.out.print(curr.val+" -> ");
             curr=curr.next;
             count++;
         }
         System.out.print("null");
         System.out.println();
         System.out.println("Length : "+ count);
     }
     class LinkedList{

        int val;
        LinkedList next;

        public LinkedList(int val, LinkedList next) {
            this.val = val;
            this.next = next;
        }
        public LinkedList(int val) {
            this.val = val;
            //this.next = next;
        }
    }
}
