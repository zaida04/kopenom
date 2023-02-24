package org.kopenom;

public class LinkedListNode<T> {
    public T value;
    public LinkedListNode<T> next;

    public LinkedListNode(T value, LinkedListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public int size() {
        if(this.next == null) {
            if(this.value == null) return 0;
            return 1;
        }

        int length = 1;
        LinkedListNode acc = this;

        while(acc.next != null) {
            length++;
            acc = acc.next;
        }

        return length;
    }

    public void append(T input) {
        if(this.value == null && this.next == null) {
            this.value = input;
            return;
        }
        LinkedListNode acc = this;

        while(acc.next != null) {
            acc = acc.next;
        }

        acc.next = new LinkedListNode<T>(input, null);
    }

    public void insert(T input, int position) {
        LinkedListNode acc = this;
        int counter = 0;

        while(counter < position - 1) {
            counter += 1;
            acc = acc.next;
        }

        LinkedListNode temp = acc.next;
        acc.next = new LinkedListNode<T>(input, temp);
    }


}
