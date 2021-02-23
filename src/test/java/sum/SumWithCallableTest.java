package sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumWithCallableTest {
    private Summing summing;
    private SumWihForJoin wihForJoin;
    
    @BeforeEach
    void setUp() {
        summing = new Summing();
        wihForJoin = new SumWihForJoin(summing.getList());
    }
    
    @Test
    public void testRandomlyGeneratedList() {
        int expected = summing.getSum();
        int actual = wihForJoin.execute();
    
        Assertions.assertEquals(expected, actual);
    }
}
