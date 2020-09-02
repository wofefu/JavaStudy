/**
 * 启动两个线程对一个数字i操作
 * 1)其中1个线程每次对i加1
 * 2)另1个线程每次对i减1
 * 各运行20次，结果i的值等于初始值。
 */
public class Six {
    public static void main(String[] args) {
        Increase increase = new Increase();
        Thread thread=new Thread(increase);
        thread.setName("Increase");
        Thread thread1=new Thread(increase);
        thread1.setName("reduce");
        thread.start();
        thread1.start();
    }
}
class Increase implements Runnable{
    private static Object object=new Object();
    int i=0;
    @Override
    public void run() {
          if ("Increase".equals(Thread.currentThread().getName())){
              increase();
          }else {
              reduce();
          }
    }
    public void increase(){

            for (int j = 0; j <20 ; j++) {
                synchronized (object){
                i+=1;
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }

    }
    public void reduce(){
        for (int j = 0; j <20 ; j++) {
            synchronized (object){
                i-=1;
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
