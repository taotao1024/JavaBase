package arithmetic.栈和队列;

import com.lsy.arithmetic.栈和队列.设计一个有getMin功能的栈;
import junit.framework.TestCase;

public class 设计一个有getMin功能的栈Test extends TestCase {
    public void testMyStack1() {
        设计一个有getMin功能的栈.MyStack1 myStack1 = new 设计一个有getMin功能的栈.MyStack1();
        myStack1.push(10);
        myStack1.push(2);
        myStack1.push(20);
        myStack1.push(21);
        System.out.println(myStack1.getMin());
        myStack1.pop();
        myStack1.pop();
        System.out.println(myStack1.getMin());
        myStack1.pop();
        System.out.println(myStack1.getMin());
    }

    public void testMyStack2() {
        设计一个有getMin功能的栈.MyStack2 myStack2 = new 设计一个有getMin功能的栈.MyStack2();
        myStack2.push(10);
        myStack2.push(2);
        myStack2.push(20);
        myStack2.push(21);
        System.out.println(myStack2.getMin());
        myStack2.pop();
        myStack2.pop();
        System.out.println(myStack2.getMin());
        myStack2.pop();
        System.out.println(myStack2.getMin());
    }

}