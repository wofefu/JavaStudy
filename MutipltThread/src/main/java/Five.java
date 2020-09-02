/**
 * 编写龟兔赛跑多线程程序，设赛跑长度为100米，每跑完10米输出一次结果。
 */
public class Five {
    public static void main(String[] args) {
//        new Thread(()->{
//            for (int i = 0; i <10 ; i++) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("兔子跑了"+(i+1)*10+"米");
//            }
//        }).start();
//        new Thread(()->{
//            for (int i = 0; i <10 ; i++) {
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("乌龟跑了"+(i+1)*10+"米");
//            }
//        }).start();
       new Rabbit().start();
        new Turtle().start();
    }
}
class Rabbit extends Thread{

    @Override
    public void run() {
        super.setName("Rabbit");
        super.setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+(i+1)*10+"米");
        }
    }
}
class Turtle extends Thread{
    @Override
    public void run() {
        super.setName("Turtle");
        super.setPriority(Thread.NORM_PRIORITY);
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了"+(i+1)*10+"米");
        }
    }
}