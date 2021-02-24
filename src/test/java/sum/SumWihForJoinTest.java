package sum;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumWihForJoinTest {
    private IntegerListRandomGenerator generator;
    private SumWithCallable withCallable;
    
    @BeforeEach
    void setUp() {
        generator = new IntegerListRandomGenerator();
        withCallable = new SumWithCallable(generator.getList());
    }
    
    @Test
    public void testRandomlyGeneratedList() {
        int expected = getSum(generator.getList());
        int actual = withCallable.execute();
        
        Assertions.assertEquals(expected, actual);
    }
    
    private int getSum(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get();
    }
}
