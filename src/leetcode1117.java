import java.util.concurrent.Semaphore;

/**
 * Created by xuanmao on 2020/5/5.
 */
public class leetcode1117 {

    class H2O {

        private Semaphore h = new Semaphore(2);
        private Semaphore o = new Semaphore(0);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            o.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h.release();

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            h.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            o.release(2);
        }
    }
}
