package me.kezhenxu94.blog;

/**
 * Created by kid on 2018/4/11.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Consumer<T> implements Runnable {
    private final Resources<T> resources;

    public Consumer(Resources<T> resources) {
        this.resources = resources;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (resources) {
                    while (resources.isEmpty()) {
                        resources.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + resources.get());
                    resources.notifyAll();
                }
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
