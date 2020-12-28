package algorithm12_20.ms;

import java.util.Stack;

/***
 * Implement Queue using Stacks
Easy

1444

156

Add to List

Share
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.
 
 https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {
	 private Stack<Integer> s1;
     private Stack<Integer> s2;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();

        //insert 1
        //s1    ,1,
        //s2    ,1
        
        //insert 2
        //s2.top = 1,
        //s1. remove 1,
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //copy the items from s1 to s2
        if(s2.isEmpty()){
           while(!s1.isEmpty()) {
               s2.push(s1.pop());
           }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //copy items from s1 to stack s2
        if(s2.isEmpty()){
           while(!s1.isEmpty()) {
               s2.push(s1.pop());
           }
        }
        return s2.peek(); 
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }
}
