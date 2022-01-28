package Stack_And_Queue.src;

import java.util.Stack;

public class getMinByStack {

    //创建两个栈
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    //创建对象是创建栈
    public getMinByStack(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /*
     * 当stackMin为空时，将数据压入栈
     * 当newNum小于stackMin中数据的是，将数据加入stackMin中
     * 最后，都需要将数据压入stackData中
    */
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push((newNum));
        }else if(newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if(value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    /*
    * 当栈为空时，抛出异常，
    * 当栈不为空时，将 stackMin 中的数据抛出
    */
    public int getMin(){
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }




}
