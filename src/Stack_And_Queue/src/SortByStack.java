package Stack_And_Queue.src;

import java.util.Stack;

public class SortByStack {

    public static void sortStackByStack(Stack<Integer> stack){
        //申请需求栈
        Stack<Integer> help = new Stack<Integer>();
        //循环执行排序
        while(!stack.isEmpty()){
            //记录 stack 栈顶的数据
            int cur = stack.pop();
            //循环将 help 栈中比 stack 栈顶数据大的值压回 stack 中
            while(!help.isEmpty() && help.peek() > cur){
                stack.push(help.pop());
            }
            //最后将 cur 压入 help 中
            help.push(cur);
        }
        //将help 栈中的数据，返回到 stack 中
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

}
