package sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumWithCallableTest {
    private Summing summing;
    private SumWithForJoin wihForJoin;
    
    @BeforeEach
    void setUp() {
        summing = new Summing();
        wihForJoin = new SumWithForJoin(summing.getList());
    }
    
    @Test
    public void testRandomlyGeneratedList() {
        int expected = summing.getSum();
        int actual = wihForJoin.execute();
    
        Assertions.assertEquals(expected, actual);
    }
}
