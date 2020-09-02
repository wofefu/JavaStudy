/**
 * 定义两个线程（一个用继承Thread类，一个用实现Runnable接口），定义一个测试类包括一个主函数调用两个子线程（具体实现自定）
 */
public class Third {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadI());
        ThreadE thread1=new ThreadE();
        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread1.start();

    }
}
class ThreadE extends Thread{
    @Override
    public void run() {
        System.out.println("继承");
    }
}
class ThreadI implements Runnable{

    @Override
    public void run() {
        System.out.println("接口隔离原则，依赖倒转原则");
    }
}