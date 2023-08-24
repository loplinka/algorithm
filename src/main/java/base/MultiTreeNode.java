/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package base;

import java.util.List;

/**
 *
 * @author baojiang
 * @version 多叉树节点: MultiTreeNode.java, v 0.1 2022年10月23日 下午2:22 baojiang Exp $
 */
public class MultiTreeNode {


    public int                 val;
    public List<MultiTreeNode> childrens;

    public MultiTreeNode() {
    }

    public MultiTreeNode(int val) {
        this.val = val;
    }

    public MultiTreeNode(int val, List<MultiTreeNode> childrens) {
        this.val = val;
        this.childrens = childrens;
    }
}