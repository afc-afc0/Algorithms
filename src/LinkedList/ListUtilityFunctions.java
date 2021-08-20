/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author ahmet
 */
public class ListUtilityFunctions {

    public static ListNode creteList(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for(int i = 1; i < arr.length;i++)
        {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        tmp.next = null;
        
        return head;
    }
    
    public static void printList(ListNode head)
    {
        if(head == null)
            return;
        
        ListNode tmp = head;
        while(tmp.next != null)
        {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println(tmp.val);
    }
}
