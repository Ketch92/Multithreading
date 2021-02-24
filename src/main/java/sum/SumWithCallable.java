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
        List<CustomCallable> callableThreads = getSumCallableThreads(partition);
        try {
            executorService.invokeAll(callableThreads);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error ", e);
        }
        return getResult(executorService, callableThreads);
    }
    
    private int getResult(ExecutorService executorService,
                          List<CustomCallable> callableThreads) {
        int result = 0;
        for (CustomCallable thread : callableThreads) {
            try {
                result += executorService.submit(thread).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error ", e);
            }
        }
        return result;
    }
    
    private List<CustomCallable> getSumCallableThreads(List<List<Integer>> partition) {
        return partition.stream()
                .map(CustomCallable::new)
                .collect(Collectors.toList());
    }
}
