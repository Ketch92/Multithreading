package sum;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class SumWithForJoin {
    private static final int THREAD_COUNT = 4;
    private List<Integer> list;
    
    public SumWithForJoin(List<Integer> list) {
        this.list = list;
    }
    
    public Integer execute() {
        List<List<Integer>> partition = ListUtils.partition(list, list.size() / THREAD_COUNT);
        List<CustomRecursiveTask> recursiveTasks = partition.stream()
                .map(CustomRecursiveTask::new)
                .collect(Collectors.toList());
        return ForkJoinTask.invokeAll(recursiveTasks).stream()
                .map(ForkJoinTask::join).reduce(Integer::sum).get();
    }
}
