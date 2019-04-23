package LeetCode;

public class leetcode_AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode add1 = l1;
		ListNode add2 = l2;
		ListNode result = new ListNode(0);
		ListNode resultcopy = result;

		int sum = 0;
		while (add1 != null || add2 != null)
		{

			sum = sum / 10; // 取进位加

			if (add1 != null)
			{
				sum = sum + add1.val;
				add1 = add1.next;
			}
			if (add2 != null)
			{
				sum = sum + add2.val;
				add2 = add2.next;
			}

			result.next = new ListNode(sum % 10);
			result = result.next;

		}
		if (sum / 10 == 1)
			result.next = new ListNode(1);
		return resultcopy.next;
	}

}
