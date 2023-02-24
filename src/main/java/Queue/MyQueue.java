package Queue;
import List.MyLinkedList;

public class MyQueue implements QueueInterface {

    private MyLinkedList queue;

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(Object item) {
        queue.add(queue.size(), item);
    }

    public Object dequeue() {
        if (queue.isEmpty()) {
            throw new QueueException("dequeue() called on empty list.");
        }
        Object obj = queue.get(0);
        queue.remove(0);
        return obj;
    }

    public void dequeueAll() {
        queue.removeAll();
    }

    public Object peek() {
        if (queue.isEmpty()) {
            throw new QueueException("peek() called on empty list.");
        }
        return queue.get(0);
    }

    public MyQueue() {
        queue = new MyLinkedList();
    }

    // Added a toString method to MyStack to make debugging easy
    public String toString() {
        return queue.toString();
    }

}
