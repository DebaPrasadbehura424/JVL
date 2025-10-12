package stack;

public class Main {
    class Stack {
        int arr[];
        int top;
        int capacity;

        Stack(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            top = -1;
        }

        public void push(int val) {
            if (top == capacity - 1)
                return;
            arr[++top] = val;
        }

        public void pop() {
            if (top == -1)
                return;
            top--;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public int peek() {
            if (top == -1)
                return -1;
            return arr[top];
        }
    }

    public static void main(String[] args) {
        Main impl = new Main();
        Stack s = impl.new Stack(10);
        s.push(5);
        s.push(10);
        s.push(15);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}