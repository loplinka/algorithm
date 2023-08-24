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
 * @version �����������: alg.A8_CommonAncestor.java, v 0.1 2022��10��03�� ����4:27 baojiang Exp $
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
     * �������
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
     * ����1: �洢���ڵ�(������)
     * ���ǿ����ù�ϣ��洢���нڵ�ĸ��ڵ㣬
     * Ȼ�����ǾͿ������ýڵ�ĸ��ڵ���Ϣ�� p ��㿪ʼ����������������¼�Ѿ����ʹ��Ľڵ㣬�ٴ� q �ڵ㿪ʼ������������
     * ��������Ѿ����ʹ��Ľڵ㣬��ô����ڵ��������Ҫ�ҵ������������
     *
     */
    static class Solution1 {

        // �洢ÿһ���ڵ�͸��ڵ��ӳ��
        public static Map<Integer, TreeNode> parent  = new HashMap<Integer, TreeNode>();
        // p����q����ڵ�ķ���·��
        public static Set<Integer>           visited = new HashSet<Integer>();

        // ������ȱ���,��������
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
            // ������� �洢ÿһ���ڵ�͸��ڵ��ӳ��
            dfs(root);
            // p�ڵ������ڵ����,���洢·��
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            // q�ڵ������ڵ����,��q�Ѿ����ʹ���·�������ײ,�ɹ�����LCA,������������ڵ����,���洢·��
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
     * �ݹ鷨, (������)
     * ���ӣ�https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
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
            // �ж���������
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
     * �����������������������
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-26/
     */
    static class Solution3 {
        /**
         * һ�α�����:
         * �����������������,���������һ����������
         * �����κ�������������>��>��
         * @param root
         * @param p
         * @param q
         * @return
         */
         public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;
            // ����������BST�κ�������������>��>��
            while (true) {
                // pq��<root,������һ����������,ѭ�������ƶ�
                if (p.val < ancestor.val && q.val < ancestor.val) {
                    ancestor = ancestor.left;
                }
                // pq��>root,������һ����������,ѭ�����ƶ�
                else if (p.val > ancestor.val && q.val > ancestor.val) {
                    ancestor = ancestor.right;
                }
                // pq����ͬʱС��root,Ҳ��ͬʱ����root,����BST������,��һ����p<root<q,��ΪLCA
                else {
                    break;
                }
            }
            return ancestor;
        }
    }



}