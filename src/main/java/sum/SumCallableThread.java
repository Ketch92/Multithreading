package sum;

import java.util.List;
import java.util.concurrent.Callable;

public class SumCallableThread implements Callable<Integer> {
    private List<Integer> list;
    
    public SumCallableThread(List<Integer> list) {
        this.list = list;
    }
    
    @Override
    public Integer call() throws Exception {
        return list.stream().mapToInt(i -> i).sum();
    }
}
