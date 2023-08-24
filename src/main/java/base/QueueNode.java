/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package base;

/**
 *
 * @author baojiang
 * @version : QueueNode.java, v 0.1 2022年10月04日 下午11:21 baojiang Exp $
 */
public class QueueNode {

    public TreeNode node;
    public int      depth;

    public QueueNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }

}