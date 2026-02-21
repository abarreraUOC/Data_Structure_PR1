package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;
import edu.uoc.ds.adt.util.Point;

public class PR1Stack {
    public final int CAPACITY;

    private Stack<Point> stack;

    public PR1Stack() {
        this(10);
    }

    public PR1Stack(int capacity) {
        this.CAPACITY = capacity;
        newStack();
    }

    public void newStack() {
        stack = new StackArrayImpl<>(CAPACITY);
    }

    public Stack<Point> getStack() {
        return this.stack;
    }

    public void push(Point p) {
        this.stack.push(p);
    }

    public Point pop() {
        return this.stack.pop();
    }
}