//the correct and most efficient implementation
class StackUsingQueue {

    Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> swap = new LinkedList<>();

        swap.add(x);

        while(!queue.isEmpty()){
            swap.add(queue.remove());
        }

        queue = swap;
    }

    // Removes the element on top of the stack.
    public void pop() {
        // pop from front
        queue.remove();
    }

    // Get the top element.
    public int top() {
        // peek from front
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

//Alternate and a little bit inefficient technique
public class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList();

    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i = 1; i< queue1.size(); i++) {
            queue1.add(queue1.remove());
        }
        queue1.remove();
    }

    // Get the top element.
    public int top() {
        for(int i = 1; i< queue1.size(); i++) {
            queue1.add(queue1.remove());
        }
        int i = queue1.peek();
        queue1.add(queue1.remove());
        return i;

    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}
