/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package base;

/**
 *
 * @author baojiang
 * @version ����ڵ�: ListNode.java, v 0.1 2022��09��27�� ����2:05 baojiang Exp $
 */
public class ListNode {

    int val;

    public ListNode next;

    /**
     * Getter method for property <tt>val</tt>.
     *
     * @return property value of val
     */
    public int getVal() {
        return val;
    }

    public ListNode(int val) {
        this.val = val;
    }



    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}