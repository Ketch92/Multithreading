package sum;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
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
        List<SumCallableThread> callableThreads = getSumCallableThreads(partition);
        try {
            executorService.invokeAll(callableThreads);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error ", e);
        }
        int result = getResult(executorService, callableThreads);
        executorService.shutdownNow();
        return result;
    }
    
    private int getResult(ExecutorService executorService,
                          List<SumCallableThread> callableThreads) {
        int result = 0;
        for (SumCallableThread thread : callableThreads) {
            try {
                result += executorService.submit(thread).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error ", e);
            }
        }
        return result;
    }
    
    private List<SumCallableThread> getSumCallableThreads(List<List<Integer>> partition) {
        return partition.stream()
                .map(SumCallableThread::new)
                .collect(Collectors.toList());
    }
}
