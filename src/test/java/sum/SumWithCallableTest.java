package sum;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumWithCallableTest {
    private IntegerListRandomGenerator generator;
    private SumWithForJoin wihForJoin;
    
    @BeforeEach
    void setUp() {
        generator = new IntegerListRandomGenerator();
        wihForJoin = new SumWithForJoin(generator.getList());
    }
    
    @Test
    public void testRandomlyGeneratedList() {
        int expected = getSum(generator.getList());
        int actual = wihForJoin.execute();
    
        Assertions.assertEquals(expected, actual);
    }
    
    private int getSum(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get();
    }
}
