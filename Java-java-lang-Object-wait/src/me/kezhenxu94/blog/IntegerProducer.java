package me.kezhenxu94.blog;

/**
 * Created by kid on 2018/4/11.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class IntegerProducer implements Runnable {
    private int number = 0;

    private final Resources<Integer> resources;

    public IntegerProducer(Resources<Integer> resources) {
        this.resources = resources;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (resources) {
                    while (!resources.isEmpty()) {
                        resources.wait();
                    }
                    resources.set(number++);
                    resources.notifyAll();
                }
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
