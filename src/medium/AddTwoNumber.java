package medium;

/**
 * Refer - https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;

			int sum = x + y + carry;
			carry = sum / 10;

			current.next = new ListNode(sum % 10);
			current = current.next;

			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));

		//						ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		//						ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		//				ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(1)));
		//				ListNode l2 = new ListNode(1);

		//		ListNode l1 = new ListNode(8, new ListNode(3, new ListNode(2)));
		//		ListNode l2 = new ListNode(9, new ListNode(2, new ListNode(1)));

		ListNode re = new AddTwoNumber().addTwoNumbers(l1, l2);

		ListNode itr = re;
		while (itr != null) {
			System.out.println(itr.val);
			itr = itr.next;
		}

	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

