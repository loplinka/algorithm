/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package labuladong;

import base.ListNode;

/**
 * @author Baojiang Yang
 * @version : A3_Tree_�ݹ��޸����ݽṹ.java, v 0.1 2023��10��17�� 01:00  Baojiang Yang Exp $
 */
public class A3_Tree_�ݹ��޸����ݽṹ {

    // �����ķ�ʽʵ���������ݽṹ�Ĳ���
    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.getVal());
            head = head.next;
        }
    }

    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * �����ӡ����
     * @param nums
     * @param i
     */
    public void printArrayReverse(int[] nums, int i) {
        if (i == nums.length) {
            return;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            System.out.println(nums[j]);
        }
    }

    public int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    /**
     * 1->2->3->4->null
     * 1->2->3->4->5->null
     * @param head
     * @param val
     * @return
     */
    public ListNode addLast(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }

        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(val);
        return head;
    }

    /**
     * 1->2->3->4->null
     * 1->2->3->null
     * @param head
     * @return
     */
    public ListNode removeLast(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return head;
    }

    /** �ݹ�ķ�ʽʵ���������ݽṹ�Ĳ���,�����˼����һ��Ҫ����ListNode */

    public void printList2(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.getVal());
        printList2(head.next);
    }

    /**
     * �����ӡ����
     * @param nums
     * @param i
     */
    public void printArray2(int[] nums, int i) {
        if (i == nums.length) {
            return;
        }
        System.out.println(nums[i]);
        printArray2(nums, i + 1);
    }

    /**
     * �����ӡ����
     * @param nums
     * @param i
     */
    public void printArrayReverse2(int[] nums, int i) {
        if (i == nums.length) {
            return;
        }
        printArrayReverse2(nums, i + 1);
        System.out.println(nums[i]);
    }

    public int size2(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + size2(head.next);
    }

    /**
     * 1->2->3->4->null
     * 1->2->3->4->5->null
     * @param head
     * @param val
     * @return
     */
    public ListNode addLast2(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }
        head.next = addLast2(head.next, val);
        return head;
    }

    /**
     * 1->2->3->4->null
     * 1->2->3->null
     * @param head
     * @return
     */
    public ListNode removeLast2(ListNode head) {
        if (head.next == null) {
            return null;
        }
        head.next = removeLast2(head.next);
        return head;
    }

}