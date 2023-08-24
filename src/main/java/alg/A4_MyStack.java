package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.Arrays;

/**
 *
 * @author baojiang
 * 1.������ʹ��int����ʵ�ֻ����߼�
 * 2.��2���Ż�,һ����ʹ�÷������int,�����ڱ�Ҫ�ķ�����
 * @version ʹ������ʵ��ջ: alg.A4_MyStack.java, v 0.1 2022��10��20�� ����10:21 baojiang Exp $
 */
public class A4_MyStack<T> {
    // ���ջ��Ԫ�ص�����
    private              Object[] storage;
    // ջ������
    private              int      capacity;
    // ջ��Ԫ�ص�����
    private              int      count;
    // ����������
    private static final int      GROW_FACTOR = 2;

    /**
     * ������ʼ�����Ĺ��췽��,Ĭ������Ϊ8
     */
    public A4_MyStack() {
        this.capacity = 8;
        this.storage = new Object[this.capacity];
        this.count = 0;

    }

    /**
     *  ��ʼ�����Ĺ��췽��
     * @param initialCapacity
     */
    public A4_MyStack(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Illegal initialCapacity!");
        }
        this.capacity = initialCapacity;
        this.storage = new Object[initialCapacity];
        this.count = 0;
    }

    /**
     * ��ջ
     * @param value
     */
    public synchronized void push(T value) {
        // ջ��������
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    /**
     * ����ջ��Ԫ�ز���ջ
     * @return
     */
    public synchronized T pop() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        T obj = peek();
        // �Ƴ�ջ��Ԫ��,�ǳ��ؼ�
        remove(size() - 1);
        return obj;
    }

    /**
     * ����ջ��Ԫ�ز���ջ
     * @return
     */
    public synchronized T peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        return (T) storage[count];
    }

    /**
     * �ж�ջ�Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * ����ջ��Ԫ�ظ���
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * ÿ����ջ֮ǰ���ж�ջ�������Ƿ��ã���������þ���Arrays.copyOf()��������
     */
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    /**
     * �Ƴ�Ԫ��
     * @param index
     */
    private synchronized void remove(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = count - index - 1;
        if (j > 0) {
            System.arraycopy(storage, index + 1, storage, index, j);
        }
        count--;
    }
}