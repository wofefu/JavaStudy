
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Eight {
    public static void main(String[] args) {
        data data = new data();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                data.increament();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                data.reduce();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                data.reduce();
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                data.reduce();
            }
        });
        t1.setName("生产者");
        t2.setName("消费者1");
        t3.setName("消费者2");
        t4.setName("消费者3");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class data {
    private ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();
    Condition condition1 = reentrantLock.newCondition();
    private AtomicInteger number = new AtomicInteger(0);

    public void increament() {
        reentrantLock.lock();
        try {
            while (number.get() != 0) {
                System.out.println("以生产商品等待消费");
                condition.await();
            }
            number.addAndGet(1);
            System.out.println(Thread.currentThread().getName() + "生产了1台");
            condition1.signal();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void reduce() {
        reentrantLock.lock();
        try {
            while (number.get() == 0) {
                System.out.println("已消费完");
                condition1.await();
            }
            number.addAndGet(-1);
            System.out.println(Thread.currentThread().getName() + "消费了1台");
            condition.signal();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}