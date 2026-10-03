import java.util.LinkedList;
import java.util.Queue;

public class implementstackusing2queueinsertheavy {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {

        push(10);
        push(20);
        push(30);

        System.out.println(q1);

        pop();
        System.out.println(q1);

        pop();
        System.out.println(q1);
    }

    // INSERT HEAVY
    public static void push(int val) {

        // New element first
        q2.add(val);

        // Move all old elements behind it
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // O(1)
    public static void pop() {

        if (q1.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Popped: " + q1.remove());
    }
}