

/**
 * 编写一个继承Thread类的方式实现多线程的程序。该类MyThread有两个属性，一个字符串WhoAmI代表线程名，一个整数delay代表该线程随机要休眠的时间。构造有参的构造器，
 * 线程执行时，显示线程名和要休眠时间。
 * 另外，定义一个测试类TestThread，创建三个线程对象以展示执行情况。
 */
public class First {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("a");
        MyThread thread2 = new MyThread("b");
        MyThread thread3 = new MyThread("c");
        thread1.start();
        thread2.start();
        thread3.start();
    }


}

class MyThread extends Thread{
    private String WhoAmI;
    private int delay= (int) (Math.random()*10);
    public MyThread(String name){
        this.WhoAmI=name;
    }
    @Override
    public void run() {
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名"+this.WhoAmI+"线程休眠"+delay);
    }
}