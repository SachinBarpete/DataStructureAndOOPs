package com.bridgelabz.datastructure.deque;

public class Deque<T> {
	
    private Node<T> front;
    private Node<T> rear;
     
    public void insertFront(T item){
        //add element at the beginning of the queue
        //System.out.println("adding at front: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setNext(front);
        if(front != null) front.setPrev(nd);
        if(front == null) rear = nd;
        front = nd;
    }
     
    public void insertRear(T item){
        //add element at the end of the queue
        //System.out.println("adding at rear: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setPrev(rear);
        if(rear != null) rear.setNext(nd);
        if(rear == null) front = nd;
         
        rear = nd;
    }
     
    public T removeFront(){
        if(front == null){
            System.out.println("Deque underflow!! unable to remove.");
            return null;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpFront = front.getNext();
        if(tmpFront != null) tmpFront.setPrev(null);
        if(tmpFront == null) rear = null;
        //System.out.println("removed from front: "+front.getValue());
        T value = front.getValue();
        front = tmpFront;
        return value;
    }
     
    public T removeRear(){
        if(rear == null){
            System.out.println("Deque underflow!! unable to remove.");
            return null;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpRear = rear.getPrev();
        if(tmpRear != null) tmpRear.setNext(null);
        if(tmpRear == null) front = null;
        //System.out.println("removed from rear: "+rear.getValue());
        T value= rear.getValue();
        rear = tmpRear;
        return value;
    }
     
}