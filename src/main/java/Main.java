public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread myThread = new MyThread(counter);
        Thread runnableThread = new Thread(new RunnableThead(counter));
        myThread.start();
        runnableThread.start();
    }
}
