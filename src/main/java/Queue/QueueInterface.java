package Queue;

public interface QueueInterface {
    public boolean isEmpty();

    public void enqueue(Object item);

    public Object dequeue();

    public void dequeueAll();

    public Object peek();
}
