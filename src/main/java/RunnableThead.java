import org.apache.log4j.Logger;

public class RunnableThead implements Runnable {
    private static final Logger logger = Logger.getLogger(RunnableThead.class);
    private Counter counter;
    
    public RunnableThead(Counter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        while (counter.getCounter() <= 1000) {
            logger.info("Runnable thread " + counter.increment());
        }
    }
}
