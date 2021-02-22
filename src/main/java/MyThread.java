import org.apache.log4j.Logger;

public class MyThread extends Thread {
    public static final int LIMIT = 1000;
    private static final Logger logger = Logger.getLogger(MyThread.class);
    private Counter counter;
    
    public MyThread(Counter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        while (counter.getCounter() <= LIMIT) {
            logger.info("Thread " + counter.increment());
        }
    }
}
