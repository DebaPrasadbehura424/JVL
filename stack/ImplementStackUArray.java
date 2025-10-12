package stack;

public class ImplementStackUArray {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class stack {
        Node top;
        int size;

        stack() {
            top = null;
            size = 0;
        }

        public void push(int val) {
            Node node = new Node(val);
            node.next = top;
            top = node;
            size++;
        }

        public int peek() {
            if (top == null)
                return -1;
            return top.val;
        }

        public int pop() {
            if (top == null)
                return -1;
            int value = top.val;
            top = top.next;
            size--;
            return value;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        ImplementStackUArray impl = new ImplementStackUArray();
        stack s = impl.new stack();
        s.push(5);
        s.push(10);
        s.push(51);
        s.push(55);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
