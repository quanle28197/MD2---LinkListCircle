public class Solution {
    static void enQueue(Queue q, int value) {
        Node temp = new Node(value);
        temp.data = value;
        if (q.head == null)
            q.head = temp;
        else
            q.tail.next = temp;

        q.tail = temp;
        q.tail.next = q.head;
    }

    static int deQueue(Queue q) {
        if (q.head == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int value;
        if (q.head == q.tail) {
            value = q.head.data;
            q.head = null;
            q.tail = null;
        }else {
            Node temp = q.head;
            value = temp.data;
            q.head = q.head.next;
            q.tail.next = q.head;
        }
        return value;
    }

    static void displayQueue(Queue q) {
        Node temp = q.head;
        System.out.println("Element is circular Queue are: ");
        while (temp.next != q.head) {
            System.out.printf("\"%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d", temp.data);
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.head = q.tail = null;

        // Inserting elements in Circular Queue
        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, 6);

        // Display elements present in Circular Queue
        displayQueue(q);

        // Deleting elements from Circular Queue
        System.out.printf(" Deleted value = %d", deQueue(q));
        System.out.printf(" Deleted value = %d", deQueue(q));

        // Remaining elements in Circular Queue
        displayQueue(q);

        enQueue(q, 9);
        enQueue(q, 20);
        displayQueue(q);
    }
}
