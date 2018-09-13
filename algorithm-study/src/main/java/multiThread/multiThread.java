package multiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cdyujing7 on 2018/9/11.
 */
public class multiThread {

    private AtomicInteger ticketNum = new AtomicInteger(0);

    private AtomicInteger owner = new AtomicInteger(0);

    private static final ThreadLocal<Integer> myTicketLocal = new ThreadLocal<Integer>();

    public void lock() {
        int myTicket = ticketNum.getAndIncrement();// 票据
        myTicketLocal.set(myTicket);
        while (myTicket != owner.get()) {

        }
    }
}
