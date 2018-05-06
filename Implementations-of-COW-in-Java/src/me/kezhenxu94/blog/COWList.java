package me.kezhenxu94.blog;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kid on 2018/4/22.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class COWList<T> implements List<T> {
    private Object[] array;
    private ReentrantLock lock = new ReentrantLock();

    public COWList() {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return new COWIterator<>(array);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        lock.lock();
        try {
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    class COWIterator<E> implements ListIterator<E> {
        private int index = 0;

        private final Object[] array;

        COWIterator(Object[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            return (E) array[index++];
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E previous() {
            return (E) array[index--];
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E t) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E t) {
            throw new UnsupportedOperationException();
        }
    }
}
