package Stack_And_Queue.src;


import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ReverseStackByRecursion {
/*
    只通过递归函数和和栈操作，逆转一个栈
*/
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
      if(stack.isEmpty()){
          return;
      }
      int i = getAndRemoveLastElement(stack);
      reverse(stack);
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
