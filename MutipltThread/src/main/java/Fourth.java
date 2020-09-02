/**
 * 模拟一个人生产50个玩具，每200毫秒生产一个，当生产到第20个时加入每秒吃1个馒头，共吃完3个后在接着生产的多线程。
 */
public class Fourth {
    public static void main(String[] args) {
        Thread thread = new Thread(new PlayClass());

        thread.start();
    }
}

class JoinClass implements Runnable {

    @Override
    public void run() {
        for (int j = 0; j < 3; j++) {
            System.out.println(Thread.currentThread().getName()+"吃完" + (j + 1) + "个馒头");
        }
    }
}

class PlayClass implements Runnable {

    @Override
    public void run() {
        Thread thread = new Thread(new JoinClass());
        int i = 0;
        while (i < 50) {
            try {
                if (i == 20) {
                    thread.start();
                    thread.join();
                }
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName()+"生产了" + (i + 1) + "玩具");
                i += 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}