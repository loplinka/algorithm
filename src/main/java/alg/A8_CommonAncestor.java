package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import base.TreeNode;
import tools.PrintUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author baojiang
 * @version 最近公共祖先: alg.A8_CommonAncestor.java, v 0.1 2022年10月03日 下午4:27 baojiang Exp $
 */
public class A8_CommonAncestor {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(7);
        PrintUtil.print(Solution1.lowestCommonAncestor(createBinTree(), p, q));
        PrintUtil.print(Solution2.lowestCommonAncestor(createBinTree(), p, q));
        PrintUtil.print(Solution3.lowestCommonAncestor(createBinTree(), p, q));

    }

    /**
     * 中序递增
     *     4
     *    / \
     *   2   6
     *  /\  / \
     * 1 3  5 7
     *
     * @return
     */
    public static TreeNode createBinTree() {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf3 = new TreeNode(3);
        TreeNode leaf5 = new TreeNode(5);
        TreeNode leaf7 = new TreeNode(7);

        TreeNode left2 = new TreeNode(2, leaf1, leaf3);
        TreeNode right6 = new TreeNode(6, leaf5, leaf7);

        return new TreeNode(4, left2, right6);
    }

    /**
     * 方法1: 存储父节点(二叉树)
     * 我们可以用哈希表存储所有节点的父节点，
     * 然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点，再从 q 节点开始不断往上跳，
     * 如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先
     *
     */
    static class Solution1 {

        // 存储每一个节点和父节点的映射
        public static Map<Integer, TreeNode> parent  = new HashMap<Integer, TreeNode>();
        // p或者q向根节点的访问路径
        public static Set<Integer>           visited = new HashSet<Integer>();

        // 深度优先遍历,先左再右
        public static void dfs(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 深度优先 存储每一个节点和父节点的映射
            dfs(root);
            // p节点往根节点遍历,并存储路径
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            // q节点往根节点遍历,和q已经访问过的路径最短碰撞,成功则是LCA,否则继续往根节点遍历,并存储路径
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }
    }

    /**
     * 递归法, (二叉树)
     * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
     *
     */
    static class Solution2 {

        public static TreeNode ans;

        public Solution2() {
            this.ans = null;
        }

        public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            // 判断左右子树
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);

            if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
                ans = root;
            }
            return lson || rson || (root.val == p.val || root.val == q.val);
        }

        public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);
            return ans;
        }
    }

    /**
     * 二叉搜索树的最近公共祖先
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-26/
     */
    static class Solution3 {
        /**
         * 一次遍历法:
         * 二叉搜索树是有序的,中序遍历是一个递增数列
         * 其中任何子树都满足右>父>左
         * @param root
         * @param p
         * @param q
         * @return
         */
         public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;
            // 二叉搜索树BST任何子树都满足右>父>左
            while (true) {
                // pq都<root,那他们一定在左子树,循环向左移动
                if (p.val < ancestor.val && q.val < ancestor.val) {
                    ancestor = ancestor.left;
                }
                // pq都>root,那他们一定在右子树,循环右移动
                else if (p.val > ancestor.val && q.val > ancestor.val) {
                    ancestor = ancestor.right;
                }
                // pq即不同时小于root,也不同时大于root,根据BST的特性,则一定是p<root<q,即为LCA
                else {
                    break;
                }
            }
            return ancestor;
        }
    }



}