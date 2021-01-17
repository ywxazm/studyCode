package com.ymj.stack;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.stack
 * @date 2020/8/24 17:14
 * @description Push（栈顶插入元素），Pop(返回栈最上方的元素，并删除），isEmpty（查询栈是否为空），Top（返回最上方元素，并不删除）
 */
public class StackTest {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("aaa");
        myStack.push("bbb");
        myStack.push("ccc");
        myStack.push("ddd");


        System.out.println(myStack.isEmpty());
        System.out.println(myStack.Pop());
        System.out.println(myStack.Pop());
        System.out.println(myStack.Pop());
        System.out.println(myStack.Pop());
        System.out.println(myStack.isEmpty());

    }

    private static void print(MyStack myStack) {
        for(int i = 0; i < myStack.size; i++) {
            System.out.print(myStack.Top() + ", ");
        }
        System.out.println();
    }
}