import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class dequeue {

    static int deque[] = new int[5];
    static int front = -1;
    static int rear = 0;

    // Insert from front
    static void insertAtFront(int value) {

        if ((front == 0 && rear == deque.length - 1) ||
            (front == rear + 1)) {

            System.out.println("Deque is full");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        }

        // Front is at 0, so move it to last
        else if (front == 0) {
            front = deque.length - 1;
        }

        // Otherwise move front one position back
        else {
            front--;
        }

        deque[front] = value;
    }

    // Insert from rear
    static void insertAtRear(int value) {

        if ((front == 0 && rear == deque.length - 1) ||
            (front == rear + 1)) {

            System.out.println("Deque is full");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        }

        // Rear is at last, move it to 0
        else if (rear == deque.length - 1) {
            rear = 0;
        }

        // Otherwise move rear forward
        else {
            rear++;
        }

        deque[rear] = value;
    }

    // Delete from front
    static void deleteAtFront() {

        if (front == -1) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Deleted: " + deque[front]);

        // Only one element
        if (front == rear) {
            front = -1;
            rear = 0;
        }

        // Front is at last index
        else if (front == deque.length - 1) {
            front = 0;
        }

        else {
            front++;
        }
    }

    // Delete from rear
    static void deleteAtRear() {

        if (front == -1) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Deleted: " + deque[rear]);

        // Only one element
        if (front == rear) {
            front = -1;
            rear = 0;
        }

        // Rear is at 0
        else if (rear == 0) {
            rear = deque.length - 1;
        }

        else {
            rear--;
        }
    }

    // Peek front
    static void peekFront() {

        if (front == -1) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Front: " + deque[front]);
    }

    // Peek rear
    static void peekRear() {

        if (front == -1) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Rear: " + deque[rear]);
    }

    static void display() {

        if (front == -1) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.print("Deque: ");

        int i = front;

        while (true) {

            System.out.print(deque[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % deque.length;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        insertAtFront(10);
        insertAtRear(20);

        insertAtRear(30);
        insertAtRear(40);

        display();

        peekFront();
        peekRear();

        
        display();

        display();

        insertAtRear(50);
        insertAtRear(60);

        display();

        Queue<Integer> queue = new LinkedList<>();
        int k = 2;
        for(int i = 0 ; i < k ; i++){
            queue.add(deque[front]);
            deleteAtFront();
        }
            System.out.println(queue);
        for(int i = 0 ; i < k; i++){
            insertAtFront(queue.remove());
        }
        System.out.println(queue);
        System.out.println(Arrays.toString(deque));
    }
}