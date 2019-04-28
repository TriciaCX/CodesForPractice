package LeetCode;

public class leetcode_sortedListToBST
{
	/*
	 * Given a singly linked list where elements are sorted in ascending order, 
	 * convert it to a height balanced BST.
	 */
//这道题是要求把有序链表转为二叉搜索树，和之前那道Convert Sorted Array to Binary Search Tree思路完全一样，
//只不过是操作的数据类型有所差别，一个是数组，一个是链表。数组方便就方便在可以通过index直接访问任意一个元素，而链表不行。
//由于二分查找法每次需要找到中点，
//而链表的查找中间点可以通过快慢指针来操作。
//找到中点后，要以中点的值建立一个数的根节点，然后需要把原链表断开，分为前后两个链表，都不能包含原中节点，然后再分别对这两个链表递归调用原函数，分别连上左右子节点即可。

public TreeNode sortedListToBST(ListNode head) {
    return toBST(head, null);
}

private TreeNode toBST(ListNode head, ListNode tail) {
    if (head == tail) return null;
    // 申请两个指针，fast移动速度是low的两倍
    ListNode fast = head;
    ListNode slow = head;
    while (fast != tail && fast.next != tail) {
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = toBST(head, slow);
    root.right = toBST(slow.next, tail);

    return root;
}
}
