package sum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.collections4.ListUtils;

public class SumWithCallable {
    private static final int THREAD_COUNT = 4;
    private List<Integer> list;
    
    public SumWithCallable(List<Integer> list) {
        this.list = list;
    }
    
    public int execute() {
        List<List<Integer>> partition = ListUtils.partition(list, list.size() / THREAD_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<SumCallableThread> callableThreads = new ArrayList<>();
        for (List<Integer> subList : partition) {
            callableThreads.add(new SumCallableThread(subList));
        }
        try {
            executorService.invokeAll(callableThreads);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error ", e);
        }
        int result = 0;
        for (SumCallableThread thread : callableThreads) {
            try {
                result += executorService.submit(thread).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error ", e);
            }
        }
        executorService.shutdownNow();
        return result;
    }
}
