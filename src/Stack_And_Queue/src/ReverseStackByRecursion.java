package Stack_And_Queue.src;


import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ReverseStackByRecursion {
/*
    只通过递归函数和和栈操作，逆转一个栈
*/
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        //弹出栈顶的数据
        int result = stack.pop();
        if(stack.isEmpty()){
            //如果 stack 现在是空的， 返回result
            return result;
        }else{
            //stack 不是空的，递归
            int last = getAndRemoveLastElement(stack);
            //将弹出的数据压入栈
            stack.push(result);
            //将栈中最后一个元素返回，实现目的
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
      if(stack.isEmpty()){
          //如果为空栈，则返回。
          return;
      }
      //获取栈底的元素
      int i = getAndRemoveLastElement(stack);
      //递归该方法，将栈清空
      reverse(stack);
      //将元素压入，每一层递归都将最后一个元素调出，
      //而最先执行压入的为最后一层，实现将栈中元素逆转。
      stack.push(i);
    }

    @Test
    public void test1(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("逆转前：");
        stack.forEach(System.out::print);

        System.out.println("\n逆转后：");
        ReverseStackByRecursion.reverse(stack);
        stack.forEach(System.out::print);

        /*
        逆转前：12345
        逆转后：54321
        */
    }

}
