package com.michaelmbugua;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList myList = new SinglyLinkedList();

        myList.push("Hi");
        myList.push("there");
        myList.push(",");
        myList.push("How");
        myList.push("are");
        myList.push("you");
        myList.push("?");

        Node returnedNode = myList.get(2);
//        Node poppedNode = myList.pop();
//        Node shiftedNode = myList.leftShift();
//        SinglyLinkedList newList = myList.unshift("NewHi");

    }
}

class Node {
    private String val;
    private Node next = null;

    public Node(String val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val='" + val + '\'' +
                ", next=" + next +
                '}';
    }
}


class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(Node head, Node tail, int length) {
        this.head = head;
        this.tail = tail;
        this.length = length;
    }


    public SinglyLinkedList push(String val) {
        Node newNode = new Node(val);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.length++;

        return this;
    }


    public Node pop() {
        Node preNode = head;
        Node postNode = head;

        if (this.length == 0) return null;

        while (postNode.getNext() != null) {
            preNode = postNode;
            postNode = postNode.getNext();
        }

        preNode.setNext(null);
        this.tail = preNode;
        this.length--;

        if (this.length == 0){
            this.head = null;
            this.tail = null;
        }

        return postNode;

    }

    public Node leftShift() {

        if (this.head == null) return null;

        Node shiftedHead = this.head;

        this.head = this.head.getNext();

        shiftedHead.setNext(null);

        this.length--;

        if (this.length == 0) this.tail = null;

    return shiftedHead;
    }

    public SinglyLinkedList unshift(String val) {

        Node newHead = new Node(val);

        if (this.length == 0){
            this.head = newHead;
            this.tail = newHead;
        }

        newHead.setNext(this.head);

        this.head = newHead;

        this.length++;

    return this;
    }

    public Node get(int index) {

        if (this.length < index) return null;

        Node returnNode = this.head;

        for (int i = 0; i < index; i++) {
            returnNode = returnNode.getNext();
        }
        return returnNode;
    }


    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}


// Got to Set in Singly Linked Lists (Thur 27th Jan 2022)