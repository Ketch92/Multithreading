public class Counter {
    private int counter;
    
    public Counter() {
    }
    
    public int increment() {
        return counter++;
    }
    
    public int getCounter() {
        return counter;
    }
}
