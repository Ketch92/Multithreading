package sum;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerListRandomGenerator {
    public static final int DEFAULT_SIZE = 1_000_000;
    public static final int DEFAULT_VALUE_BOUND = 100;
    private List<Integer> list;
    
    public IntegerListRandomGenerator() {
        this.list = getRandomValuesList(DEFAULT_SIZE, DEFAULT_VALUE_BOUND);
    }
    
    public IntegerListRandomGenerator(int listSize, int valueBound) {
        this.list = getRandomValuesList(listSize, valueBound);
    }
    
    public List<Integer> getList() {
        return list;
    }
    
    private List<Integer> getRandomValuesList(int customSize, int valueBound) {
        return IntStream.range(0, customSize)
                .map(i -> new Random().nextInt(valueBound))
                .boxed()
                .collect(Collectors.toList());
    }
    
}
