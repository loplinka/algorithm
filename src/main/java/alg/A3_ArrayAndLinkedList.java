package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.ListNode;
import tools.PrintUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author baojiang
 * @version 数组和链表: ArrayAndLinkedList.java, v 0.1 2022年09月27日 下午1:18 baojiang Exp $
 */
public class A3_ArrayAndLinkedList {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        //1.链表的反转
        ListNode headNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println("当前链表是:");
        PrintUtil.print(headNode);

        // 反转
        ListNode reverseNode = reverseLinkedList(headNode);
        //ListNode reverseNode = reverseList(headNode);
        System.out.println("反转后的链表是:");
        PrintUtil.print(reverseNode);

        // 2.判断是否有环
        ListNode noCycle = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(hasCycle2(noCycle) ? "有环" : "无环");

        ListNode hasCycle = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(3, null)))));
        System.out.println(hasCycle2(hasCycle) ? "有环" : "无环");

    }



    /**
     * 链表的反转
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    public static ListNode reverseLinkedList(ListNode head) {

        // 定义前驱节点
        ListNode prev = null;
        // 定义当前节点,指向第一个元素
        ListNode curr = head;
        while (curr != null) {
            // 取出当前节点的下一个节点暂存
            ListNode next = curr.next;
            /**
             * 当前节点指向下一个节点的指针 修改为前继节点,prev的变化如下
             * 即从1 -> 2 -> 3 -> 4 -> 5 -> null 修改成 null <- 1 <- 2 <- 3 <- 4 <- 5
             * null <- 1
             * null <- 1 <- 2
             * null <- 1 <- 2 <- 3
             * null <- 1 <- 2 <- 3 <- 4
             * null <- 1 <- 2 <- 3 <- 4 <- 5
             */
            curr.next = prev;
            // 前继节点移动到当前节点
            prev = curr;
            // 当前节点移动到后继节点
            curr = next;
        }

        return prev;
    }

    /**
     * 自主练习
     * 总结: 循环的基本套路,while(curr!=null) 条件最后一定是重新赋值curr
     * @param head
     * @return
     */
    public static ListNode reverseLListNodeMy1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 双指针法
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        slowNode.next = null;
        while (fastNode != null) {

            ListNode nextNextNode = fastNode.next;
            fastNode.next = null;
            fastNode.next = slowNode;

            slowNode = fastNode;
            fastNode = nextNextNode;
        }
        return slowNode;
    }

    /**
     * 交换链表的两两相邻元素: 迭代法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode temp = dummyNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;

            end.next = start;
            temp = start;
        }
        return dummyNode.next;
    }

    public static ListNode swapPairsMy(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            // 切换方向,重新拉电线
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 移动指针
            temp = node1;
        }

        return  dummyHead.next;
    }

    /**
     * 交换链表的两两相邻元素: 递归法
     * @param head
     * @return
     */
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursion(newHead.next);
        newHead.next = head;
        return  newHead;
    }


    /**
     * 判断链表是否有环
     * 使用Set集合,每走一步就记录一下,并且检测是否已经在Set中
     * 快慢指针,快指针移动2步,慢指针移动1步,最后判断快慢指针是否相遇
     */
    public static boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<Integer> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr.getVal())) {
                return true;
            }
            set.add(curr.getVal());
            curr = curr.next;
        }
        return false;
    }


    public static boolean hasCycleMy(ListNode head) {
        ListNode curr = head;
        Set<Integer> valSet = new HashSet<>();
        while (curr.next != null) {
            if (valSet.contains(curr.getVal())) {
                return true;
            }
            valSet.add(curr.getVal());
            curr = curr.next;

        }
        return false;
    }

    /**
     * 判断链表是否有环
     * 快慢指针,快指针移动2步,慢指针移动1步,最后判断快慢指针是否相遇
     */
    public static boolean hasCycle2(ListNode head) {
        // 空链表 或者 尾节点
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && slow.getVal() != fast.getVal()) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static boolean hasCycle2My(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && slow.getVal() != fast.getVal()) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}