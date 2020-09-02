/**
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 */
public class Ticket {
    public  int tickets = 100;

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(new sale(ticket));
        t1.setName("A");
        Thread t2 = new Thread(new sale(ticket));
        t2.setName("B");
        Thread t3 = new Thread(new sale(ticket));
        t3.setName("C");
        t1.start();
        t2.start();
        t3.start();
    }

}

class sale implements Runnable {
    private Ticket t;

    public sale(Ticket tickets) {
        t = tickets;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (t) {
                if (t.tickets==0){
                    break;
                }
                t.tickets -= 1;
                System.out.println(Thread.currentThread().getName()+"票数剩余"+t.tickets);
            }
        }
    }
}