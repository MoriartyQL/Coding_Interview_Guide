package Stack_And_Queue.src;

/*
   用两栈实现队列，并且支持队列的基本操作(add,poll,peek)
*/

import java.util.Stack;

public class QueueOfTowStack {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public QueueOfTowStack() {
        this.stackPop = new Stack<Integer>();
        this.stackPush = new Stack<Integer>();
    }

    //添加元素到stackPush中
    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    /*
        1、先判断是否都为空，若两个栈都为空，则抛出异常
        2、如果只有 stackPop 为空，将 stackPush 中的数据导入到 stackPop 中
        3、返回 stackPop 中栈顶的数字
    */
    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("stack is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /*
        peek() 方法
        1、先判断是否都为空，若两个栈都为空，则抛出异常
        2、如果只有 stackPop 为空，将 stackPush 中的数据导入到 stackPop 中
        3、返回 stackPop 中栈顶的数字
    */
    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Stack is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        stackPop.peek();
        return stackPop.pop();

    }


}
