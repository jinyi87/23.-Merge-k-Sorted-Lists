import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * using PriorityQueue,but Time Limit Exceeded
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
class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}

public class Solution
{
	public ListNode mergeKLists(ListNode[] lists)
	{
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>()
		{

			@Override
			public int compare(ListNode o1, ListNode o2)
			{
				// TODO Auto-generated method stub
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
				{
					return 0;
				}
				else
				{
					return 1;
				}
			}
		});
		for (int i = 0; i < lists.length; i++)
		{
			for (ListNode listNode=lists[i]; listNode !=null; listNode=listNode.next)
			{
				priorityQueue.add(listNode);
			}
		}
		ListNode list=new ListNode(0);
		ListNode tail=list;
		while (!priorityQueue.isEmpty())
		{
			tail.next=priorityQueue.poll();
			tail=tail.next;
		}
		return list.next;

	}
}