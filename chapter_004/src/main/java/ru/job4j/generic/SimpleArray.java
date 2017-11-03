package ru.job4j.generic;


import java.util.Arrays;

public class SimpleArray<E> {
    /**
     * номер первого пустого элемента
     */
    private int index = 0;
    private Object[] arr;

    SimpleArray(int size) {
        this.arr = new Object[size];
    }

    public void add(E elem) {
        if (index == this.arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        this.arr[index++] = elem;
    }

    public E get(int position) throws OutOfSimpleArrayRangeException {
        if ((position < 0) || (position >= index)) {
            throw new OutOfSimpleArrayRangeException("Position is out of range");
        } else {
            return (E) this.arr[position];
        }
    }

    public void update(int position, E elem) {
        if ((position < 0) || (position >= index)) {
            throw new OutOfSimpleArrayRangeException("Position is out of range");
        } else {
            this.arr[position] = elem;
        }
    }

    public E delete(int position) {
        E result;
        if ((position < 0) || (position >= index)) {
            throw new OutOfSimpleArrayRangeException("Position is out of range");
        } else {
            result = (E) this.arr[position];
            for (int i = position; i < index - 1; i++) {
                this.arr[i] = this.arr[i + 1];
            }
            index--;
        }
        return result;
    }
    public int getLength() {
        return this.arr.length;
    }
}
