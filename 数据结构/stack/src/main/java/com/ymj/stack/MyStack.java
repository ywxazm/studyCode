package com.ymj.stack;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.stack
 * @date 2020/8/24 17:14
 * @description Push（栈顶插入元素），Pop(返回栈最上方的元素，并删除），isEmpty（查询栈是否为空），Top（返回最上方元素，并不删除）
 */
public class MyStack {

    public int size = 0;

    private int capacity = 12;

    private Object[] obj = new Object[capacity];

    //栈顶插入元素
    public void push(Object object) {
        obj[size] = object;
        size++;
    }

    //返回栈最上方的元素，并删除
    public Object Pop() {
        Object o = obj[size - 1];
        obj[size - 1] = null;
        size--;
        return o;
    }

    //查询栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //返回最上方元素，并不删除
    public Object Top() {
        return obj[size - 1];
    }
}