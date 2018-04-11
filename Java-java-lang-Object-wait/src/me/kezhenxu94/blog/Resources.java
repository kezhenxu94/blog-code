package me.kezhenxu94.blog;

/**
 * Created by kid on 2018/4/11.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Resources<T> {
    private T t;

    public T get() {
        T temp = t;
        t = null;
        return temp;
    }

    public void set(T t) {
        this.t = t;
    }

    public boolean isEmpty() {
        return t == null;
    }
}
