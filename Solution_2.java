

/**
 * using Recursive,classic!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * Definition for singly-linked list. 
 * class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}
 */


public class Solution
{
	public ListNode mergeKLists(ListNode[] lists)
	{
		
		return partion(lists, 0, lists.length-1);

	}
	public ListNode partion(ListNode[] lists,int left,int right)
	{
		if(left==right) return lists[left];
		if(left<right)
		{
			int middle=(left+right)/2;
			ListNode leftlist=partion(lists, left, middle);
			ListNode rightlist=partion(lists, middle+1, right);
			return merge2list(leftlist, rightlist);
		}else
			return null;
	}
	public ListNode merge2list(ListNode l1,ListNode l2)
	{
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val)
		{
			l1.next=merge2list(l1.next, l2);
			return l1;
		}	
		else
		{
			l2.next=merge2list(l1, l2.next);
			return l2;
		}
			
	}
}