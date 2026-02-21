package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.adt.util.Point;

public class PR1Queue {

    public final int CAPACITY;

    private Queue<Point> queue;

    public PR1Queue() {
        this(10);
    }

    public PR1Queue(int capacity) {
        this.CAPACITY = capacity;
        newQueue();
    }

    public void newQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }

    public Queue<Point> getQueue() {
        return this.queue;
    }

    public void add(Point p) {
        this.queue.add(p);
    }

    public Point poll() {
        return this.queue.poll();
    }
}