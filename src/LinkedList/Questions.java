/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ahmet
 */



public class Questions {
    
    //    Remove Dups: Write code to remove duplicates from an unsorted linked list.
    //    FOLLOW UP
    //    How would you solve this problem if a temporary buffer is not allowed?
    
    //     1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 4 -> 5 -> 6
    
    //Not Sorted
    
    //   6 -> 10 -> 6 -> 1 -> 23 -> 10
    public static ListNode removeDups(ListNode head)
    {
        HashSet<Integer> set = new HashSet();
        ListNode dummyHead = new ListNode(-1), dummy = dummyHead;
        
        while(head != null)
        {
            if(!set.contains(head.val))
            {
                dummy.next = head;
                dummy = dummy.next;
                set.add(head.val);
            }
            head = head.next;
        }
        dummy.next = null;
                
        return dummyHead.next;
    }
    
    //If sorted
    //    public static ListNode RemoveDups(ListNode head)
    //    {
    //        //We can use hashSet of course but we can do it in place like this
    //        ListNode dummyHead = new ListNode(-1);
    //        ListNode dummy = dummyHead;
    //
    //        while(head != null &&  head.next != null)
    //        {
    //            if(head.next.val == head.val)
    //                head.next = head.next.next;
    //            else
    //            {
    //                dummy.next = head;
    //                dummy = dummy.next;
    //                head = head.next;
    //            }
    //        }
    //        
    //        return dummyHead.next;
    //    }

    
    
    //   6 -> 10 -> 6 -> 1 -> 23 -> 10
    public static int kthLastElement(ListNode head, int k)
    {
        ListNode start = head;
        ListNode end = head;
        
        for(int i = 0;i < k;i++)
            end = end.next;
        
        while(end != null)
        {
            start = start.next;
            end = end.next;
        }
        
        return start.val;
    }
    
        //   6 -> 10 -> 6 -> 1 -> 23 -> 10  , 2
        //

    public static int kthLastElementRecursive(ListNode head, int k)
    {
        if(head == null)
            return 0;
        
        int val = kthLastElementRecursive(head.next, k) + 1;
        if(val == k)
            System.out.println();//We need to use wrapper class
        
        return val;
    }
    
    //Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
    //before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
    //to be after the elements less than x (see below). The partition element x can appear anywhere in the
    //"right partition"; it does not need to appear between the left and right partitions.
    // Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
    //Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
    public static ListNode partition(ListNode head ,int val)
    {
        ListNode firstDummyHead = new ListNode(-1) , firstDummy = firstDummyHead;
        ListNode secondDummyHead = new ListNode(-1), secondDummy = secondDummyHead;
        
        while(head != null)
        {
            if(head.val > val)
            {
                secondDummy.next = head;
                secondDummy = secondDummy.next;
            }
            else
            {
                firstDummy.next = head;
                firstDummy = firstDummy.next;
            }
            head = head.next;
        }
        
        
        if(firstDummyHead.next != null && secondDummyHead.next != null)
            firstDummy.next = secondDummyHead.next;
        else if(firstDummy.next != null && secondDummyHead.next == null)
            return firstDummyHead.next;
        else if(secondDummy.next == null && secondDummyHead.next != null)
            return secondDummyHead.next;
        
        secondDummy.next = null;
        return firstDummyHead.next;
    }
 
    //    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
    //Output: 9 - > 1 - > 2. That is, 912.
    public static ListNode addTwoLists(ListNode first, ListNode second)
    {
        Stack<ListNode> firstListStack = new Stack();
        Stack<ListNode> secondListStack = new Stack();

        ListNode tmpFirst = first , tmpSecond = second;
        while(tmpFirst != null)
        {
            firstListStack.push(tmpFirst);
            tmpFirst = tmpFirst.next;
        }
        
        while(tmpSecond != null)
        {
            secondListStack.push(tmpSecond);
            tmpSecond = tmpSecond.next;
        }
                
        int carry = 0;
        Deque<ListNode> result = new LinkedList();
        while(!firstListStack.isEmpty() || !secondListStack.isEmpty())
        {
            int sum = (firstListStack.isEmpty() ? 0 : firstListStack.pop().val) 
                    + (secondListStack.isEmpty() ? 0 : secondListStack.pop().val)
                    + carry;
            
            carry /= 10;
            sum %= 10;
            
            result.offerFirst(new ListNode(sum));
        }
        
        ListNode dummyHead = new ListNode(-1), tmp = dummyHead;
        while(!result.isEmpty())
        {
            tmp.next = result.poll();
            tmp = tmp.next;
        }
        
        return dummyHead.next;
    }
    
    
    //    2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
    
    // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1
    // 1 -> 2 -> 3 -> 4 -> 4 -> 3 -> 2 -> 1
    // 1 -> 2 -> 3 -> 4 -> 5 -> 3 -> 2 -> 1    
    public static boolean isPalindrome(ListNode head)
    {
        ListNode slow = head, fast = head;
        
        Stack<ListNode> stack = new Stack();
        while(fast != null && fast.next != null)
        {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast!= null)
            slow = slow.next;

        for(int i = 0; i < stack.size();i++)
        {
            if(stack.pop().val != slow.val)
                return false;
            
            slow = slow.next;
        }
        
        return true;
    }
    
    public static ListNode intersectionBegin(ListNode first, ListNode second)
    {
        if(first == null || second == null)
            return null;
        
        Result firstList = getTailAndLen(first);
        Result secondList = getTailAndLen(second);
        
        if(firstList.tail != secondList.tail)
            return null;
        
        ListNode longer = firstList.size > secondList.size ? first : second;
        ListNode shorter = firstList.size > secondList.size ? second : first;
        
        for(int i = 0;i < Math.abs(firstList.size - secondList.size);i++)
            longer = longer.next;
        
        
        while(longer != shorter)
        {
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return longer;
    }
    
    private static Result getTailAndLen(ListNode head)
    {
        Result result = new Result();
        ListNode tmp = head;
        while(tmp.next != null)
        {
            tmp = tmp.next;
            result.size++;
        }
        result.tail = tmp;
        
        return result;
    }
    
    
    //find if list has a loop in it
    public static boolean isCyclic(ListNode head)
    {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        
        return false;
    }
    
    
    
    public static ListNode cycleBegin(ListNode head)
    {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        
        if(fast == null || fast.next == null)
            return null;
        
        ListNode start = head;
        while(start != slow)
        {
            start = start.next;
            slow = slow.next;
        }
        
        return start;
    }
    
}

class Result
{
    ListNode tail;
    int size;
    
    public Result()
    {
        tail = null;
        size = 1;
    }
}
