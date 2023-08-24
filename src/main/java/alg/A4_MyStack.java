package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.Arrays;

/**
 *
 * @author baojiang
 * 1.数组先使用int类型实现基本逻辑
 * 2.做2点优化,一个是使用泛型替代int,二是在必要的方加锁
 * @version 使用数组实现栈: alg.A4_MyStack.java, v 0.1 2022年10月20日 上午10:21 baojiang Exp $
 */
public class A4_MyStack<T> {
    // 存放栈中元素的数组
    private              Object[] storage;
    // 栈的容量
    private              int      capacity;
    // 栈中元素的数量
    private              int      count;
    // 扩容增长率
    private static final int      GROW_FACTOR = 2;

    /**
     * 不带初始容量的构造方法,默认容量为8
     */
    public A4_MyStack() {
        this.capacity = 8;
        this.storage = new Object[this.capacity];
        this.count = 0;

    }

    /**
     *  初始容量的构造方法
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
     * 入栈
     * @param value
     */
    public synchronized void push(T value) {
        // 栈满则扩容
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    /**
     * 返回栈顶元素并出栈
     * @return
     */
    public synchronized T pop() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        T obj = peek();
        // 移除栈顶元素,非常关键
        remove(size() - 1);
        return obj;
    }

    /**
     * 返回栈顶元素不出栈
     * @return
     */
    public synchronized T peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        return (T) storage[count];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 返回栈中元素个数
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 每次入栈之前先判断栈的容量是否够用，如果不够用就用Arrays.copyOf()进行扩容
     */
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    /**
     * 移除元素
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