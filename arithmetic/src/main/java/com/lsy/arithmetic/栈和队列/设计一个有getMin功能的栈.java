package com.lsy.arithmetic.栈和队列;

import java.util.Stack;

public class 设计一个有getMin功能的栈 {
    public static class MyStack1 {
        private Stack<Integer> stackDate;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackDate = new Stack<>();
            this.stackMin = new Stack<>();
        }

        /**
         * 入栈
         *
         * @param newNum
         */
        public void push(int newNum) {
            this.stackDate.push(newNum);
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum <= stackMin.peek()) {
                stackMin.push(newNum);
            }
        }

        /**
         * 出栈
         *
         * @return
         */
        public int pop() {
            if (this.stackDate.isEmpty()) {
                throw new RuntimeException("this stack is empty");
            }
            int value = stackDate.pop();
            if (value == stackMin.peek()) {
                stackMin.pop();
            }
            return value;
        }

        /**
         * 获取最小数
         *
         * @return
         */
        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("this stack is empty");
            }
            return stackMin.peek();
        }

    }

    public static class MyStack2 {
        private Stack<Integer> stackDate;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackDate = new Stack<>();
            this.stackMin = new Stack<>();
        }

        /**
         * 入栈
         *
         * @return
         */
        public void push(int newNum) {
            stackDate.push(newNum);
            // stackMin.isEmpty() || stackMin.getMin >= newNum
            if (stackMin.isEmpty() || stackMin.peek() >= newNum) {
                stackMin.push(newNum);
            } else {
                stackMin.push(stackMin.peek());
            }
        }

        /**
         * 出栈
         *
         * @return
         */
        public int pop() {
            if (stackDate.isEmpty() || stackMin.isEmpty()) {
                throw new RuntimeException("this stack is empty");
            }
            stackMin.pop();
            return stackDate.pop();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("this stack is empty");
            }
            return stackMin.peek();
        }
    }
}
