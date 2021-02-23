package sum;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Summing {
    public static final int DEFAULT_SIZE = 1_000_000;
    public static final int DEFAULT_VALUE_BOUND = 100;
    private List<Integer> list;
    private int sum;
    
    public Summing() {
        this.list = getRandomValuesList();
        this.sum = sum();
    }
    
    public List<Integer> getList() {
        return list;
    }
    
    public int getSum() {
        return sum;
    }
    
    private List<Integer> getRandomValuesList() {
        return IntStream.range(0, DEFAULT_SIZE)
                .map(i -> new Random().nextInt(DEFAULT_VALUE_BOUND))
                .boxed()
                .collect(Collectors.toList());
    }
    
    private int sum() {
        return list.stream().mapToInt(i -> i).sum();
    }
}
