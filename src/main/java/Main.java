import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import sum.SumWithCallable;

public class Main {
    public static void main(String[] args) {
//        Counter counter = new Counter();
//        Thread myThread = new MyThread(counter);
//        Thread runnableThread = new Thread(new RunnableThead(counter));
//        myThread.start();
//        runnableThread.start();
        List<Integer> list = IntStream
                .range(0, 1_000_000)
                .map(i -> 1).boxed()
                .collect(Collectors.toList());

        SumWithCallable sumWithCallable = new SumWithCallable(list);
        System.out.println(sumWithCallable.execute());
    }
}
