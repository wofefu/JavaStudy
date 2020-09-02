import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟3个人排除买票，每人买1张票。售货员只有1张五元的钱，电影票5元一张，王大拿拿一张二十元的人民币排在谢大脚前面买票，
 * 谢大脚拿1张十元的人民币排在在赵四的前面买票，赵四拿1张五元的人民币排在最后。即最终的卖票次序是：谢大脚、赵四、王大拿
 */
public class Seven {
}

class Person implements Runnable{
    public int tickets;
    public int money;

    public ReentrantLock reentrantLock;
    public Condition condition;
    public Condition condition1;
    public Condition condition2;

    public Person( int tickets, int money,  ReentrantLock reentrantLock, Condition condition, Condition condition1, Condition condition2) {

        this.tickets = tickets;
        this.money = money;

        this.reentrantLock = reentrantLock;
        this.condition = condition;
        this.condition1 = condition1;
        this.condition2 = condition2;
    }

    @Override
    public void run() {

    }
}
//class ZhaoSi implements Runnable{
//    public int tickets=0;
//    public int money=5;
//    @Override
//    public void run() {
//
//    }
//}
//class WangDaNa implements Runnable{
//    public int tickets=0;
//    public int money=20;
//    @Override
//    public void run() {
//
//    }
//}