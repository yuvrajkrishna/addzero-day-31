import java.util.LinkedList;
import java.util.Queue;

public class implementstackusing2queue {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {

        push(10);
        push(20);
        push(30);

        System.out.println(q1);

        pop();

        System.out.println(q1);
    }

    public static void push(int val) {
        q1.add(val);
    }

    public static void pop() {

        if(q1.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        while(q1.size() > 1) {
            q2.add(q1.remove());
        }

        System.out.println("Popped: " + q1.remove());

        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }
}