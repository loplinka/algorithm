/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package alg;

import base.ListNode;
import base.TreeNode;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author Baojiang Yang
 * @version TEST: A0.java, v 0.1 2023年06月20日 16:22  Baojiang Yang Exp $
 */
public class A0_TEST {

//    public static void main(String[] args) {
//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        a = b;
//        System.out.println("a=" + a);
//        b = c;
//        System.out.println("a=" + a);
//        c = new Integer(4);
//        System.out.println("a=" + a);
//        System.out.println("c=" + c);
//
//    }

    void printRe1(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        for (ListNode curr = head; curr != null; curr = curr.next) {
            stack.push(curr.val);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }

    void printRe2(ListNode head) {
        // base case
        if (head == null) {
            return;
        }

        printRe2(head.next);
        System.out.println(head.val);

    }

    int maxProfit(int[] arr) {
        int maxProfit = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int todayP = arr[i];
            int tomorrowP = arr[i + 1];
            int profit = tomorrowP - todayP;
            if (profit > 0) {
                maxProfit = maxProfit + profit;
            }

        }
        return maxProfit;
    }

    int bs(int[] arr, int target) {

        // Param check

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        // Ex
        if (target < arr[left] || target > arr[right] || left > right) {
            return -1;
        }

        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    int vioSearch(String s, String p) {
        // Param Check

        int sL = s.length();
        int pL = p.length();

        int up = 0;
        int down = 0;

        while (up < sL && down < pL) {
            if (s.charAt(up) == p.charAt(down)) {
                up++;
                down++;
            } else {
                up = up - down + 1;
                down = 0;
            }
        }

        if (down == pL) {
            return up - down;
        }

        return -1;
    }

    void level(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int levelNum = 1;

        while (!q.isEmpty()) {

            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                System.out.println("节点" + curr.val + "在" + levelNum + "层");
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            levelNum++;
        }
    }


    void snake(TreeNode root) {
        if (root == null) {
            return;
        }

        List<LinkedList<Integer>> re = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean  leftToTight = true;

        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();

            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();

                if (leftToTight) {
                    level.addFirst(curr.val);
                } else {
                    level.addLast(curr.val);
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            re.add(level);
            leftToTight = !leftToTight;
        }
    }







}