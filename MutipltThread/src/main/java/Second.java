import com.sun.deploy.net.proxy.ProxyUnavailableException;

/**
 * 利用多线程设计一个程序，同时输出 50 以内的奇数和偶数，以及当前运行的线程名。
 */
public class Second {
    public static void main(String[] args) {
        ThreadPrint threadPrint = new ThreadPrint();
        ThreadPrint threadPrint1 = new ThreadPrint();
        threadPrint.k=1;
        threadPrint1.k=2;
        threadPrint.start();
        threadPrint1.start();
    }

}
class ThreadPrint extends Thread{
    int k;
    @Override
    public void run(){
        int i=k;
        while (i<50){
            System.out.println(Thread.currentThread().getName()+"========="+i);
            i+=2;
        }
        System.out.println(Thread.currentThread().getName()+"=================="+"end!!");
    }
}