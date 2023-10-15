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
 * @version ���������: ArrayAndLinkedList.java, v 0.1 2022��09��27�� ����1:18 baojiang Exp $
 */
public class A3_ArrayAndLinkedList {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        //1.����ķ�ת
        ListNode headNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println("��ǰ������:");
        PrintUtil.print(headNode);

        // ��ת
        ListNode reverseNode = reverseLinkedList(headNode);
        //ListNode reverseNode = reverseList(headNode);
        System.out.println("��ת���������:");
        PrintUtil.print(reverseNode);

        // 2.�ж��Ƿ��л�
        ListNode noCycle = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(hasCycle2(noCycle) ? "�л�" : "�޻�");

        ListNode hasCycle = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(3, null)))));
        System.out.println(hasCycle2(hasCycle) ? "�л�" : "�޻�");

    }



    /**
     * ����ķ�ת
     * ���룺head = [1,2,3,4,5]
     * �����[5,4,3,2,1]
     */
    public static ListNode reverseLinkedList(ListNode head) {

        // ����ǰ���ڵ�
        ListNode prev = null;
        // ���嵱ǰ�ڵ�,ָ���һ��Ԫ��
        ListNode curr = head;
        while (curr != null) {
            // ȡ����ǰ�ڵ����һ���ڵ��ݴ�
            ListNode next = curr.next;
            /**
             * ��ǰ�ڵ�ָ����һ���ڵ��ָ�� �޸�Ϊǰ�̽ڵ�,prev�ı仯����
             * ����1 -> 2 -> 3 -> 4 -> 5 -> null �޸ĳ� null <- 1 <- 2 <- 3 <- 4 <- 5
             * null <- 1
             * null <- 1 <- 2
             * null <- 1 <- 2 <- 3
             * null <- 1 <- 2 <- 3 <- 4
             * null <- 1 <- 2 <- 3 <- 4 <- 5
             */
            curr.next = prev;
            // ǰ�̽ڵ��ƶ�����ǰ�ڵ�
            prev = curr;
            // ��ǰ�ڵ��ƶ�����̽ڵ�
            curr = next;
        }

        return prev;
    }

    /**
     * ������ϰ
     * �ܽ�: ѭ���Ļ�����·,while(curr!=null) �������һ�������¸�ֵcurr
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
     * ˫ָ�뷨
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
     * �����������������Ԫ��: ������
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
            // �л�����,����������
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // �ƶ�ָ��
            temp = node1;
        }

        return  dummyHead.next;
    }

    /**
     * �����������������Ԫ��: �ݹ鷨
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
     * �ж������Ƿ��л�
     * ʹ��Set����,ÿ��һ���ͼ�¼һ��,���Ҽ���Ƿ��Ѿ���Set��
     * ����ָ��,��ָ���ƶ�2��,��ָ���ƶ�1��,����жϿ���ָ���Ƿ�����
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
     * �ж������Ƿ��л�
     * ����ָ��,��ָ���ƶ�2��,��ָ���ƶ�1��,����жϿ���ָ���Ƿ�����
     */
    public static boolean hasCycle2(ListNode head) {
        // ������ ���� β�ڵ�
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