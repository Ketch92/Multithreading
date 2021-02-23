package sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumWihForJoinTest {
    private Summing summing;
    private SumWithCallable withCallable;
    
    @BeforeEach
    void setUp() {
        summing = new Summing();
        withCallable = new SumWithCallable(summing.getList());
    }
    
    @Test
    public void testRandomlyGeneratedList() {
        int expected = summing.getSum();
        int actual = withCallable.execute();
        
        Assertions.assertEquals(expected, actual);
    }
}